package com.example.minicoupangapp.remote.repository

import androidx.paging.PagingData
import com.example.minicoupangapp.model.ListItem
import kotlinx.coroutines.flow.Flow

interface MainRepository {
    fun loadList() : Flow<PagingData<ListItem>>
}