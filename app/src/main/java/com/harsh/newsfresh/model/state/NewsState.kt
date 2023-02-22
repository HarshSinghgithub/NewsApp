package com.harsh.newsfresh.model.state

import com.harsh.newsfresh.data.Article

data class NewsState(
    val isLoading : Boolean = false,
    val list : List<Article> = emptyList(),
    val error : String = ""
)
