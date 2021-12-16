package ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material.icons.rounded.ContentCopy
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import java.awt.Cursor


@Composable
fun HomeScreen(homeViewModel: HomeViewModel) {
    val original by homeViewModel.original.collectAsState()
    val text by homeViewModel.text.collectAsState()

    val scope = rememberCoroutineScope()

    val clipboardManager = LocalClipboardManager.current
    val scaffoldState = rememberScaffoldState()

    HomeContent(
        original = original,
        text = text,
        scaffoldState = scaffoldState,
        onValueChange = {
            homeViewModel.setText(it)
        },
        onCopyClick = {
            clipboardManager.setText(AnnotatedString(text))
            scope.launch {
                scaffoldState.snackbarHostState.showSnackbar(
                    message = "Copied",
                    duration = SnackbarDuration.Short,
                )
            }
        }
    )
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun HomeContent(
    original: String,
    text: String,
    scaffoldState: ScaffoldState,
    onValueChange: (String) -> Unit,
    onCopyClick: () -> Unit,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState
    ) {
        BoxWithConstraints(modifier = Modifier.fillMaxSize().padding(20.dp)) {
            val width = maxWidth
            SelectionContainer {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top
                ) {
                    OutlinedTextField(
                        value = original,
                        onValueChange = onValueChange,
                        modifier = Modifier.width(width / 2 - (20).dp).fillMaxHeight(),
                        trailingIcon = {
                            IconButton(
                                onClick = { onValueChange("") },
                                modifier = Modifier.pointerHoverIcon(PointerIcon(Cursor(Cursor.HAND_CURSOR)))
                            ) {
                                Icon(imageVector = Icons.Rounded.Delete, contentDescription = null)
                            }
                        }
                    )
                    Divider(modifier = Modifier.fillMaxHeight().width(1.dp))
                    OutlinedTextField(
                        value = text,
                        onValueChange = {},
                        modifier = Modifier.width(width / 2 - (20).dp).fillMaxHeight(),
                        readOnly = true,
                        trailingIcon = {
                            IconButton(
                                onClick = onCopyClick,
                                modifier = Modifier.pointerHoverIcon(PointerIcon(Cursor(Cursor.HAND_CURSOR)))
                            ) {
                                Icon(imageVector = Icons.Rounded.ContentCopy, contentDescription = null)
                            }
                        }
                    )
                }
            }
        }
    }
}