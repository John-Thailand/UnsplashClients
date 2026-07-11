// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    // このプロジェクトではこのバージョンのプラグインを使うよ
    // バージョン 9.0.1
    // apply false = どのモジュールにも適用しない
    // apply falseがないと、ルートプロジェクト自身がAndroidアプリになろうとしてしまう
    alias(libs.plugins.android.application) apply false
    // バージョン 2.0.21
    alias(libs.plugins.kotlin.compose) apply false
    // Hiltを利用可能にする
    alias(libs.plugins.hilt) apply false
    // KotlinコードからHiltのコードを自動生成する
    alias(libs.plugins.ksp) apply false
}