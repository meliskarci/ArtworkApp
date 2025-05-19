package com.meliskarci.supabasetest.domain.usecase.db

import com.meliskarci.supabasetest.data.remote.repository.SupabaseDbImpl
import com.meliskarci.supabasetest.domain.model.Artworks
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetArtworksUsecase @Inject constructor(
    private val repository: SupabaseDbImpl
) {

    operator fun invoke() : Flow<List<Artworks>> {
        return repository.getArtworks()

    }
}