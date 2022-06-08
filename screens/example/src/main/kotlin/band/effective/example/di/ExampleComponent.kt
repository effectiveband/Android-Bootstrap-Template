package band.effective.example.di

import android.app.Activity
import band.effective.core.di.featureComponent
import band.effective.core.di.modules.ViewModelModule
import band.effective.core.di.scope.FeatureScope
import band.effective.example.di.modules.ExampleViewModelModule
import band.effective.example.presentation.ExampleViewModel
import dagger.Component

internal val exampleComponent =
    featureComponent<ExampleComponent, Activity> { activity ->
        DaggerExampleComponent.factory().create()
    }

@FeatureScope
@Component(
    modules = [ViewModelModule::class, ExampleViewModelModule::class],
)
internal interface ExampleComponent {

    @Component.Factory
    interface Factory {
        fun create(): ExampleComponent
    }

    val exampleViewModelFactory: ExampleViewModel.Factory
}
