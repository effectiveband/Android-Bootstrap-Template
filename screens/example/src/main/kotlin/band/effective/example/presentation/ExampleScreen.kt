package band.effective.example.presentation

import android.app.Activity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import band.effective.core_ui.di.daggerSavedStateViewModel
import band.effective.example.di.exampleComponent
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph

@RootNavGraph(start = true)
@Destination
@Composable
fun ExampleScreen() {
    val activity = LocalContext.current as Activity

    /**
     * if viewModel doesn't have runtime params
     * use daggerViewModel without factory.
     * Also need to bind viewModel class in dagger module
     */
    ExampleScreen(
        viewModel = daggerSavedStateViewModel {
            exampleComponent.getInstance(activity).exampleViewModelFactory.create(it)
        }
    )

    DisposableEffect(Unit) {
        onDispose {
            exampleComponent.clearInstance()
        }
    }
}

@Composable
private fun ExampleScreen(
    viewModel: ExampleViewModel
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = stringResource(id = band.effective.bootstrap.core_ui.R.string.app_name),
            style = typography.h3
        )
    }
}
