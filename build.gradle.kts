import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmCompilerOptions
import org.jetbrains.kotlin.gradle.tasks.KotlinCompilationTask

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin) apply false
    alias(libs.plugins.compose.compiler) apply false
    alias(libs.plugins.hilt) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.kotlin.dsl) apply false
    alias(libs.plugins.kotlin.jvm) apply false

}

subprojects {
    tasks.withType<KotlinCompilationTask<KotlinJvmCompilerOptions>> {
        compilerOptions {
            allWarningsAsErrors.set(true)
            jvmTarget.set(JvmTarget.JVM_17)

            // Workaround for https://youtrack.jetbrains.com/issue/KT-68400/K2-w-Kapt-currently-doesnt-support-language-version-2.0.-Falling-back-to-1.9.
            freeCompilerArgs.add("-Xsuppress-version-warnings")
        }
    }
}