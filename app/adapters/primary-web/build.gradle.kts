plugins {
    id("kotlin-library-conventions")
    kotlin("plugin.serialization")
    id("org.openapi.generator")
}

dependencies {
    api(projects.app.core)
    api(projects.app.common)

    implementation(libs.ktor.server.core)
    implementation(libs.ktor.server.call.logging)
    implementation(libs.ktor.server.cors)
    implementation(libs.ktor.server.status.pages)
    implementation(libs.ktor.server.host.common.jvm)
    implementation(libs.ktor.server.call.logging.jvm)
    implementation(libs.ktor.server.call.id.jvm)
    implementation(libs.ktor.server.content.negotiation)
    implementation(libs.ktor.serialization.kotlinx.json)
    implementation(libs.koin.ktor)
    implementation(libs.swagger.annotations)

    testImplementation(libs.ktor.server.test.host)
    testImplementation(libs.kotest.assertions.ktor)
    testImplementation(libs.ktor.server.netty)
}

openApiGenerate {
    inputSpec.set("$projectDir/src/main/resources/openapi/addrbook.yaml")
    outputDir.set("$projectDir")
    generatorName.set("kotlin")
    globalProperties.put("models", "")
    generateApiDocumentation.set(false)
    generateModelDocumentation.set(false)
    additionalProperties.put("serializationLibrary", "kotlinx_serialization")
    packageName.set("adapters.primaryweb.gen")
}
