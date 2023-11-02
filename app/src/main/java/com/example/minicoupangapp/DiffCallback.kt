package com.example.minicoupangapp

import androidx.recyclerview.widget.DiffUtil
import com.example.minicoupangapp.model.ListItem

// ListAdapter를 위한 DiffCallback
class DiffCallback<T: ListItem> : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem.viewType == newItem.viewType && oldItem.getKey() == newItem.getKey()
    }

    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem == newItem
    }

}