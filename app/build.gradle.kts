plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.ttuguide"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.ttuguide"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        viewBinding=true
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
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    implementation("androidx.compose.ui:ui-text-google-fonts:1.6.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.fragment:fragment:1.3.6")
    implementation("com.github.bumptech.glide:glide:4.12.0")
    annotationProcessor("com.github.bumptech.glide:compiler:4.12.0")
    implementation ("com.google.android.gms:play-services-maps:19.0.0")
    implementation ("com.google.code.gson:gson:2.11.0")
    implementation ("com.github.MikeOrtiz:TouchImageView:1.4.1")
    implementation ("com.google.zxing:core: 3.4.1")
    implementation ("com.journeyapps:zxing-android-embedded:4.2.0")
    implementation ("com.daimajia.easing:library:2.0@aar")
    implementation ("com.daimajia.androidanimations:library:2.3@aar")

}