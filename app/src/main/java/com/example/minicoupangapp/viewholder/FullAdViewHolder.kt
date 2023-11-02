package com.example.minicoupangapp.viewholder

import com.example.minicoupangapp.databinding.ItemFullAdBinding

class FullAdViewHolder(
    val binding: ItemFullAdBinding
): BindingViewHolder<ItemFullAdBinding>(binding)

// 이건 xml에서 이미 item을 넘겨받고 그 안에서 다 처리하기 때문에 여기서 따로 더 해줘야하는 부분은 없음