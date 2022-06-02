package band.effective.presentation

import android.content.Context
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import band.effective.navigation.CommonNavGraphNavigator
import band.effective.navigation.NavGraphs
import com.ramcosta.composedestinations.scope.DestinationScope
import com.ramcosta.composedestinations.spec.NavGraphSpec

fun NavDestination.navGraph(): NavGraphSpec {
    hierarchy.forEach { destination ->
        NavGraphs.root.nestedNavGraphs.forEach { navGraph ->
            if (destination.route == navGraph.route) {
                return navGraph
            }
        }
    }
    throw RuntimeException("Unknown nav graph for destination $route")
}

fun DestinationScope<*>.currentNavigator(context: Context): CommonNavGraphNavigator {
    return CommonNavGraphNavigator(
        context,
        navBackStackEntry.destination.navGraph(),
        navController
    )
}