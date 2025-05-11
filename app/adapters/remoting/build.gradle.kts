plugins {
    alias(libs.plugins.project.library.conventions)
    alias(libs.plugins.serialization)
}

dependencies {
    api(projects.app.core)
    api(projects.app.common)

    implementation(libs.ktor.client.core)
    implementation(libs.ktor.client.cio)
    implementation(libs.ktor.client.content.negotiation)
    implementation(libs.ktor.serialization.kotlinx.json)
    implementation(libs.ktor.client.logging)
    implementation(libs.ktor.client.logging.jvm)
    implementation(libs.typesafe.config)
}
