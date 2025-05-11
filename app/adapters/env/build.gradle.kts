plugins {
    id("kotlin-library-conventions")
}

dependencies {
    api(projects.app.core)

    implementation(libs.typesafe.config)
}
