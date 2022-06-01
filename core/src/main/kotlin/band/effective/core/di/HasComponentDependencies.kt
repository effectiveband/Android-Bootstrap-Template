package band.effective.core.di

interface HasComponentDependencies {
    val dependencies: ComponentDependenciesProvider
}
