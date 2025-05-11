plugins {
    alias(libs.plugins.project.application.conventions)
}

dependencies {
    api(projects.app.adapters.env)
    api(projects.app.adapters.persist)
    api(projects.app.adapters.remoting)
    api(projects.app.adapters.primaryWeb)
    api(projects.app.core)

    implementation(libs.ktor.server.core)
    implementation(libs.ktor.server.netty)
    implementation(libs.koin.ktor)
}

application {
    // Define the main class for the application.
    mainClass.set("infra.AppKt")
}
