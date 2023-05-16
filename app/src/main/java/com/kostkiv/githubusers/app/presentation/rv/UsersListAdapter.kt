package com.kostkiv.githubusers.app.presentation.rv

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.kostkiv.githubusers.R
import com.kostkiv.githubusers.databinding.GitHubUserItemBinding
import com.kostkiv.githubusers.domain.User

class UsersListAdapter(private val context : Context)
    : ListAdapter<User, UserViewHolder>(UserDiffCallback) {

    var onUserClickListener : ((String) -> Unit)? = null
    var onListEnded : ((Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = GitHubUserItemBinding.inflate(LayoutInflater.from(
            parent.context), parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = getItem(position)
        with(holder.binding) {
            textViewUsername.text = user.login
            textViewId.text = String.format(context.getString(R.string.id_label), user.userId)
            Glide.with(holder.itemView.context)
                .load(user.avatarUrl)
                .error(R.drawable.error)
                .into(imageViewAvatar)
            root.setOnClickListener {
                onUserClickListener?.invoke(user.login)
            }
            if(position == itemCount - 3) {
                onListEnded?.invoke(getItem(position + 2).userId)
            }
        }
    }
}