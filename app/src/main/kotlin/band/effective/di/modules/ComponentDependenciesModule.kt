package band.effective.di.modules

import band.effective.core.di.ComponentDependencies
import band.effective.core.di.ComponentDependenciesKey
import band.effective.di.AppComponent
import band.effective.main.di.MainComponentDependencies
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ComponentDependenciesModule {

    @Binds
    @IntoMap
    @ComponentDependenciesKey(MainComponentDependencies::class)
    fun bindMainComponentDeps(appComponent: AppComponent): ComponentDependencies
}
