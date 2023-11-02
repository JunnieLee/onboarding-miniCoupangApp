package com.example.minicoupangapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.minicoupangapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private val adapter by lazy { ListAdapter() } // 호출 시점에 by lazy 정의에 의해서 초기화를 진행한다.
                                                // val(immutable)에서만 사용이 가능하다.
                                                // val이므로 값을 교체하는 건 불가능하다.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply{
            setContentView(root)
            recyclerView.adapter = adapter
        }

    }
}