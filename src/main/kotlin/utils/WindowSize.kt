package utils

import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.WindowState

enum class WindowSize { Compact, Medium, Expanded }

fun WindowState.getWindowSizeClass(): WindowSize = when {
    this.size.width < 0.dp -> throw IllegalArgumentException("Dp value cannot be negative")
    this.size.width <= 800.dp -> WindowSize.Compact
    this.size.width <= 1280.dp -> WindowSize.Medium
    else -> WindowSize.Expanded
}