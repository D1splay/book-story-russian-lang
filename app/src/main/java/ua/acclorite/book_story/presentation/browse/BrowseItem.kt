package ua.acclorite.book_story.presentation.browse

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ua.acclorite.book_story.domain.browse.BrowseLayout
import ua.acclorite.book_story.domain.browse.SelectableFile

@Composable
fun BrowseItem(
    layout: BrowseLayout,
    file: SelectableFile,
    hasSelectedItems: Boolean,
    modifier: Modifier,
    onClick: () -> Unit,
    onLongClick: () -> Unit
) {
    when (layout) {
        BrowseLayout.LIST -> {
            BrowseListItem(
                modifier = modifier,
                file = file,
                hasSelectedItems = hasSelectedItems,
                onClick = onClick,
                onLongClick = onLongClick
            )
        }

        BrowseLayout.GRID -> {
            BrowseGridItem(
                modifier = modifier,
                file = file,
                hasSelectedItems = hasSelectedItems,
                onClick = onClick,
                onLongClick = onLongClick
            )
        }
    }
}