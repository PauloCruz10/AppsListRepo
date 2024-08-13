plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin)
    alias(libs.plugins.hilt)
    alias(libs.plugins.ksp)
}
android {
    namespace = "com.example.appslist"
    compileSdk = 34

    defaultConfig {
        minSdk = 28
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17" // Make sure this matches your project's JVM target
    }
}


dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.retrofit)
    implementation(libs.retrofit.gjson)
    implementation(libs.okhhtp3)
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
    implementation(project(":data"))
}