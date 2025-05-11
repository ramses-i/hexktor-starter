import org.gradle.api.Plugin
import org.gradle.api.Project

class ApplicationConventionsPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        pluginManager.apply("conventions.common")
        pluginManager.apply("application")
        pluginManager.apply("com.github.johnrengelman.shadow")
    }
}