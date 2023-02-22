package com.harsh.newsfresh.model.use_cases

import com.harsh.newsfresh.data.Article
import com.harsh.newsfresh.data.repository.NewsRepository
import com.harsh.newsfresh.utils.Result
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetNewsUseCase @Inject constructor(
    private val repository: NewsRepository
) {
    operator fun invoke(): kotlinx.coroutines.flow.Flow<Result<List<Article>>> = flow {
        try {
            emit(Result.Loading())
            val response = repository.getNews()
            val listOfNews = response.articles
            emit(Result.Success(data = listOfNews))
        } catch (e: HttpException) {
            emit(Result.Error(e.localizedMessage))
        } catch (e: IOException) {
            emit(Result.Error(e.localizedMessage))
        }
    }
}