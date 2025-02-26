/*
 * Book's Story — free and open-source Material You eBook reader.
 * Copyright (C) 2024-2025 Acclorite
 * SPDX-License-Identifier: GPL-3.0-only
 */

package ua.acclorite.book_story.data.mapper.book

import ua.acclorite.book_story.data.local.dto.BookEntity
import ua.acclorite.book_story.domain.library.book.Book

interface BookMapper {
    suspend fun toBookEntity(book: Book): BookEntity

    suspend fun toBook(bookEntity: BookEntity): Book
}