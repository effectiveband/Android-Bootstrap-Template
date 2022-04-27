plugins {
    id("com.android.application")
    id("band.effective.module.screen")
    id("band.effective.module.dagger")
}

android {

    defaultConfig {
        applicationId = "band.effective.bootstrap"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables.useSupportLibrary = true
    }

    sourceSets {
        getByName("withDrawer") {
            java.setSrcDirs(listOf("src/withDrawer/kotlin"))
        }
        getByName("noDrawer") {
            java.setSrcDirs(listOf("src/noDrawer/kotlin"))
        }
    }

    packagingOptions {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
}

dependencies {

    implementation(project(":network"))

    implementation(Libs.Retrofit.client)
    implementation(Libs.Retrofit.moshiConverter)

    implementation(Libs.OkHttp.client)
    implementation(Libs.OkHttp.loggingInterceptor)

    implementation(Libs.Moshi.kotlin)
    implementation(Libs.Moshi.adapters)
    ksp(Libs.Moshi.compiler)
}