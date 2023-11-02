package com.example.minicoupangapp.viewholder

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.minicoupangapp.model.ListItem

import com.example.minicoupangapp.BR

// 공통화 처리된 뷰홀더
abstract class BindingViewHolder<VB:ViewDataBinding>(
    private val binding : VB
) : RecyclerView.ViewHolder(binding.root) {

    protected var item : ListItem?=null

    open fun bind(item:ListItem){
        this.item = item
        binding.setVariable(BR.item)
    }

}