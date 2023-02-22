package com.harsh.newsfresh.presentation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.harsh.newsfresh.model.SpecificNewsViewModel
import com.harsh.newsfresh.presentation.navigation.Screen

@Composable
fun search(navController: NavController, viewModel: SpecificNewsViewModel = hiltViewModel()){
   val query = viewModel.query
    Surface(
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth(),
        color = MaterialTheme.colors.primary
        ) {
        TextField(value = query,
            onValueChange = {newValue ->
                viewModel.onQueryChanged(newValue)
                navController.navigate(Screen.NewsScreen.route)
            }
        )
    }
}