plugins {
    alias(libs.plugins.project.library.conventions)
}

dependencies {
    api(projects.app.core)

    implementation(libs.typesafe.config)
}
