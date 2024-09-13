plugins {
    id(Dependencies.android)
    id(Dependencies.kotlinAndroid)
    id(Dependencies.hiltAndroidPlugin)
    id(Dependencies.kspPlugin)
    id(Dependencies.jetbrainsKotlinAndroid)

}

android {
    namespace = Versions.namespace
    compileSdk = Versions.compileSdk

    buildFeatures {
        viewBinding = true
    }

    defaultConfig {
        applicationId = Versions.applicationId
        minSdk = Versions.minSdk
        targetSdk = Versions.targetSdk
        versionCode = Versions.versionCode
        versionName = Versions.versionName

        testInstrumentationRunner = Versions.testInstrumentationRunner
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
        jvmTarget = Versions.jvmTarget
    }

}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation(project(":data"))
    implementation(project(":network"))

    hilt()
    ksp(Dependencies.kspHilt)
    fragment()
    mvvm()
    navigation()

}