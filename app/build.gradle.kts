plugins {
    alias(libs.plugins.android.application)
    id("band.effective.module.screen")
    id("band.effective.module.dagger")
}

android {

    defaultConfig {
        applicationId = "band.effective"
        versionCode = 1
        versionName = "1.0"

        vectorDrawables.useSupportLibrary = true
    }

    packagingOptions {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
}

dependencies {

    implementation(project(":network"))
    implementation(project(":screens:example"))

    implementation(libs.retrofit.client)
    implementation(libs.retrofit.moshi)
    implementation(libs.retrofit.mock)

    implementation(libs.okhttp.client)
    devImplementation(libs.okhttp.logginginterceptor)

    debugImplementation(libs.leakcanary)
}