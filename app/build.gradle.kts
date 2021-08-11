plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
}

val versionMajor = 1
val versionMinor = 0
val versionPatch = 2

android {
    compileSdk = 30
    buildToolsVersion = "30.0.3"

    defaultConfig {
        applicationId = "ru.stersh.musicmagician"
        minSdk = 21
        targetSdk = 30
        versionCode = versionMajor * 10000 + versionMinor * 100 + versionPatch
        versionName = "${versionMajor}.${versionMinor}.${versionPatch}"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        getByName("debug") {
            isMinifyEnabled = false
        }
    }
    lint {
        isAbortOnError = false
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    // Moxy
    val moxyVersion = "2.2.2"
    implementation("com.github.moxy-community:moxy:$moxyVersion")
    implementation("com.github.moxy-community:moxy-androidx:$moxyVersion")
    implementation("com.github.moxy-community:moxy-ktx:$moxyVersion")
    kapt("com.github.moxy-community:moxy-compiler:$moxyVersion")

    // Shimmer layout
    implementation("com.facebook.shimmer:shimmer:0.5.0")

    // MaterialDrawer
    implementation("com.mikepenz:materialdrawer:8.4.2")

    // Rxjava 2
    implementation("io.reactivex.rxjava2:rxandroid:2.1.1")
    implementation("io.reactivex.rxjava2:rxjava:2.2.16")
    implementation("io.reactivex.rxjava2:rxkotlin:2.4.0")

    // StorIO
    implementation("com.pushtorefresh.storio3:content-resolver:3.0.0")

    // AndroidX
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.appcompat:appcompat:1.3.1")
    implementation("androidx.cardview:cardview:1.0.0")
    implementation("androidx.recyclerview:recyclerview:1.2.1")
    implementation("androidx.palette:palette-ktx:1.0.0")
    implementation("androidx.preference:preference-ktx:1.1.1")

    // Picasso
    implementation("com.squareup.picasso:picasso:2.71828")

    // Kotlin std
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.5.21")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.5.21")

    // OkHttp 4
    implementation("com.squareup.okhttp3:okhttp:4.2.2")

    // Retrofit 2
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.retrofit2:adapter-rxjava2:2.7.0")

    // Gson
    implementation("com.google.code.gson:gson:2.8.7")

    // Koin
    val koinVersion = "2.0.1"
    implementation("io.insert-koin:koin-core:$koinVersion")
    implementation("io.insert-koin:koin-android:$koinVersion")
    implementation("io.insert-koin:koin-androidx-scope:$koinVersion")
    implementation("io.insert-koin:koin-java:$koinVersion")

    // AdapterDelegates 4
    val adapterDelegatesVersion = "4.2.0"
    implementation("com.hannesdorfmann:adapterdelegates4-kotlin-dsl:$adapterDelegatesVersion")
    implementation("com.hannesdorfmann:adapterdelegates4-kotlin-dsl-layoutcontainer:$adapterDelegatesVersion")

    // Cicerone
    implementation("com.github.terrakok:cicerone:7.1")

    // Calligraphy 3
    implementation("io.github.inflationx:calligraphy3:3.1.1")
    implementation("io.github.inflationx:viewpump:2.0.3")

    // Leak Canary
    debugImplementation("com.squareup.leakcanary:leakcanary-android:2.7")

    // Timber
    implementation("com.jakewharton.timber:timber:4.7.1")

    testImplementation("junit:junit:4.13.2")
}
