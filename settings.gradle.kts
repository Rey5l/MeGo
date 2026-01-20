pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "MeGo"
include(":app")
include(":core")
include(":feature")
include(":sync")
include(":legacy")



include(":core:common")
include(":core:data")
include(":core:datastore")
include(":core:navigation")
include(":core:network")
include(":core:uikit")
