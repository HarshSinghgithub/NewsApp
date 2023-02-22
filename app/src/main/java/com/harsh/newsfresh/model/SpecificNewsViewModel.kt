package com.harsh.newsfresh.model

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.harsh.newsfresh.model.state.NewsState
import com.harsh.newsfresh.model.use_cases.GetSpecificNewsUseCase
import com.harsh.newsfresh.utils.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SpecificNewsViewModel @Inject constructor(
    val getSpecificNewsUseCase: GetSpecificNewsUseCase,
) : ViewModel() {
    private val _state = mutableStateOf(NewsState())
    val state = _state

     var query = mutableStateOf("Technology").toString()

    init{
        getSpecificNews(query)
    }

    private fun getSpecificNews(query : String){
        getSpecificNewsUseCase(query).onEach {  result ->
            when(result){
                is Result.Success -> {
                    _state.value = NewsState(false, result.data!!, "")
                }
                is Result.Error -> {
                    _state.value = NewsState(false, emptyList(), result.message!!)
                }
                is Result.Loading ->{
                    _state.value = NewsState(true, emptyList(), "")
                }
            }
        }.launchIn(viewModelScope)
    }

    fun onQueryChanged(query : String){
        this.query = query
    }
}