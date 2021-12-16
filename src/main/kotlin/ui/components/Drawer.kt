package ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ui.NoLineBreaksDestination


@Composable
fun AppDrawer(
    currentRoute: String,
    navigateToHome: () -> Unit,
    navigateToSetting: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxHeight().width(240.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        DrawerButton(
            icon = Icons.Rounded.Home,
            label = NoLineBreaksDestination.HOME_ROUTE,
            isSelected = currentRoute == NoLineBreaksDestination.HOME_ROUTE,
            action = navigateToHome,
        )
        DrawerButton(
            icon = Icons.Rounded.Settings,
            label = NoLineBreaksDestination.SETTINGS_ROUTE,
            isSelected = currentRoute == NoLineBreaksDestination.SETTINGS_ROUTE,
            action = navigateToSetting,
        )
    }
}