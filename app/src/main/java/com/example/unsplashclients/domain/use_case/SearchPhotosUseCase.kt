package com.example.unsplashclients.domain.use_case

import com.example.unsplashclients.common.NetworkResponse
import com.example.unsplashclients.data.remote.toPhotos
import com.example.unsplashclients.domain.model.Photo
import com.example.unsplashclients.domain.repository.PhotoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SearchPhotosUseCase @Inject constructor(
    private val repository: PhotoRepository,
) {
    // operator fun invokeについて
    // val hello = Hello()
    // hello()
    // 上記の２行でhello.invoke()が呼び出される
    // つまり hello() = hello.invoke()
    // 1つの処理だけを担当するクラスを実装する際にinvokeを使用する
    operator fun invoke(query: String): Flow<NetworkResponse<List<Photo>>> = flow {
        // ... = flow
        // Flowオブジェクトを作るための生成関数
        // NetworkResponse<List<Photo>>を順番に流すFlowを作って返します
        // その中身は{}に書いてあります
        try {
            emit(NetworkResponse.Loading<List<Photo>>())
            val photos = repository.searchPhotos(query).toPhotos()
            emit(NetworkResponse.Success<List<Photo>>(photos))
        } catch (e: Exception) {
            emit(NetworkResponse.Failure<List<Photo>>(e.message.toString()))
        }
    }
}