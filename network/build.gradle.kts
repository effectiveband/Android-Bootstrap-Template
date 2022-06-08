plugins {
    alias(libs.plugins.android.library)
    id("band.effective.module.dagger")
    id("com.google.devtools.ksp")
}

android {
    productFlavors {
        getByName("dev") {

        }
        getByName("prod") {

        }
    }
}

dependencies {
    implementation(project(":core"))

    implementation(libs.retrofit.client)
    implementation(libs.retrofit.moshi)

    implementation(libs.okhttp.client)
    devImplementation(libs.okhttp.logginginterceptor)

    implementation(libs.moshi.kotlin)
    implementation(libs.moshi.adapters)
    ksp(libs.moshi.compiler)
}
