plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.android)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.hilt)
}

android {
    namespace = "com.siarheikrupenich.testrepo.core.network"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_19
        targetCompatibility = JavaVersion.VERSION_19
    }

    buildTypes {
        debug {
            buildConfigField("String", "BASE_URL", "\"https://api.github.com\"")
        }
        release {
            buildConfigField("String", "BASE_URL", "\"https://api.github.com\"")
        }
    }
    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    // Libs
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.timber)

    // Network
    implementation(libs.retrofit)
    implementation(libs.okHttp)
    implementation(libs.retrofit.converterGson)
    implementation(libs.loggingInterceptor)

    // DI
    implementation(libs.hilt)
    kapt(libs.hilt.kapt)
}

kapt {
    correctErrorTypes = true
}