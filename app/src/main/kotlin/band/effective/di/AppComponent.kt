package band.effective.di

import android.app.Application
import band.effective.MainActivity
import band.effective.TemplateApplication
import band.effective.core.di.CommonDependencies
import band.effective.core.di.scope.AppScope
import band.effective.di.modules.AppModule
import band.effective.di.modules.ComponentDependenciesModule
import band.effective.main.di.MainComponentDependencies
import band.effective.network.di.NetworkModule
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

    fun inject(app: TemplateApplication)
    fun inject(mainActivity: MainActivity)
}
