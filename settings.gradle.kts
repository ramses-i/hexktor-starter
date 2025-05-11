@file:Suppress("UnstableApiUsage")

rootProject.name = "ktor-hexagonal-multimodule"

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}



include(
    "app:infra",
    "app:core",
    "app:common",
    "app:adapters:env",
    "app:adapters:persist",
    "app:adapters:remoting",
    "app:adapters:primary-web",
)
