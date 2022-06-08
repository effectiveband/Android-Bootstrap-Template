package band.effective.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import band.effective.example.presentation.NavGraphs
import com.ramcosta.composedestinations.DestinationsNavHost

@Composable
fun AppNavigation(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    DestinationsNavHost(
        navGraph = NavGraphs.root,
        navController = navController,
        modifier = modifier
    )
}
