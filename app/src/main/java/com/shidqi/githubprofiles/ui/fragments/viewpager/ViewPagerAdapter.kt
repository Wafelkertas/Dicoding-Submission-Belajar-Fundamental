package com.shidqi.githubprofiles.ui.fragments.viewpager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.shidqi.githubprofiles.R
import com.shidqi.githubprofiles.ui.fragments.ProfileFollowFragment

class ViewPagerAdapter(
    fragment: Fragment,
    val username: String
) : FragmentStateAdapter(fragment) {
    inner class ViewPagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    private val tab = listOf(
        "Follower",
        "Following"
    )


    override fun createFragment(position: Int): Fragment =
        ProfileFollowFragment.newInstance(position, username)


    override fun getItemCount(): Int {
        return tab.size
    }


}