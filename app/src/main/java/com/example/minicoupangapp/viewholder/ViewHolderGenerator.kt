package com.example.minicoupangapp.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.example.minicoupangapp.databinding.ItemEmptyBinding
import com.example.minicoupangapp.model.ViewType

// 만든 목적 : ListAdapter의 createView 부분에서 이걸 호출할껀데,
// 각 ViewType에 맞는 ViewHolder들을 return시켜주기 위한 역할을 해줄꺼임
// 이걸 따로 빼는 이유는, 다양한 뷰타입에 대응할 수 있는 뷰홀더를 한곳에서 한꺼번에 관리할 수 있게 해주기 위함임.
object ViewHolderGenerator { // kotlin에서는 object라는 키워드로 singleton 객체를 지원

    fun get(
        parent:ViewGroup,
        viewType:Int
    ): BindingViewHolder<*>{
        return when (viewType) {
            ViewType.VIEW_PAGER.ordinal -> ViewPagerViewHolder(parent.toBinding())
            ViewType.HORIZONTAL.ordinal -> HorizontalViewHolder(parent.toBinding())
            ViewType.FULL_AD.ordinal ->FullAdViewHolder(parent.toBinding())

            ViewType.COUPON.ordinal -> CouponViewHolder(parent.toBinding())
            ViewType.IMAGE.ordinal -> ImageViewHolder(parent.toBinding())
            ViewType.SELL_ITEM.ordinal -> SellItemViewHolder(parent.toBinding())
            ViewType.SALE.ordinal -> SaleViewHolder(parent.toBinding())

            else -> ItemViewHolder(parent.toBinding())
        }
    }

    class ItemViewHolder(binding:ItemEmptyBinding) : BindingViewHolder<ItemEmptyBinding>(binding)

    // view가 inflate될때 좀더 간결히 표현하기 위해 (공통화 처리하기 위해) 만들어준 inline extension function
    private inline fun <reified V: ViewBinding> ViewGroup.toBinding() : V {
        return V::class.java.getMethod(
            "inflate",
            LayoutInflater::class.java,
            ViewGroup::class.java,
            Boolean::class.java
        ).invoke(null, LayoutInflater.from(context), this, false) as V
    }
}