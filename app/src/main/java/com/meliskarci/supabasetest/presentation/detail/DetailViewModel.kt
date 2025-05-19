package com.meliskarci.supabasetest.presentation.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.meliskarci.supabasetest.domain.model.Artworks
import com.meliskarci.supabasetest.domain.usecase.db.GetArtworkByIdUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getArtworkByIdUsecase: GetArtworkByIdUsecase,
   // private val getImageUsecase: GetImageUsecase
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _artworkDetail = MutableStateFlow<Artworks?>(null)
    val artworkDetail: StateFlow<Artworks?>
        get() = _artworkDetail.asStateFlow()

    init {
        val id = savedStateHandle.get<Int>("id") ?: 0
        if (id != 0) {
            getInstrumentById(id)
        }
    }

    private fun getInstrumentById(id: Int) {
        viewModelScope.launch {
            getArtworkByIdUsecase(id).collect {artwork ->
                _artworkDetail.value = artwork
            }
        }
    }
}