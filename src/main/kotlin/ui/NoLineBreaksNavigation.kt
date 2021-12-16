package ui


object NoLineBreaksDestination {
    const val HOME_ROUTE = "Home"
    const val SETTINGS_ROUTE = "Settings"
}

class ImageViewerNavigationActions(screenState: ScreenState) {
    val navigateToHome: () -> Unit = {
        screenState.update(NoLineBreaksDestination.HOME_ROUTE)
    }
    val navigateToSetting: () -> Unit = {
        screenState.update(NoLineBreaksDestination.SETTINGS_ROUTE)
    }
}