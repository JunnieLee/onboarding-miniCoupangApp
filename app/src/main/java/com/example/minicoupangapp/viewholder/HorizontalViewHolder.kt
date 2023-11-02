package com.example.minicoupangapp.viewholder

import com.example.minicoupangapp.ListAdapter
import com.example.minicoupangapp.databinding.ItemHorizontalBinding
import com.example.minicoupangapp.model.Horizontal
import com.example.minicoupangapp.model.ListItem

class HorizontalViewHolder(
    private val binding : ItemHorizontalBinding
) : BindingViewHolder<ItemHorizontalBinding>(binding) {
    private val adapter = ListAdapter()

    init {
        binding.listView.adapter = adapter
    }

    override fun bind(item: ListItem) {
        super.bind(item)
        item as Horizontal
        binding.titleTextView.text = item.title
        adapter.submitList(item.items)
    }

}