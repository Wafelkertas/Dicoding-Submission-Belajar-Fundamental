package com.shidqi.githubprofiles.ui.fragments.viewpager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.shidqi.githubprofiles.R
import com.shidqi.githubprofiles.ui.fragments.ProfileFollowFragment

class ViewPagerAdapter (fragment: Fragment
) : FragmentStateAdapter(fragment) {
    inner class ViewPagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)



    //    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user_preview, parent, false)
//        return ViewPagerViewHolder(view)
//    }
    override fun createFragment(position: Int): Fragment = ProfileFollowFragment()

    override fun getItemCount(): Int = 2

//    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
//        return
//
//    }
}