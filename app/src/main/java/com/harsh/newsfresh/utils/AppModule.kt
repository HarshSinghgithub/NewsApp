package com.harsh.newsfresh.utils

import com.harsh.newsfresh.data.ApiServices
import com.harsh.newsfresh.data.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNewsApi() : ApiServices{
        return Retrofit
            .Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiServices::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(api : ApiServices) : NewsRepository{
        return NewsRepository(api)
    }
}