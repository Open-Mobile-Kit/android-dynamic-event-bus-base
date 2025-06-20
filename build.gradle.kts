plugins {
    id("com.android.library") version "8.7.3" // or your compatible version
    id("org.jetbrains.kotlin.android") version "2.1.0"
}
group = "com.open_mobile_kit"
version = "1.0.0"

android {
    namespace = "com.open_mobile_kit.dynamic_event_bus_base"
    compileSdk = 35

    defaultConfig {
        minSdk = 28
        version = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
}
