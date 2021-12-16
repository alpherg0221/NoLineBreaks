package ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.NavigationRail
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ui.NoLineBreaksDestination


@Composable
fun AppNavRail(
    currentRoute: String,
    modifier: Modifier = Modifier,
    navigateToHome: () -> Unit,
    navigateToSetting: () -> Unit,
) {
    ImageViewerNavRail(modifier = modifier,) {
        NavRailButton(
            icon = Icons.Rounded.Home,
            isSelected = currentRoute == NoLineBreaksDestination.HOME_ROUTE,
            action = navigateToHome,
        )
        Spacer(modifier = Modifier.height(16.dp))
        NavRailButton(
            icon = Icons.Rounded.Settings,
            isSelected = currentRoute == NoLineBreaksDestination.SETTINGS_ROUTE,
            action = navigateToSetting,
        )
    }
}

@Composable
fun ImageViewerNavRail(
    modifier: Modifier = Modifier,
    header: @Composable (ColumnScope.() -> Unit)? = null,
    content: @Composable ColumnScope.() -> Unit,
) {
    NavigationRail(
        modifier = modifier,
        elevation = 0.dp,
        header = header,
    ) {
        Column(
            modifier = Modifier.fillMaxHeight().padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.Center,
            content = content
        )
    }
}