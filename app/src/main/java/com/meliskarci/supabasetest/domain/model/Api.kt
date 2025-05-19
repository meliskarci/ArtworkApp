package com.meliskarci.supabasetest.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Artworks(
    val id: Int,
    val name: String,
    val type: String,
    val artist: String?,
    val year: String?,
    val location: String,
    val description: String,
    val image_name: String?
)