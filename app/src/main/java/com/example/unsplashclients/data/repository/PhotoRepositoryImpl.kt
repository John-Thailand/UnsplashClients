package com.example.unsplashclients.data.repository

import com.example.unsplashclients.data.remote.SearchPhotosResultDto
import com.example.unsplashclients.data.remote.UnsplashApi
import com.example.unsplashclients.domain.repository.PhotoRepository
import javax.inject.Inject

// Inject constructor
// apiを含めて作成する
// apiがメンバーとなる
// PhotoRepositoryを実装する
class PhotoRepositoryImpl @Inject constructor(
    private val api: UnsplashApi,
) : PhotoRepository {
    override suspend fun searchPhotos(query: String): SearchPhotosResultDto {
        return api.searchPhotos(query)
    }
}