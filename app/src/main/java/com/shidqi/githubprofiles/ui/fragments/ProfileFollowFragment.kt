package com.shidqi.githubprofiles.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.shidqi.githubprofiles.R
import com.shidqi.githubprofiles.adapters.FollowerAdapter
import androidx.lifecycle.Observer
import com.shidqi.githubprofiles.ui.SearchActivity
import com.shidqi.githubprofiles.ui.viewmodel.ProfileViewModel
import com.shidqi.githubprofiles.utils.ARG_FRAGMENT_KEY
import com.shidqi.githubprofiles.utils.Constants.Companion.ARG_FRAGMENT_VALUE_USER
import com.shidqi.githubprofiles.utils.Resource
import kotlinx.android.synthetic.main.fragment_profile_follow.*
import kotlinx.android.synthetic.main.fragment_profile_follow.profileFollow_progressBar


class ProfileFollowFragment : Fragment(R.layout.fragment_profile_follow) {

    companion object {
        fun newInstance(key: Int, username: String): ProfileFollowFragment {
            val bundle = Bundle().apply {
                putInt(ARG_FRAGMENT_KEY, key)
                putString(ARG_FRAGMENT_VALUE_USER, username)
            }

            return ProfileFollowFragment().apply {
                arguments = bundle
            }
        }
    }


    lateinit var profileViewModel: ProfileViewModel
    lateinit var followerAdapter: FollowerAdapter
    private val TAG = "ProfileFollowFragment"


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val konci = arguments?.getInt(ARG_FRAGMENT_KEY)
        val username = arguments?.getString(ARG_FRAGMENT_VALUE_USER).toString()
        Log.d("username 2", username)

        let {
            if (konci == 0) {
                username.let { observeFollowers(it) }
            } else {
                username.let { observeFollowing(it) }
            }
        }

        setupRecyclerView()


        profileViewModel = (activity as SearchActivity).profileViewModel


    }

    private fun observeFollowers(username: String) {
        profileViewModel = (activity as SearchActivity).profileViewModel
        username.let { profileViewModel.searchProfileFollower(it) }
        profileViewModel.searchFollower.observe(viewLifecycleOwner, Observer { response ->
            when (response) {
                is Resource.Success -> {
                    hideProgressBar()
                    response.data?.let { searchResponse ->
                        followerAdapter.setList(searchResponse)
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

    private fun observeFollowing(username: String) {
        profileViewModel = (activity as SearchActivity).profileViewModel
        username.let { profileViewModel.searchProfileFollowing(it) }
        profileViewModel.searchFollowing.observe(viewLifecycleOwner, Observer { response ->
            when (response) {
                is Resource.Success -> {
                    hideProgressBar()
                    response.data?.let { searchResponse ->
                        followerAdapter.setList(searchResponse)
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
        profileFollow_progressBar.visibility = View.VISIBLE
    }

    private fun hideProgressBar() {
        profileFollow_progressBar.visibility = View.INVISIBLE
    }

    private fun setupRecyclerView() {
        followerAdapter = FollowerAdapter()
        profileFollow_rv_userFollow.apply {
            adapter = followerAdapter
            layoutManager = LinearLayoutManager(activity)
        }

    }

}





