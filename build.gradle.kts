import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        mavenCentral()

        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.61")
        classpath(kotlin("gradle-plugin", version = "1.2.61"))
    }
}

plugins {
    java
    kotlin("jvm") version "1.3.61"
}

group = "com.nowak.mikolaj"
version = "1.0"

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.5")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlin:kotlin-script-runtime:1.3.41")
}

tasks.withType<KotlinCompile> {
    incremental = false
    kotlinOptions.jvmTarget = "1.8"
}