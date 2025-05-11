import com.buildlogic.configureKotlinJVM
import com.buildlogic.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.testing.Test
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.withType
import org.jlleitschuh.gradle.ktlint.KtlintExtension

class CommonConventionsPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        with(pluginManager) {
            apply("org.jetbrains.kotlin.jvm")
            apply("org.jlleitschuh.gradle.ktlint")
            apply("org.jetbrains.kotlinx.kover")
        }

        configureKotlinJVM()

        dependencies {
            add("implementation", libs.findLibrary("logback-classic").get())
            add("implementation", libs.findLibrary("kotlin-inline-logger").get())
            add("implementation", libs.findLibrary("koin-core").get())
            add("implementation", libs.findLibrary("koin-logger-slf4j").get())
            add("api", libs.findLibrary("jakarta-validation-api").get())
            add("implementation", libs.findLibrary("hibernate-validator").get())

            add("testCompileOnly", libs.findLibrary("koin-test").get())
            add("testImplementation", libs.findLibrary("kotest-runner-junit5-jvm").get())
            add("testImplementation", libs.findLibrary("kotest-assertions-ktor").get())
            add("testImplementation", libs.findLibrary("kotest-property").get())
            add("testImplementation", libs.findLibrary("kotest-extensions-koin").get())
        }

        tasks.withType<Test>().configureEach {
            useJUnitPlatform()
        }

        extensions.configure<KtlintExtension> {
            verbose.set(true)
            outputToConsole.set(true)
            filter {
                exclude("**/gen/**")
            }
        }
    }
}