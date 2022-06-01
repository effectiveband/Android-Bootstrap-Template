package band.effective

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import band.effective.main.di.mainComponent
import band.effective.presentation.AppHost
import band.effective.ui.theme.TemplateTheme
import com.google.accompanist.insets.ProvideWindowInsets

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainComponent.getInstance(this).inject(this)
        setContent {
            TemplateTheme {
                ProvideWindowInsets {
                    AppHost()
                }
            }
        }
    }
}