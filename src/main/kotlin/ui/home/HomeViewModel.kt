package ui.home

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import utils.ViewModel
import utils.deleteLineBreaks


class HomeViewModel private constructor() : ViewModel() {
    private val _original = MutableStateFlow("")
    val original = _original.asStateFlow()

    private val _text = MutableStateFlow("")
    val text = _text.asStateFlow()

    fun setText(text: String) {
        _original.update { text }
        _text.update { text.deleteLineBreaks() }
    }

    companion object {
        private var instance: HomeViewModel? = null

        fun getInstance() = instance ?: synchronized(this) {
            instance ?: HomeViewModel().also { instance = it }
        }
    }
}