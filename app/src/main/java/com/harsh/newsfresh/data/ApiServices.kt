package com.harsh.newsfresh.data

import retrofit2.http.GET
import retrofit2.http.Query


interface ApiServices {

    @GET("v2/top-headlines?sources=google-news-in&apiKey=0e295bb42b374fd4b946d6eb26a5fa95")
    suspend fun getNews(): News

    @GET("v2/top-headlines")
    suspend fun getSpecificNews( @Query("query") query: String, @Query("apiKey") apiKey : String ): News
}