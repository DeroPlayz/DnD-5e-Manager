plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.dnd5emanager"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.dnd5emanager"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)
    implementation(libs.media3.session)
    implementation(libs.exoplayer)
    implementation(libs.media3.exoplayer)
    implementation(libs.firebase.crashlytics.buildtools)
    implementation(libs.legacy.support.v4)
    implementation(libs.recyclerview)
    implementation(libs.scenecore)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}