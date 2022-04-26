package band.effective.bootstrap

import android.app.Application
import band.effective.bootstrap.core.di.ComponentDependenciesProvider
import band.effective.bootstrap.core.di.HasComponentDependencies
import band.effective.bootstrap.di.DaggerAppComponent
import javax.inject.Inject
import timber.log.Timber

class BootstrapApplication : Application(), HasComponentDependencies {

    @Inject
    override lateinit var dependencies: ComponentDependenciesProvider

    override fun onCreate() {
        super.onCreate()
        plantTimber()
        DaggerAppComponent.factory()
            .create(this)
            .inject(this)
    }

    private fun plantTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
