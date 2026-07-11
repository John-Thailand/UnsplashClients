package com.example.unsplashclients.presentation.search_photos

import com.example.unsplashclients.domain.model.Photo

data class SearchPhotosState(
    val isLoading: Boolean = false,
    val photos: List<Photo> = emptyList(),
    val error: String? = null,
)
