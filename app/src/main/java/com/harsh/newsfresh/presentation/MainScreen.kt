package com.harsh.newsfresh.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.harsh.newsfresh.model.NewsViewModel
import com.harsh.newsfresh.model.SpecificNewsViewModel


@Composable
fun MainScreen(
    navController: NavController,
    viewModel1: NewsViewModel,
    viewModel2: SpecificNewsViewModel
) {
    NewsList(navController = navController, viewModel = viewModel1)
    //SpecificNewsList(navController = navController, viewModel = viewModel2)
}