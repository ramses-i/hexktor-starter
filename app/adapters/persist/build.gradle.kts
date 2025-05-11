plugins {
    id("kotlin-library-conventions")
}

dependencies {
    api(projects.app.core)

    implementation(libs.exposed.core)
    implementation(libs.exposed.jdbc)
    implementation(libs.exposed.java.time)
    implementation(libs.hikaricp)
    implementation(libs.postgresql)

    testImplementation(libs.testcontainers)
    testImplementation(libs.testcontainers.postgresql)
    testImplementation(libs.kotest.extensions.testcontainers)
}
