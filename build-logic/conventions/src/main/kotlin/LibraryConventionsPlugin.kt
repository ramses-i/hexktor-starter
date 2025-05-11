import org.gradle.api.Plugin
import org.gradle.api.Project

class LibraryConventionsPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        pluginManager.apply("conventions.common")
    }
}