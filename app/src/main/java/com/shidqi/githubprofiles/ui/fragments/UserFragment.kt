package com.shidqi.githubprofiles.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayoutMediator
import com.shidqi.githubprofiles.R
import com.shidqi.githubprofiles.models.UserSearch
import com.shidqi.githubprofiles.ui.SearchActivity
import com.shidqi.githubprofiles.ui.fragments.viewpager.ViewPagerAdapter
import com.shidqi.githubprofiles.ui.viewmodel.UserViewModel
import com.shidqi.githubprofiles.utils.Resource
import kotlinx.android.synthetic.main.fragment_user.*


class UserFragment : Fragment(R.layout.fragment_user) {


    private val TAG = "ProfileFollowFragment"

    lateinit var userViewModel: UserViewModel
    val args: UserFragmentArgs by navArgs()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userViewModel = (activity as SearchActivity).userViewModel

        profile_btn_back.setOnClickListener {
            findNavController().navigateUp()
        }

        user_toolbar.apply {
            inflateMenu(R.menu.main_menu)
            setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.action_home_setting -> {
                        val action = UserFragmentDirections.actionUserFragmentToSettingsFragment()
                        findNavController().navigate(action)
                    }
                }
                false
            }
        }


        val detail = args.detail
        val username = detail.login



        profile_tv_name.text = username

        searchName(username)


        Log.d("username 1", "$username")


        val avatarImage = detail.avatar_url
        Glide.with(this)
            .load(avatarImage)
            .into(profile_img_profile)


        val pagerAdapter = ViewPagerAdapter(this, username)
        profile_viewPager.adapter = pagerAdapter



        TabLayoutMediator(profile_tabLayout, profile_viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "Follower"
                1 -> tab.text = "Following"
            }
        }.attach()


        fab.setOnClickListener{
            userViewModel.savedProfile(detail)
            Snackbar.make(view, "Profile favorited", Snackbar.LENGTH_SHORT).show()
        }


    }

    private fun searchName(username: String) {
        userViewModel = (activity as SearchActivity).userViewModel
        username.let {
            userViewModel.searchNama(username)
        }
        userViewModel.githubName.observe(viewLifecycleOwner, Observer{
            profile_tv_username.text = it.data?.name
            Log.d("nama", "${it.data?.name}")
        })

    }


}