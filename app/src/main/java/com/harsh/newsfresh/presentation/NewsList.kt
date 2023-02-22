package com.harsh.newsfresh.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.harsh.newsfresh.model.NewsViewModel

//@Composable
//fun NewsList(navController: NavController, newsList: News) {
//    val articleList = newsList.articles
//    LazyColumn {
//        if (articleList != null) {
//            items(articleList) { item ->
//                NewsItem(navController, article = item)
//            }
//        }
//        else{
//            Log.d("ERROR", "Server Error")
//        }
//    }
//}

@Composable
fun NewsList(
    navController: NavController,
    viewModel: NewsViewModel
) {
    val state = viewModel.state.value
    LazyColumn {
        items(state.list) { item ->
            NewsItem(navController = navController, article = item)
        }
    }

    if (state.error.isNotBlank()) {
        Text(
            text = state.error,
            color = MaterialTheme.colors.error,
            textAlign = TextAlign.Center
        )
    }

    if (state.isLoading) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            CircularProgressIndicator()
        }
    }

}