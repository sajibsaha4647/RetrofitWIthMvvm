package com.example.retrofitwithmvvm.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import com.example.retrofitwithmvvm.Api.ApiService
import com.example.retrofitwithmvvm.Model.Quotelist

class QuoteRepository(private val apiService: ApiService){

    private val quoteListLiveData = MutableLiveData<Quotelist>()
     val quotes : LiveData<Quotelist> get() = quoteListLiveData

    suspend fun getQuotes(page:Int){
        val result =  apiService.getQuotes(page)
        if(result?.body() != null){
            quoteListLiveData.postValue(result.body())
        }

    }


}