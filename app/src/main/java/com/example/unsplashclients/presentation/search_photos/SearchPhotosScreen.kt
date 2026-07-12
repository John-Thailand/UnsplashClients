package com.example.unsplashclients.presentation.search_photos

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.example.unsplashclients.presentation.search_photos.components.PhotoThumbnail

@Composable
fun SearchPhotosScreen(
    viewModel: SearchPhotosViewModel = hiltViewModel(),
) {
    val state = viewModel.state.value
    LazyColumn {
        items(state.photos) { photo ->
            PhotoThumbnail(
                photo = photo,
                onClick = {}
            )
        }
    }
}