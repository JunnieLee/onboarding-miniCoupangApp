package com.example.minicoupangapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.minicoupangapp.model.ListItem
import com.example.minicoupangapp.remote.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository // 손쉽게 @Inject annotation을 통해 주입받을 데이터를 가져올 수 있음
): ViewModel(){

    private val _pagingData = MutableStateFlow<PagingData<ListItem>?>(null)
    // mutable live data랑 비슷함. 다만 얘는초기화를 해줘야만 한다는 차이점이 있음.
    val pagingData : StateFlow<PagingData<ListItem>?> = _pagingData

    init{
        getList()
    }

    private fun getList(){
        viewModelScope.launch {
            mainRepository.loadList()
                .cachedIn(this)
                .collectLatest { list->
                    _pagingData.value = list
                }
        }
    }

}