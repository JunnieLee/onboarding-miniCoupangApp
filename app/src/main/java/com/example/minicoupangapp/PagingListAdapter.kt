package com.example.minicoupangapp

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import com.example.minicoupangapp.model.ListItem
import com.example.minicoupangapp.viewholder.BindingViewHolder
import com.example.minicoupangapp.viewholder.ViewHolderGenerator

class PagingListAdapter : PagingDataAdapter<ListItem, BindingViewHolder<*>>(DiffCallback()) {
    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        return item?.viewType?.ordinal ?:-1 // ordinal : 호출하는 Enum value의 인덱스를 반환합니다.
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder<*> {
        return ViewHolderGenerator.get(parent, viewType) // 일괄적으로 처리해주는 애를 만들었기 때문에 여기는 이렇게 간단히 표현 가능
    }

    override fun onBindViewHolder(holder: BindingViewHolder<*>, position: Int) {
        val item = getItem(position)
        if (item != null){
            holder.bind(item) // 뷰홀더랑 실제 아이템 데이터랑 결합
        }
    }
}