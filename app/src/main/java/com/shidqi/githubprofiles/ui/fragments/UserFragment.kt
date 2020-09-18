package com.shidqi.githubprofiles.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.google.android.material.tabs.TabLayoutMediator
import com.shidqi.githubprofiles.R
import com.shidqi.githubprofiles.ui.fragments.viewpager.ViewPagerAdapter
import kotlinx.android.synthetic.main.fragment_user.*
import kotlinx.android.synthetic.main.fragment_user.view.*


class UserFragment: Fragment(R.layout.fragment_user){


    val args: UserFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val detail = args.detail

        profile_tv_name.text = detail.login

        profile_tv_username.text = detail.name

        val avatarImage = detail.avatar_url
        Glide.with(this)
            .load(avatarImage)
            .into(profile_img_profile)


        val pagerAdapter = ViewPagerAdapter(this)
        profile_viewPager.adapter = pagerAdapter



        TabLayoutMediator(profile_tabLayout, profile_viewPager) { tab, position ->
            tab.text = "${position}"
        }.attach()

    }


}