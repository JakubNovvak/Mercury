plugins {
    id("java-library")
    alias(libs.plugins.jetbrains.kotlin.jvm)
}
java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}
kotlin {
    compilerOptions {
        jvmTarget = org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_11
    }
}

//INFO: Allows Hilt to inject repositories directly into the use case classes.
// Avoids boilerplate code in the Hilt Module
dependencies{
    implementation("javax.inject:javax.inject:1")
}