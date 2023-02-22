package com.harsh.newsfresh.presentation

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.harsh.newsfresh.data.Article
import com.harsh.newsfresh.presentation.navigation.Screen
import com.harsh.newsfresh.utils.DetailedNews


@Composable
fun NewsItem(navController: NavController, article: Article) {
    var flag by remember { mutableStateOf(false) }
    Card(
        elevation = 10.dp,
        shape = RectangleShape,
        modifier = Modifier.padding(10.dp)
    )
    {
        Surface(modifier = Modifier.clickable { flag = true }) {
            if (flag) {
                flag = false
                val startTime = System.nanoTime()
                Log.d("Click Time", "$startTime")

                val detailedNews = DetailedNews(article.url)
                navController.currentBackStackEntry?.savedStateHandle?.set(
                    key = "Detail",
                    value = detailedNews
                )

                navController.navigate(Screen.DetailNewsScreen.route)

            }
            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxSize()
            ) {

                AsyncImage(model = article.urlToImage, contentDescription = null)

                Column(modifier = Modifier.padding(5.dp)) {
                    Text(
                        text = article.title, style = MaterialTheme.typography.h6,
                        fontWeight = FontWeight.Bold, color = MaterialTheme.colors.onPrimary
                    )

                    Text(
                        text = article.description,
                        style = MaterialTheme.typography.subtitle2,
                        color = MaterialTheme.colors.onPrimary
                    )
                }
            }
        }

    }
}