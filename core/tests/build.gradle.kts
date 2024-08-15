plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.android)
}

android {
    namespace = "com.siarheikrupenich.testrepo.core.tests"
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
    }

    packaging {
        resources {
            excludes += setOf(
                "META-INF/LICENSE.md",
                "META-INF/LICENSE.txt",
                "META-INF/LICENSE-notice.md",
                "META-INF/LICENSE-notice.txt",
                "META-INF/NOTICE.md",
                "META-INF/NOTICE.txt",
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_19
        targetCompatibility = JavaVersion.VERSION_19
    }
}

dependencies {
    implementation(project(Modules.core_common))

    implementation(libs.androidx.core.ktx)
    implementation(libs.junit)
    implementation(libs.test.mockk)
    implementation(libs.test.turbine)
    implementation(libs.test.coroutines.test)
}
