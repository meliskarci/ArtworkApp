plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt.plugin)
    alias(libs.plugins.kotlinx.serialization.plugin)
}

android {
    namespace = "com.meliskarci.supabasetest"
    compileSdk = 35

    android.buildFeatures.buildConfig = true

    defaultConfig {
        applicationId = "com.meliskarci.supabasetest"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables.useSupportLibrary = true

        buildConfigField ("String", "SUPABASE_URL", "\"${project.properties["SUPABASE_URL"]}\"")
        buildConfigField ("String", "SUPABASE_KEY", "\"${project.properties["SUPABASE_KEY"]}\"")

//        buildTypes {
//            debug {
//                buildConfigField("String", "SUPABASE_URL", "\"${SUPABASE_URL}\"")
//                buildConfigField("String", "SUPABASE_KEY", "\"${SUPABASE_KEY}\"")
//            }
//            release {
//                buildConfigField("String", "SUPABASE_URL", "\"${SUPABASE_URL}\"")
//                buildConfigField("String", "SUPABASE_KEY", "\"${SUPABASE_KEY}\"")
//                isMinifyEnabled = false
//                proguardFiles(
//                    getDefaultProguardFile("proguard-android-optimize.txt"),
//                    "proguard-rules.pro"
//                )
//            }
//        }

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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.junit.ext)
    androidTestImplementation(libs.espresso.core)
    implementation(libs.lifecycle.runtime.ktx)
    implementation(libs.lifecycle.runtime.compose)
    implementation(libs.activity.compose)
    implementation(platform(libs.compose.bom))
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.graphics)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.material3)
    androidTestImplementation(platform(libs.compose.bom))
    androidTestImplementation(libs.compose.ui.test.junit4)
    debugImplementation(libs.compose.ui.tooling)
    debugImplementation(libs.compose.ui.test.manifest)

    // Supabase BOM
    //implementation(platform("io.github.jan-tennert.supabase:bom:3.1.4"))

// Supabase eklentileri
   // implementation("io.github.jan.supabase:supabase-kt:1.3.2") // veya güncel olanı

    // BOM’suz kullanım:
    //Supabase
    implementation(platform("io.github.jan-tennert.supabase:bom:2.0.0"))
    implementation("io.github.jan-tennert.supabase:postgrest-kt")
    implementation ("io.github.jan-tennert.supabase:storage-kt")
    implementation("io.ktor:ktor-client-android:2.3.4")




//// Ktor client
//    // Ktor bağımlılıkları
//    implementation("io.ktor:ktor-client-core:3.1.3")
//    implementation ("io.ktor:ktor-client-android:2.3.9")
//    implementation("io.ktor:ktor-client-content-negotiation:3.1.3")
//    implementation("io.ktor:ktor-serialization-kotlinx-json:3.1.3")
//
//    // Bu önemli - HttpTimeout sınıfı bu modülde
//
//    // Eğer okhttp engine kullanıyorsanız
//    implementation("io.ktor:ktor-client-okhttp:3.1.3")
//
//    // SLF4J uyarıları için logger implementasyonu
//    implementation ("org.slf4j:slf4j-simple:2.0.9")




    // Retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.gson)

    // Hilt
    ksp(libs.hilt.compiler)
    implementation(libs.hilt.android)
    implementation(libs.hilt.navigation.compose)

    // Navigation
    implementation(libs.navigation.compose)

    // Kotlinx Serialization
    implementation(libs.kotlinx.serialization)

    //Coil
    implementation("io.coil-kt:coil-compose:2.4.0")

    // Data Store
    implementation(libs.datastore.preferences)

}
