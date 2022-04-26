package band.effective.bootstrap.di.modules

import band.effective.bootstrap.core.di.ComponentDependencies
import band.effective.bootstrap.core.di.ComponentDependenciesKey
import band.effective.bootstrap.di.AppComponent
import band.effective.bootstrap.main.di.MainComponentDependencies
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
