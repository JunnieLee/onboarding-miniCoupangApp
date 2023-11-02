package com.example.minicoupangapp.viewholder

import com.example.minicoupangapp.ListAdapter
import com.example.minicoupangapp.databinding.ItemViewpagerBinding
import com.example.minicoupangapp.model.ListItem
import com.example.minicoupangapp.model.ViewPager

class ViewPagerViewHolder (
    binding : ItemViewpagerBinding
): BindingViewHolder<ItemViewpagerBinding>(binding){
    private val adapter = ListAdapter()

    init {
        binding.viewpager.adapter = adapter // adapter 연결
    }

    override fun bind(item: ListItem) {
        super.bind(item)
        item as ViewPager
        adapter.submitList(item.items) // adapter에 data 넘겨주기
    }
}