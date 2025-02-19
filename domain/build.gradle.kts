plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.android)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.hilt)
}

android {
    namespace = "com.siarheikrupenich.testrepo.domain"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
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
        sourceCompatibility = JavaVersion.VERSION_19
        targetCompatibility = JavaVersion.VERSION_19
    }
}

dependencies {
    // Modules
    implementation(project(Modules.core_common))
    implementation(project(Modules.domain_repository))

    // Android
    implementation(libs.androidx.appcompat)
    implementation(libs.material)

    // Network
    implementation(libs.retrofit)

    // DI
    implementation(libs.hilt)
    kapt(libs.hilt.kapt)

    // Test
    testImplementation(libs.junit)
    testImplementation(libs.test.mockk)
}

kapt {
    correctErrorTypes = true
}