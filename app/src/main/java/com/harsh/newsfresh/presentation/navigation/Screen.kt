package com.harsh.newsfresh.presentation.navigation

sealed class Screen(val route : String){
    object MainScreen : Screen(route = "main_screen")
    object DetailNewsScreen : Screen(route = "detail_screen")
    object NewsScreen : Screen(route = "news_screen")

    fun withArgs(vararg args : String) : String{
        return buildString {
            append(route)
            args.forEach {
                append("/$it")
            }
        }
    }
}
