package ua.acclorite.book_story.presentation.browse

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import ua.acclorite.book_story.ui.browse.BrowseEvent

@Composable
fun BrowseBackHandler(
    hasSelectedItems: Boolean,
    showSearch: Boolean,
    searchVisibility: (BrowseEvent.OnSearchVisibility) -> Unit,
    clearSelectedFiles: (BrowseEvent.OnClearSelectedFiles) -> Unit,
    navigateToLibrary: () -> Unit
) {
    BackHandler {
        if (hasSelectedItems) {
            clearSelectedFiles(BrowseEvent.OnClearSelectedFiles)
            return@BackHandler
        }

        if (showSearch) {
            searchVisibility(BrowseEvent.OnSearchVisibility(false))
            return@BackHandler
        }

        navigateToLibrary()
    }
}