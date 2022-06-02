package band.effective.navigation

import android.content.Context
import androidx.navigation.NavController
import band.effective.example.presentation.ExampleScreenNavigation
import com.ramcosta.composedestinations.spec.NavGraphSpec

class CommonNavGraphNavigator(
    private val context: Context,
    private val navGraph: NavGraphSpec,
    private val navController: NavController
) : ExampleScreenNavigation {

}
