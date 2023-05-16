package com.kostkiv.githubusers.app.presentation.rv

import androidx.recyclerview.widget.DiffUtil
import com.kostkiv.githubusers.domain.User

object UserDiffCallback : DiffUtil.ItemCallback<User>() {

    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.userId == newItem.userId
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }
}