package com.shidqi.githubprofiles.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.shidqi.githubprofiles.R
import com.shidqi.githubprofiles.models.Item
import com.shidqi.githubprofiles.models.UserSearch
import kotlinx.android.synthetic.main.fragment_user.*
import kotlinx.android.synthetic.main.item_user_preview.view.*

class FollowerAdapter : RecyclerView.Adapter<FollowerAdapter.FollowerViewHolder>() {

    inner class FollowerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    private var list: List<UserSearch> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowerAdapter.FollowerViewHolder {
        return FollowerViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_user_preview,
                parent,
                false
        )
        )
    }


    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: FollowerViewHolder, position: Int) {
        val data = list[position]
        val dpImage = data.avatar_url
        holder.itemView.apply {
            tvTitle.text = data.login
            Glide.with(this)
                .load(dpImage)
                .into(ivUserImage)


        }
    }

    //fungsi untuk mengubah list ke dalam adapter
    fun setList(list: List<UserSearch>) {
        this.list = list
        notifyDataSetChanged()
    }


}