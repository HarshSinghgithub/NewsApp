package com.harsh.newsfresh.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.compose.runtime.*
import com.harsh.newsfresh.model.state.NewsState
import com.harsh.newsfresh.model.use_cases.GetNewsUseCase
import com.harsh.newsfresh.utils.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val getNewsUseCase: GetNewsUseCase
) : ViewModel() {
    private val _state = mutableStateOf(NewsState())
    val state = _state

    init {
        getNews()
    }

    private fun getNews() {
        getNewsUseCase().onEach { result ->
            when (result) {
                is Result.Success -> {
                    _state.value = NewsState(false, result.data!!, "")
                }
                is Result.Error -> {
                    _state.value = NewsState(
                        false,
                        emptyList(),
                        result.message ?: "An unexpected Error Occurred"
                    )
                }
                is Result.Loading -> {
                    _state.value = NewsState(true, emptyList(), "")
                }
            }
        }.launchIn(viewModelScope)
    }
}


