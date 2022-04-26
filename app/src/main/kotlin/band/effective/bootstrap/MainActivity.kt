package band.effective.bootstrap

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import band.effective.bootstrap.ui.theme.BootstrapTemplateTheme
import band.effective.bootstrap.main.di.mainComponent
import band.effective.bootstrap.presentation.AppHost
import com.google.accompanist.insets.ProvideWindowInsets

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainComponent.getInstance(this).inject(this)
        setContent {
            BootstrapTemplateTheme {
                ProvideWindowInsets {
                    AppHost()
                }
            }
        }
    }
}