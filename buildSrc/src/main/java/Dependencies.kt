object Version {
    //core
    const val core = "1.10.1"
    const val lifecycle = "2.6.1"
    const val material = "1.9.0"
    const val appCompact = "1.6.1"

    //compose
    const val activity_compose = "1.7.2"
    const val composeNavigation = "2.5.3"


    //Test
    const val jUnit = "4.13.2"

    //Android Test
    const val jUnit_ext = "1.1.5"
    const val espresso_core = "3.5.1"

    //Retrofit
    const val gsonConvertor = "2.9.0"
    const val retrofit = "2.9.0"
    const val okHttp = "4.10.0"


    //Hilt
    const val hiltAndroid = "2.46.1"
    const val hiltCompiler = "2.46.1"
    const val hiltComposeNavigation = "1.0.0"

    //Coroutines
    const val coroutineCore = "1.7.1"
    const val coroutineAndroid = "1.7.1"

    //Coil
    const val coil = "2.4.0"

    //ViewModel LifeCycle
    const val lifecycle_version = "2.6.1"
}

object TestImplementation {
    const val jUnit = "junit:junit:${Version.jUnit}"
}

object AndroidTestImplementation {
    const val jUnit_ext = "androidx.test.ext:junit:${Version.jUnit_ext}"
    const val espresso_core = "androidx.test.espresso:espresso-core:${Version.espresso_core}"
    const val platform = "androidx.compose:compose-bom:2022.10.00"
    const val uiTest = "androidx.compose.ui:ui-test-junit4"
}

object DebugImplementation {
    const val uiTooling = "androidx.compose.ui:ui-tooling"
    const val uiTestManifest = "androidx.compose.ui:ui-test-manifest"
}

object Deps {
    const val core = "androidx.core:core-ktx:${Version.core}"
    const val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.lifecycle}"
    const val appCompact = "androidx.appcompat:appcompat:${Version.appCompact}"
    const val material = "com.google.android.material:material:${Version.material}"

    const val viewModelLifeCycle = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.lifecycle}"
    const val viewModelLifeCycleCompose =
        "androidx.lifecycle:lifecycle-viewmodel-compose:${Version.lifecycle}"
}

object Compose {
    const val activityCompose = "androidx.activity:activity-compose:${Version.activity_compose}"
    const val platform = "androidx.compose:compose-bom:2022.10.00"
    const val ui = "androidx.compose.ui:ui"
    const val uiGraphics = "androidx.compose.ui:ui-graphics"
    const val uiToolingPreview = "androidx.compose.ui:ui-tooling-preview"
    const val material3 = "androidx.compose.material3:material3"
    const val composeNavigation =
        "androidx.navigation:navigation-compose:${Version.composeNavigation}"
}

object Hilt {
    const val hiltAndroid = "com.google.dagger:hilt-android:${Version.hiltAndroid}"
    const val hiltCompiler = "com.google.dagger:hilt-compiler:${Version.hiltCompiler}"
    const val hiltComposeNavigation = "androidx.hilt:hilt-navigation-compose:${Version.hiltComposeNavigation}"
}

object Coroutine {
    const val coroutineAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.coroutineAndroid}"
    const val coroutineCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.coroutineCore}"
}


object Retrofit {
    const val retrofit = "com.squareup.retrofit2:retrofit:${Version.retrofit}"
    const val gsonConverter = "com.squareup.retrofit2:converter-gson:${Version.gsonConvertor}"
    const val okHttp = "com.squareup.okhttp3:okhttp:${Version.okHttp}"
}

object CoilImageLibrary {
    const val coil = "io.coil-kt:coil-compose:${Version.coil}"
}

object Firebase {}

object RoomDataBase {}