package com.harsh.newsfresh.presentation

import android.annotation.SuppressLint
import android.util.Log
import androidx.browser.customtabs.CustomTabsIntent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.harsh.newsfresh.utils.DetailedNews
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun GetDetailedNews(detailedNews: DetailedNews) {
    val time = System.nanoTime()
    Log.d("Time", "Get Detailed News $time")

    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        CircularProgressIndicator()
    }

    scope.launch(Dispatchers.Default) {
        val thread = Thread.currentThread().name
        Log.d("Thread", "Running on $thread")
        val packageName = "com.android.chrome"
        val builder = CustomTabsIntent.Builder().setInstantAppsEnabled(true).build()


        builder.intent.setPackage(packageName)
        builder.launchUrl(context, android.net.Uri.parse(detailedNews.url))
    }
}
