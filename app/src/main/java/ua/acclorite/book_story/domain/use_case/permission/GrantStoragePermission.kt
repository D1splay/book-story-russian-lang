/*
 * Book's Story — free and open-source Material You eBook reader.
 * Copyright (C) 2024-2025 Acclorite
 * SPDX-License-Identifier: GPL-3.0-only
 */

package ua.acclorite.book_story.domain.use_case.permission

import androidx.activity.ComponentActivity
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState
import ua.acclorite.book_story.domain.repository.PermissionRepository
import javax.inject.Inject

class GrantStoragePermission @Inject constructor(
    private val repository: PermissionRepository
) {

    @OptIn(ExperimentalPermissionsApi::class)
    suspend fun execute(
        activity: ComponentActivity,
        storagePermissionState: PermissionState
    ): Boolean {
        return repository.grantStoragePermission(
            activity = activity,
            storagePermissionState = storagePermissionState
        )
    }
}