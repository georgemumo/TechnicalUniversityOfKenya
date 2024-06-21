plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.google.gms.google.services)
}

android {
    namespace = "com.example.techuni"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.techuni"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation ("androidx.activity:activity-compose:1.6.0")
    implementation ("io.coil-kt:coil-compose:2.1.0")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1")
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation("androidx.navigation:navigation-common:2.7.7")

    implementation(libs.androidx.ui.tooling.preview)
    implementation ("androidx.compose.ui:ui:1.4.0")
    implementation ("androidx.compose.material:material:1.4.0")
    implementation ("androidx.compose.ui:ui-tooling-preview:1.4.0")
    implementation ("androidx.navigation:navigation-compose:2.5.0")
    implementation ("com.google.accompanist:accompanist-permissions:0.29.2-rc")
    implementation ("com.google.android.exoplayer:exoplayer:2.18.4")
    implementation ("androidx.compose.ui:ui-tooling-preview:1.2.0")
    implementation ("com.google.accompanist:accompanist-pager:0.20.3")
    implementation ("androidx.compose.runtime:runtime:1.2.0")
    implementation ("io.coil-kt:coil-compose:2.1.0")
    implementation ("com.google.android.exoplayer:exoplayer-robolectricutils:2.19.1")
//    implementation ("com.google.android.exoplayer:exoplayer-ui:2.15.1")
//    implementation ("com.google.android.exoplayer:exoplayer-composable:0.2.0")
    implementation ("com.google.accompanist:accompanist-pager-indicators:0.20.3")

    implementation(libs.androidx.material3)
    implementation ("com.github.bumptech.glide:glide:4.12.0")
    implementation(libs.firebase.firestore.ktx)
    annotationProcessor ("com.github.bumptech.glide:compiler:4.12.0")
    implementation(libs.androidx.navigation.runtime.ktx)
    implementation(libs.androidx.navigation.compose)
    dependencies {
        implementation ("androidx.activity:activity-compose:1.4.0")
        implementation ("androidx.compose.ui:ui:1.1.0")
        implementation ("androidx.compose.foundation:foundation:1.1.0")
        implementation ("androidx.compose.material:material:1.1.0")
        implementation ("androidx.compose.runtime:runtime-livedata:1.1.0")
        implementation ("androidx.compose.runtime:runtime:1.1.0")
        implementation ("androidx.compose.ui:ui-tooling:1.1.0")
        implementation ("androidx.viewpager2:viewpager2:1.0.0")

        implementation ("androidx.compose.compiler:compiler:1.1.0")
        implementation(libs.firebase.auth)
    implementation(libs.firebase.database.ktx)

    implementation(libs.androidx.appcompat)
    implementation(libs.firebase.database)
    implementation(libs.firebase.storage)
        implementation ("io.coil-kt:coil-compose:1.4.0")

        // ExoPlayer for video playbac

        // Compose UI dependencies







        implementation(libs.androidx.runtime.livedata)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}
}