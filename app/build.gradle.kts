plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.nikita.spinners1"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.nikita.spinners1"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }
    
    applicationVariants.all {
        val variant = this
        variant.outputs.all {
            val output = this as com.android.build.gradle.internal.api.BaseVariantOutputImpl
            output.outputFileName = "NikitaSpinnerS1-v1.0.apk"
        }
    }
}

