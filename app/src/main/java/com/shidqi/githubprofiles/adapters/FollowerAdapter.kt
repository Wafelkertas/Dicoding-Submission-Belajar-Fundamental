package com.shidqi.githubprofiles.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shidqi.githubprofiles.R
import kotlinx.android.synthetic.main.item_user_preview.view.*

class FollowerAdapter : RecyclerView.Adapter<FollowerAdapter.FollowerViewHolder>() {

    inner class FollowerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    val test = listOf(
        "test",
        "test",
        "test",
        "test",
        "test"
    )

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
        return test.size
    }

    override fun onBindViewHolder(holder: FollowerViewHolder, position: Int) {
        holder.itemView.apply {
            tvTitle.text = test.toString()

        }
    }


}