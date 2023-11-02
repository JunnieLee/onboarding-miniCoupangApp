package com.example.minicoupangapp.remote

import com.example.minicoupangapp.model.Coupon
import com.example.minicoupangapp.model.Empty
import com.example.minicoupangapp.model.FullAd
import com.example.minicoupangapp.model.Horizontal
import com.example.minicoupangapp.model.Image
import com.example.minicoupangapp.model.ListItem
import com.example.minicoupangapp.model.Sale
import com.example.minicoupangapp.model.SellItem
import com.example.minicoupangapp.model.ViewPager
import com.example.minicoupangapp.model.ViewType
import com.google.gson.GsonBuilder
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

class ListItemDeserializer : JsonDeserializer<ListItem> {
    override fun deserialize(
        json: JsonElement,
        typeOfT: Type,
        context: JsonDeserializationContext
    ): ListItem {

        val viewTypeName = json.asJsonObject.getAsJsonPrimitive("viewType").asString
        val gson = GsonBuilder() // 이 list item 안에도 또 list item이 존재하기 때문에 여기서 이 부분을 deserialize 해주는 부분까지 넣어줘야함.
            // 안그러면 가장 바깥 뷰타입만 파싱해올 수 있고 그 안쪽에 있는 자식 list item view type은 파싱해올 수 없기 떄문에 반드시 이 부분도 추가가 되어야함.
            .registerTypeAdapter(ListItem::class.java, ListItemDeserializer()) // 지금 만들고 있는 요것을 호출하겠다
            .create()
        // 어떤 뷰타입에 어떤 데이터 클래스를 반환할 것인가 정의
        return try{
            when(viewTypeName){
                ViewType.VIEW_PAGER.name -> gson.fromJson(json, ViewPager::class.java)
                ViewType.HORIZONTAL.name -> gson.fromJson(json, Horizontal::class.java)
                ViewType.FULL_AD.name -> gson.fromJson(json, FullAd::class.java)

                ViewType.SELL_ITEM.name -> gson.fromJson(json, SellItem::class.java)
                ViewType.IMAGE.name -> gson.fromJson(json, Image::class.java)
                ViewType.SALE.name -> gson.fromJson(json, Sale::class.java)
                ViewType.COUPON.name -> gson.fromJson(json, Coupon::class.java)

                else-> gson.fromJson(json, Empty::class.java)
            }
        } catch (e:Exception){
            gson.fromJson(json, Empty::class.java)
        }
    }

}