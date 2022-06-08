package band.effective

import android.app.Application
import band.effective.core.di.ComponentDependenciesProvider
import band.effective.core.di.HasComponentDependencies
import band.effective.di.DaggerAppComponent
import javax.inject.Inject
import timber.log.Timber

class TemplateApplication : Application(), HasComponentDependencies {

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
