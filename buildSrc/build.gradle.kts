plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    google()
}

dependencies{
    implementation("com.android.tools.build:gradle:8.5.2")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:2.0.0")
    implementation("com.google.dagger:hilt-android-gradle-plugin:2.52")
    implementation("com.google.devtools.ksp:symbol-processing-gradle-plugin:2.0.0-1.0.21")

}