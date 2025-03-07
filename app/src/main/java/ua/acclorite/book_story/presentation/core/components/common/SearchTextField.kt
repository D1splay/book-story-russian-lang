/*
 * Book's Story — free and open-source Material You eBook reader.
 * Copyright (C) 2024-2025 Acclorite
 * SPDX-License-Identifier: GPL-3.0-only
 */

package ua.acclorite.book_story.presentation.core.components.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import ua.acclorite.book_story.R

/**
 * Search Text Field.
 * Used in main screens for searching.
 *
 * @param modifier Modifier to apply.
 * @param query Search query.
 * @param onQueryChange Callback to change [query].
 * @param onSearch Search action (refresh list, fetch filtered books etc..).
 */
@Composable
fun SearchTextField(
    modifier: Modifier = Modifier,
    query: String,
    onQueryChange: (String) -> Unit,
    onSearch: () -> Unit
) {
    val keyboardManager = LocalSoftwareKeyboardController.current

    BasicTextField(
        value = query,
        singleLine = true,
        textStyle = TextStyle(
            color = MaterialTheme.colorScheme.onSurface,
            fontSize = MaterialTheme.typography.titleLarge.fontSize,
            lineHeight = MaterialTheme.typography.titleLarge.lineHeight,
            fontFamily = MaterialTheme.typography.titleLarge.fontFamily
        ),
        modifier = modifier,
        onValueChange = onQueryChange,
        keyboardOptions = KeyboardOptions(
            KeyboardCapitalization.Words,
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(
            onSearch = {
                onSearch()
                keyboardManager?.hide()
            }
        ),
        cursorBrush = SolidColor(MaterialTheme.colorScheme.onSurfaceVariant)
    ) { innerText ->
        Box(contentAlignment = Alignment.CenterStart) {
            if (query.isEmpty()) {
                StyledText(
                    text = stringResource(id = R.string.search_field_empty),
                    style = MaterialTheme.typography.titleLarge.copy(
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    ),
                    maxLines = 1
                )
            }
            innerText()
        }
    }
}