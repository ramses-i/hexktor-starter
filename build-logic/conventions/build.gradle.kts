plugins {
    `kotlin-dsl`
}

group = "com.buildlogic"

dependencies {
    compileOnly(libs.kotlin.gradle.plugin)
    compileOnly(libs.ktlint.gradle)
    compileOnly(libs.kover.gradle.plugin)
}

tasks {
    validatePlugins {
        enableStricterValidation = true
        failOnWarning = true
    }
}

gradlePlugin {
    plugins {
        register("conventionsCommon") {
            id = "conventions.common"
            implementationClass = "CommonConventionsPlugin"
        }
        register("conventionsApplication") {
            id = "conventions.application"
            implementationClass = "ApplicationConventionsPlugin"
        }
        register("conventionsLibrary") {
            id = "conventions.library"
            implementationClass = "LibraryConventionsPlugin"
        }
    }
}

dependencies {
    implementation(libs.kotlin.gradle.plugin)
    implementation(libs.kotlin.serialization)
    implementation(libs.ktlint.gradle)
    implementation(libs.kover.gradle.plugin)
    implementation(libs.shadow)
    implementation(libs.openapi.generator.gradle.plugin)
}