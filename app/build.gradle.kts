plugins {
    id("com.android.application")
    id("com.google.dagger.hilt.android")
    id("com.google.devtools.ksp")
    id("com.google.gms.google-services")
    id("com.google.firebase.crashlytics")
    kotlin("android")
}

android {
    namespace = "com.kryptopass.space2x"
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        applicationId = "com.kryptopass.space2x"
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = AppConfig.androidTestInstrumentation

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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.8"
    }
    packaging {
        resources.excludes += "/META-INF/{AL2.0,LGPL2.1}"
    }
}

dependencies {
    implementation(project(":common"))
    implementation(project(":data"))
    implementation(project(":domain"))

    this need AppDependencies.activity
    this need AppDependencies.coil
    this need AppDependencies.compose
    this need AppDependencies.core
    this need AppDependencies.di
    this need AppDependencies.firebase
    this need AppDependencies.hiltNav
    this need AppDependencies.nav

    this ksp AppDependencies.kspHiltCompiler

    this androidTest AppDependencies.androidTest
    this debug AppDependencies.debug
    this test AppDependencies.test
}