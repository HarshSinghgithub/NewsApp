package com.harsh.newsfresh.model.use_cases

import androidx.compose.runtime.MutableState
import com.harsh.newsfresh.data.Article
import com.harsh.newsfresh.data.News
import com.harsh.newsfresh.data.repository.NewsRepository
import com.harsh.newsfresh.utils.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetSpecificNewsUseCase @Inject constructor(
    private val repository: NewsRepository
) {
    operator fun invoke(query : String) : Flow<Result<List<Article>>> = flow {
        try {
            emit(Result.Loading())
            val response = repository.getSpecificNews(query)
            val listOfArticle = response.articles
            emit(Result.Success(listOfArticle))
        }
        catch (e : HttpException){
            emit(Result.Error(e.localizedMessage))
        }
        catch (e : IOException){
            emit(Result.Error(e.localizedMessage))
        }
    }
}