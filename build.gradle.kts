// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript{
    repositories {
        google()
        mavenCentral()
    }
    dependencies{
        classpath(Dependencies.hiltAgp)
        classpath(Dependencies.kotlinGradlePlugin)
        classpath(libs.kotlin.gradle.plugin)
    }
}