package com.meliskarci.supabasetest.presentation.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.meliskarci.supabasetest.domain.model.Artworks
import com.meliskarci.supabasetest.domain.usecase.db.GetArtworkByTypeUsecase

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val getArtworkByTypeUsecase: GetArtworkByTypeUsecase
    //private val getInstrumentUsecase: GetInstrumentUsecase,
    //private val getImageUsecase: GetImageUsecase
) : ViewModel() {

//    private val _instrument = MutableStateFlow<List<Instrument>>(emptyList())
//    val instrument: StateFlow<List<Instrument>>
//        get() = _instrument.asStateFlow()

    private val _imageurl = MutableStateFlow<String>("")
    val  imageurl: StateFlow<String>
        get () = _imageurl.asStateFlow()

    init {
 //       getInstrument()
//        getImage(imageName)
    }
//
//    init {
//        getInstrumentByType(type = "")
//    }

    private val _artworks = MutableStateFlow<List<Artworks>>(emptyList())
    val artworks: StateFlow<List<Artworks>>
        get() = _artworks.asStateFlow()


    fun getArtworkByType(type: String) {
        viewModelScope.launch {
            getArtworkByTypeUsecase(type).collect {artworks ->
                _artworks.value = artworks
            }

        }
    }




//    private fun getInstrument() {
//        viewModelScope.launch {
//            getInstrumentUsecase().collect {instruments ->
//                _instrument.value = instruments
//
//            }
//        }
//    }

//    private fun getImage(imageName: String) {
//        viewModelScope.launch {
//            getImageUsecase(imageName).collect {url ->
//                _imageurl.value = url
//            }
//        }
//    }
}
