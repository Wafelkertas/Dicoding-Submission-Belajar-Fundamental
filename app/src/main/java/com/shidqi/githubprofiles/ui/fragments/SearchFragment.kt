package com.shidqi.githubprofiles.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.shidqi.githubprofiles.R
import com.shidqi.githubprofiles.adapters.ItemAdapter
import com.shidqi.githubprofiles.ui.viewmodel.ItemViewModel
import com.shidqi.githubprofiles.ui.SearchActivity
import com.shidqi.githubprofiles.utils.Constants.Companion.SEARCH_USER_TIME_DELAY
import com.shidqi.githubprofiles.utils.Resource
import kotlinx.android.synthetic.main.fragment_search_user.*
import kotlinx.coroutines.Job
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class SearchFragment: Fragment(R.layout.fragment_search_user){

    val TAG = "SearchFragments"
    lateinit var viewModel : ItemViewModel
    lateinit var itemAdapter : ItemAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as SearchActivity).viewModel1
        setupRecyclerView()

        itemAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable("detail", it)
            }
            findNavController().navigate(
                R.id.action_searchUserFragment_to_userFragment,
                bundle
            )
        }

        var job: Job? = null
        etSearch.addTextChangedListener { editable ->
            job?.cancel()
            job = MainScope().launch {
                delay(SEARCH_USER_TIME_DELAY)
                editable?.let {
                    if (editable.toString().isNotEmpty()){
                        viewModel.searchUsers(editable.toString())
                    }
                }
            }
        }

        viewModel.searchUsers.observe(viewLifecycleOwner, Observer { response ->
            when(response){
                is Resource.Success -> {
                    hideProgressBar()
                    response.data?.let {searchResponse ->
                        itemAdapter.differ.submitList(searchResponse.items)
                    }
                }
                is Resource.Error -> {
                    hideProgressBar()
                    response.let { message ->
                        Log.e(TAG, "an error occured: $message")
                    }
                }
                is Resource.Loading -> {
                    showProgressBar()
                }
            }
        })
    }

    private fun showProgressBar() {
        paginationProgressBar.visibility = View.VISIBLE
    }

    private fun hideProgressBar() {
        paginationProgressBar.visibility = View.INVISIBLE
    }

    private fun setupRecyclerView(){
        itemAdapter = ItemAdapter()
        rvSearchUser.apply {
            adapter = itemAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

}