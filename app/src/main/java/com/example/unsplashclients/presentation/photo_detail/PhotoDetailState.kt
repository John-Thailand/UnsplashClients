package com.example.unsplashclients.presentation.photo_detail

import com.example.unsplashclients.domain.model.PhotoDetail

data class PhotoDetailState(
    val isLoading: Boolean = false,
    val photoDetail: PhotoDetail? = null,
    val error: String? = null,
)
