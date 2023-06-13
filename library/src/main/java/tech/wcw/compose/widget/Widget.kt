package tech.wcw.compose.base

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Head(
    title: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    enableBack: Boolean = true,
    onClick: (() -> Unit)? = null,
    actions: (@Composable RowScope.() -> Unit) = { }
) {
    if (enableBack && onClick != null) {
        TopAppBar(title, modifier, navigationIcon = {
            IconButton(onClick) {
                Icon(
                    Icons.Default.ArrowBack,
                    contentDescription = "back",
                    tint = MaterialTheme.colors.onPrimary
                )
            }
        }, actions = actions)
    } else {
        TopAppBar(title, modifier, actions = actions)
    }
}