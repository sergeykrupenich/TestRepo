plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.android)
}

android {
    namespace = "com.siarheikrupenich.testrepo.core.common"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_19
        targetCompatibility = JavaVersion.VERSION_19
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
}