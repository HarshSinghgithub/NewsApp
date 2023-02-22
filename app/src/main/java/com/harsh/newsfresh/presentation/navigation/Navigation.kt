package com.harsh.newsfresh.presentation.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.harsh.newsfresh.model.NewsViewModel
import com.harsh.newsfresh.model.SpecificNewsViewModel
import com.harsh.newsfresh.presentation.GetDetailedNews
import com.harsh.newsfresh.presentation.MainScreen
import com.harsh.newsfresh.utils.DetailedNews


@Composable
fun Navigation(
    viewModel1: NewsViewModel = hiltViewModel(),
    viewModel2: SpecificNewsViewModel = hiltViewModel()
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
        composable(route = Screen.MainScreen.route) {
            MainScreen(navController, viewModel1 = viewModel1, viewModel2 = viewModel2)
        }

        composable(route = Screen.DetailNewsScreen.route) {
            val result =
                navController.previousBackStackEntry?.savedStateHandle?.get<DetailedNews>("Detail")
            if (result != null) {
                val endTime = System.nanoTime()
                Log.d("Time", "Navigation $endTime")
                GetDetailedNews(detailedNews = result)
            }
        }
    }
}

