package com.shidqi.githubprofiles.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.shidqi.githubprofiles.R
import kotlinx.android.synthetic.main.fragment_user.*
import kotlinx.android.synthetic.main.fragment_user.view.*


class UserFragment: Fragment(R.layout.fragment_user){


    val args: UserFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val detail = args.detail

        profile_tv_name.text = detail.login

        view.profile_tv_username.setText(detail.followers_url)

        val avatarImage = detail.avatar_url
        Glide.with(this)
            .load(avatarImage)
            .into(profile_img_profile)






    }

}