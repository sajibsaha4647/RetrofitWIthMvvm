package com.example.retrofitwithmvvm.Api

import com.example.retrofitwithmvvm.Model.Quotelist
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

//    @GET("/quotes")
//    fun getQuotes(@Query("page") page:Int):Response<Quotelist>


    @GET("/quotes")
    suspend fun getQuotes(@Query("page") page:Int):Response<Quotelist>

}