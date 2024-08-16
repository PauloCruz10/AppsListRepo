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
    implementation(libs.hilt.android)
    implementation(libs.room.android)
    implementation(libs.room.android.ktx)
    implementation(libs.hilt.android)
    implementation(project(":network"))
    ksp(libs.hilt.compiler)
    ksp(libs.room.compiler.android)
}