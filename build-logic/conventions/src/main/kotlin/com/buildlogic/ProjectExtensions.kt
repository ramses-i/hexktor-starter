package com.buildlogic

import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType

internal fun Project.configureKotlinJVM() {
    extensions.configure<JavaPluginExtension> {
        sourceCompatibility = JavaVersion.toVersion(getJavaVersion())
        targetCompatibility = JavaVersion.toVersion(getJavaVersion())
    }
    configureKotlin()
}

private fun Project.configureKotlin() {
    tasks.withType<KotlinCompile>().configureEach {
        compilerOptions{
            jvmTarget.set(JvmTarget.fromTarget(getJavaVersion().toString()))
        }
    }
}

val Project.libs
    get(): VersionCatalog = extensions.getByType<VersionCatalogsExtension>().named("libs")

private fun Project.getJavaVersion() =
    this.libs.findVersion(JAVA_VERSION).get().toString().toInt()

private const val JAVA_VERSION = "java-version"
