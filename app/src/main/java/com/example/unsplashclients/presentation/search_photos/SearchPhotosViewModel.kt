package com.example.unsplashclients.presentation.search_photos

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.unsplashclients.common.NetworkResponse
import com.example.unsplashclients.domain.use_case.SearchPhotosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SearchPhotosViewModel @Inject constructor(
    private val searchPhotosUseCase: SearchPhotosUseCase,
) : ViewModel() {
    private val _state = mutableStateOf(SearchPhotosState())
    val state: State<SearchPhotosState> = _state

    init {
        searchPhotos("osaka")
    }

    fun searchPhotos(query: String) {
        // onEachとは
        // Flowから値が流れてくるたびに処理を実行するための関数
        searchPhotosUseCase(query).onEach { result ->
            when (result) {
                is NetworkResponse.Success -> {
                    _state.value = SearchPhotosState(
                        isLoading = false,
                        photos = result.data ?: emptyList(),
                    )
                }
                is NetworkResponse.Failure -> {
                    _state.value = SearchPhotosState(error = result.error)
                }
                is NetworkResponse.Loading -> {
                    _state.value = SearchPhotosState(isLoading = true)
                }
            }
            // viewModelScope: ViewModelが生きている間だけFlowを監視する
            // Flowはcollectされて初めて実行される
            //
        }.launchIn(viewModelScope)
    }
}