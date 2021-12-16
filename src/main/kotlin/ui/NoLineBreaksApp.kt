package ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ui.components.AppDrawer
import ui.components.AppNavRail
import ui.theme.NoLineBreaksTheme
import utils.WindowSize


@Composable
fun NoLineBreaksApp(windowSize: WindowSize) {
    NoLineBreaksTheme(darkTheme = isSystemInDarkTheme()) {
        Scaffold {
            val screenState = rememberScreenState(NoLineBreaksDestination.HOME_ROUTE)
            val navigationActions = ImageViewerNavigationActions(screenState)
            val currentRoute by screenState.currentRouteAsState()
            val isExpandedScreen = windowSize == WindowSize.Expanded

            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                if (isExpandedScreen) {
                    AppDrawer(
                        currentRoute = currentRoute,
                        navigateToHome = navigationActions.navigateToHome,
                        navigateToSetting = navigationActions.navigateToSetting,
                    )
                } else {
                    AppNavRail(
                        currentRoute = currentRoute,
                        navigateToHome = navigationActions.navigateToHome,
                        navigateToSetting = navigationActions.navigateToSetting,
                    )
                }
                Divider(modifier = Modifier.fillMaxHeight().width(1.dp))
                NoLineBreaksScreen(screenState = screenState)
            }
        }
    }
}