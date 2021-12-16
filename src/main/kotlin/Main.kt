import androidx.compose.foundation.layout.Column
import androidx.compose.material.Divider
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.loadXmlImageVector
import androidx.compose.ui.res.useResource
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.*
import org.xml.sax.InputSource
import ui.NoLineBreaksApp
import utils.getWindowSizeClass


fun main() = application {
    val density = LocalDensity.current
    val windowIcon = rememberVectorPainter(
        remember { useResource("icons/ic_photo_library.xml") { loadXmlImageVector(InputSource(it), density) } }
    )
    val windowState = rememberWindowState(
        placement = WindowPlacement.Floating,
        position = WindowPosition(alignment = Alignment.Center),
        size = DpSize(1280.dp, 720.dp)
    )

    Window(
        onCloseRequest = ::exitApplication,
        state = windowState,
        title = "NoLineBreaks",
        icon = windowIcon,
    ) {
        Column {
            Divider()
            NoLineBreaksApp(windowSize = windowState.getWindowSizeClass())
        }
    }
}
