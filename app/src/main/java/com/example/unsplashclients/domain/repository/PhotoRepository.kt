package com.example.unsplashclients.domain.repository

import com.example.unsplashclients.data.remote.PhotoDetailDto
import com.example.unsplashclients.data.remote.SearchPhotosResultDto

interface PhotoRepository {
    suspend fun searchPhotos(query: String): SearchPhotosResultDto
    suspend fun getPhotoById(photoId: String): PhotoDetailDto
}