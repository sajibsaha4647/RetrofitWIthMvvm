package com.example.retrofitwithmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitwithmvvm.Api.ApiService
import com.example.retrofitwithmvvm.Api.RetrofitHelper
import com.example.retrofitwithmvvm.Repository.QuoteRepository
import com.example.retrofitwithmvvm.ViewModel.MainViewModel
import com.example.retrofitwithmvvm.ViewModel.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val apiservices = RetrofitHelper.getInstance().create(ApiService::class.java)
        val repo = QuoteRepository(apiservices)
        mainViewModel = ViewModelProvider(this,MainViewModelFactory(repo)).get(MainViewModel::class.java)


        mainViewModel.quotes.observe(this, Observer {
            Log.d("success",it.totalCount.toString())
        })


    }
}