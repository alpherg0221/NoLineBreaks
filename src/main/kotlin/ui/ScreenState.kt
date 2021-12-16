package ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.rememberSaveable
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update


class ScreenState(startDestination: String) {
    val currentRouteFlow: MutableStateFlow<String> = MutableStateFlow(startDestination)

    fun update(destination: String) = currentRouteFlow.update { destination }

    companion object {
        fun Saver() = Saver<ScreenState, String>(
            save = { it.currentRouteFlow.value },
            restore = { ScreenState(it) },
        )
    }
}

@Composable
fun ScreenState.currentRouteAsState(): State<String> = currentRouteFlow.collectAsState()

@Composable
fun rememberScreenState(startDestination: String): ScreenState {
    return rememberSaveable(saver = ScreenState.Saver()) {
        ScreenState(startDestination)
    }
}