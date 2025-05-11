val typesafeConfigVersion: String by rootProject

plugins {
    id("kotlin-library-conventions")
}

dependencies {
    api(projects.app.core)

    implementation("com.typesafe:config:$typesafeConfigVersion")
}
