package ui

import androidx.compose.animation.Crossfade
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import ui.home.HomeScreen
import ui.home.HomeViewModel


@Composable
fun NoLineBreaksScreen(screenState: ScreenState) {
    val currentRoute by screenState.currentRouteAsState()

    val homeViewModel = HomeViewModel.getInstance()

    Crossfade(targetState = currentRoute) { screen ->
        when (screen) {
            NoLineBreaksDestination.HOME_ROUTE -> {
                HomeScreen(homeViewModel = homeViewModel)
            }
            NoLineBreaksDestination.SETTINGS_ROUTE -> {
                /*TODO(Create settings screen)*/
            }
        }
    }
}