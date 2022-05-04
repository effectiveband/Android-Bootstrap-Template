package band.effective.bootstrap

import com.android.tools.idea.wizard.template.ProjectTemplateData

fun createActivity(
    packageName: String,
    entityName: String,
    layoutName: String,
    projectData: ProjectTemplateData
) = """
package $packageName

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import ${projectData.applicationPackage}.R;

class ${entityName}sActivity : ComponentActivity() {
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
"""

fun createAppTheme(
    packageName: String,
    entityName: String,
    layoutName: String,
    projectData: ProjectTemplateData
) = """
package $packageName

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200
)

private val LightColorPalette = lightColors(
    primary = Purple500,
    primaryVariant = Purple700,
    secondary = Teal200

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)


@Composable
fun ${projectData}(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
"""