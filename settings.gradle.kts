// Import needed for RepositoriesMode enum to avoid unresolved reference
import org.gradle.api.initialization.resolve.RepositoriesMode

// Configure where Gradle should look for plugins (build tools, etc.)
pluginManagement {
    repositories {
        google {
            // Only include specific plugin groups from Google
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()         // Required for libraries like Retrofit, Koin
        gradlePluginPortal()   // Required for Gradle plugins
    }
}

// Configure where to resolve app dependencies from
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS) // Ignore module-level repos
    repositories {
        google()
        mavenCentral()
    }
}

// Project name and included modules
rootProject.name = "NIT3213StudentDashboardApplication"
include(":app")
