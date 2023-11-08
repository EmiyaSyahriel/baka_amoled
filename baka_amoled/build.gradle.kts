
plugins {
    id("com.android.application")
    
}

android {
    namespace = "id.psw.baka_amoled"
    compileSdk = 33
    buildToolsVersion = "33.0.3"

    defaultConfig {
        applicationId = "id.psw.baka_amoled"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }
    
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
}
