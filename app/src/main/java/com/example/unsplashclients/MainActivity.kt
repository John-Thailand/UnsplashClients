package com.example.unsplashclients

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.unsplashclients.presentation.ScreenRoute
import com.example.unsplashclients.presentation.photo_detail.PhotoDetailScreen
import com.example.unsplashclients.presentation.search_photos.SearchPhotosScreen
import com.example.unsplashclients.presentation.ui.theme.UnsplashClientsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UnsplashClientsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = ScreenRoute.SearchPhotosScreen.route,
                    ) {
                        // 画像検索画面
                        composable(route = ScreenRoute.SearchPhotosScreen.route) {
                            SearchPhotosScreen(navController)
                        }
                        // 画像詳細画面
                        composable(route = ScreenRoute.PhotoDetailScreen.route + "/{photoId}") {
                            PhotoDetailScreen()
                        }
                    }
                }
            }
        }
    }
}