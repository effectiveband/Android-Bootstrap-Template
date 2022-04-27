import androidx.compose.runtime.Composable
import com.alorma.drawer_base.DebugDrawerLayout

@Composable
fun ConfigureScreen(bodyContent: @Composable () -> Unit) {
    DebugDrawerLayout(
        bodyContent = { bodyContent() },
    )
}