package utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

abstract class ViewModel {
    val viewModelScope: CoroutineScope = CloseableCoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)
}