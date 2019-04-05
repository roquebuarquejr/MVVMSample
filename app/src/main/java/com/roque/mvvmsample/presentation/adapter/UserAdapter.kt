package com.roque.mvvmsample.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.roque.api.GithubUser
import com.roque.mvvmsample.R
import kotlinx.android.synthetic.main.item_user.view.*

class UserAdapter(private val user: List<GithubUser>) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false))

    override fun getItemCount() = user.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(user[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(user: GithubUser) {
            itemView.txtUserLogin.text = user.login

            Glide.with(itemView.context)
                    .load(user.avatar)
                    .apply(RequestOptions.bitmapTransform(CircleCrop()))
                    .into(itemView.imgUser)
        }

    }

}