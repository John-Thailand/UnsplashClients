plugins {
    // appのbuild.gradleでプラグインを適用している
    // com.android.application / AndroidアプリであることをGradleに教えるためのプラグイン
    // androd {} ブロックが使えるようになる
    alias(libs.plugins.android.application)
    // org.jetbrains.kotlin.plugin.compose / Jetpack Composeをコンパイルできるようにするプラグイン
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.hilt)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.example.unsplashclients"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "com.example.unsplashclients"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
    // HTTP通信を行うライブラリ
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    // RetrofitとMoshiを繋ぐライブラリ
    implementation("com.squareup.retrofit2:converter-moshi:2.9.0")
    // JSONのデータをKotlinオブジェクトに変換を行うライブラリ
    implementation("com.squareup.moshi:moshi-kotlin:1.14.0")
    // Hilt本体
    implementation(libs.hilt.android)
    // Hiltのコード生成
    ksp(libs.hilt.compiler)
}