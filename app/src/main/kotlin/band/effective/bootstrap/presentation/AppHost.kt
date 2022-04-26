package band.effective.bootstrap.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavControllerVisibleEntries
import androidx.navigation.compose.rememberNavController

@OptIn(NavControllerVisibleEntries::class)
@Composable
fun AppHost() {
    val navController = rememberNavController()
    BootstrapScaffold { paddingValues ->
        AppNavigation(
            navController = navController,
            modifier = Modifier.padding(paddingValues)
        )
    }
}
