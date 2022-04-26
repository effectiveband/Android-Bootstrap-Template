package band.effective.bootstrap.main.di

import android.app.Activity
import band.effective.bootstrap.MainActivity
import band.effective.bootstrap.core.di.featureComponent
import band.effective.bootstrap.core.di.findComponentDependencies
import dagger.Component

val mainComponent = featureComponent<MainComponent, Activity> { activity ->
    DaggerMainComponent.factory().create(activity.findComponentDependencies())
}

@Component(
    dependencies = [MainComponentDependencies::class]
)
interface MainComponent {

    @Component.Factory
    interface Factory {

        fun create(deps: MainComponentDependencies): MainComponent
    }

    fun inject(activity: MainActivity)
}
