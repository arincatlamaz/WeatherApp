import org.gradle.api.artifacts.dsl.DependencyHandler

object Dependencies {
    const val android = "com.android.application"
    const val kotlinAndroid = "kotlin-android"
    const val ktx = "androidx.core:core-ktx${Versions.ktx}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinGradlePlugin}"
    const val jetbrainsKotlinAndroid = "org.jetbrains.kotlin.android"

    //RecyclerView
    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.RECYCLERVIEW}"

    //Ksp
    const val kspPlugin = "com.google.devtools.ksp"
    const val kspHilt = "com.google.dagger:hilt-compiler:${Versions.kspHiltVersion}"

    //Retrofit
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
    const val gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"


    //ViewModel&LiveData
    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.VIEWMODELLIVEDATA}"
    const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.VIEWMODELLIVEDATA}"

    //Coroutines features dependency
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.COROUTINESANDROID}"
    const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINESANDROID}"

    //Fragment
    const val fragment = "androidx.fragment:fragment-ktx:${Versions.FRAGMENT}"

    //Navigation
    const val navFragment = "androidx.navigation:navigation-fragment:${Versions.NAVIGATION}"
    const val navUi = "androidx.navigation:navigation-ui:${Versions.NAVIGATION}"
    const val navSupport = "androidx.navigation:navigation-dynamic-features-fragment:${Versions.NAVIGATION}"
    const val navSafeArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.NAVIGATION}" // to classpath implementation
    const val navPlugin = "androidx.navigation.safeargs.kotlin"

    //Dagger Hilt
    const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    const val hiltAgp = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"
    const val hiltAndroidPlugin = "dagger.hilt.android.plugin"

}

fun DependencyHandler.coroutines(){
    implementation(Dependencies.coroutines)
    implementation(Dependencies.coroutinesAndroid)
}

fun DependencyHandler.fragment(){
    implementation(Dependencies.fragment)
}

fun DependencyHandler.navigation(){
    implementation(Dependencies.navFragment)
    implementation(Dependencies.navUi)
    implementation(Dependencies.navSupport)
//    implementation(Dependencies.navSafeArgs)
//    implementation(Dependencies.navPlugin)
}

fun DependencyHandler.hilt() {
    implementation(Dependencies.hiltAndroid)
    ksp(Dependencies.hiltCompiler)
}

fun DependencyHandler.mvvm(){
    implementation(Dependencies.viewModel)
    implementation(Dependencies.liveData)
}

fun DependencyHandler.retrofit(){
    implementation(Dependencies.retrofit)
    implementation(Dependencies.okHttp)
    implementation(Dependencies.gson)
}