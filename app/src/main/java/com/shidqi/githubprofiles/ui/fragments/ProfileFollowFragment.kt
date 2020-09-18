package com.shidqi.githubprofiles.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.shidqi.githubprofiles.R
import com.shidqi.githubprofiles.adapters.FollowerAdapter
import kotlinx.android.synthetic.main.fragment_profile_follow.*
import kotlinx.android.synthetic.main.fragment_search_user.*



class ProfileFollowFragment: Fragment(R.layout.fragment_profile_follow){

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()



    }

    private fun setupRecyclerView(){
        val followerAdapter = FollowerAdapter()
        profileFollow_rv_userFollow.apply {
            adapter = followerAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

}