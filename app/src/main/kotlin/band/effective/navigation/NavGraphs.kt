package band.effective.navigation

import band.effective.example.presentation.destinations.ExampleScreenDestination
import com.ramcosta.composedestinations.dynamic.routedIn
import com.ramcosta.composedestinations.spec.DestinationSpec
import com.ramcosta.composedestinations.spec.NavGraphSpec

object NavGraphs {

    val example = object : NavGraphSpec {
        override val route = "example"
        override val startRoute = ExampleScreenDestination routedIn this
        override val destinationsByRoute = listOf<DestinationSpec<*>>(
            ExampleScreenDestination
        ).routedIn(this).associateBy { it.route }
    }

    val root = object : NavGraphSpec {
        override val route = "root"
        override val startRoute = example
        override val destinationsByRoute = emptyMap<String, DestinationSpec<*>>()
        override val nestedNavGraphs = listOf(example)

    }
}
