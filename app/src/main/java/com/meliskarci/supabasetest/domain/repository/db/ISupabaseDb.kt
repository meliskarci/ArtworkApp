package com.meliskarci.supabasetest.domain.repository.db

import com.meliskarci.supabasetest.domain.model.Artworks
import kotlinx.coroutines.flow.Flow

interface ISupabaseDb {
    fun getArtworks(): Flow<List<Artworks>>
    fun getArtworkById(id: Int): Flow<Artworks?>
    fun getArtworkByType(type: String): Flow<List<Artworks>>
}