package band.effective.bootstrap.di

import android.app.Application
import band.effective.bootstrap.BootstrapApplication
import band.effective.bootstrap.MainActivity
import band.effective.bootstrap.core.di.CommonDependencies
import band.effective.bootstrap.core.di.scope.AppScope
import band.effective.bootstrap.di.modules.AppModule
import band.effective.bootstrap.network.di.NetworkModule
import band.effective.bootstrap.di.modules.ComponentDependenciesModule
import band.effective.bootstrap.main.di.MainComponentDependencies
import dagger.BindsInstance
import dagger.Component

@AppScope
@Component(
    modules = [
        AppModule::class,
        NetworkModule::class,
        ComponentDependenciesModule::class
    ]
)
interface AppComponent :
    CommonDependencies,
    MainComponentDependencies {

    @Component.Factory
    interface Factory {

        fun create(@BindsInstance application: Application): AppComponent
    }

    fun inject(app: BootstrapApplication)
    fun inject(mainActivity: MainActivity)
}
