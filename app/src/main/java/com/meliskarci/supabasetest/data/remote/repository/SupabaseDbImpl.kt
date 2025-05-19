package com.meliskarci.supabasetest.data.remote.repository

import android.util.Log
import com.meliskarci.supabasetest.domain.model.Artworks
import com.meliskarci.supabasetest.domain.repository.db.ISupabaseDb
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.storage.Storage
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SupabaseDbImpl @Inject constructor(
    private val postgrest: Postgrest,
    private val storage: Storage
) : ISupabaseDb {
    override fun getArtworks(): Flow<List<Artworks>> {
        return flow {
            try {
                val artworks = postgrest["artworks"].select().decodeList<Artworks>()
                emit(artworks)
            } catch (e: Exception) {
                Log.e("SupabaseDbImpl", "Error fetching artworks: ${e.message}")
                emit(emptyList())
            }
        }



    }

    override fun getArtworkById(id: Int): Flow<Artworks?> {
        return flow {
            try {
                val artwork = postgrest["artworks"]
                    .select {
                        filter {
                            eq("id", id)
                        }
                    }
                    .decodeSingle<Artworks>()
                emit(artwork)
            } catch (e: Exception) {
                Log.e("SupabaseDbImpl", "Error fetching artwork by id: ${e.message}")
                emit(null)
            }
        }
    }

    override fun getArtworkByType(type: String): Flow<List<Artworks>> {
        return flow {
            try {
                val artworks = postgrest["artworks"]
                    .select {
                        filter {
                            eq("type", type)
                        }
                    }
                    .decodeList<Artworks>()
                emit(artworks)
            } catch (e: Exception) {
                Log.e("SupabaseDbImpl", "Error fetching artworks by type: ${e.message}")
                emit(emptyList())
            }
        }
    }
}

//Eğer bucket private ise, imzalı URL (signed URL) almak için başka yöntemler kullanman gerekebilir.
//    override fun getImage(imageName: String): Flow<String> = flow {
//        val url = storage.from("artworks").publicUrl(imageName)
//        emit(url)
//    }