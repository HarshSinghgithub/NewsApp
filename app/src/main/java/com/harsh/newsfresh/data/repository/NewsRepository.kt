package com.harsh.newsfresh.data.repository

import com.harsh.newsfresh.data.ApiServices
import com.harsh.newsfresh.data.News
import retrofit2.http.Path
import retrofit2.http.Query

class NewsRepository(private val api: ApiServices) {
    suspend fun getNews(): News {
        return api.getNews()
    }

    suspend fun getSpecificNews(@Query("query") query : String) : News{
        return api.getSpecificNews(query = query ,"0e295bb42b374fd4b946d6eb26a5fa95")
    }
}