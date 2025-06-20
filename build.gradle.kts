plugins {
    id("com.android.library") version "8.2.2" // or your compatible version
    id("org.jetbrains.kotlin.android") version "2.1.0"
    id 'maven-publish'
}


group = 'com.open_mobile_kit'
version = '1.0.0'

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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    publishing {
        singleVariant("release") {
            withSourcesJar()
            withJavadocJar()
        }
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                from(components["release"])
                groupId = "com.open_mobile_kit"
                artifactId = "dynamic_event_bus_base"
                version = "1.0"
            }
        }
    }
}
