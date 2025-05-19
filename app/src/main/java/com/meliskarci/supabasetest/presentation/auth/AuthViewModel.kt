//package com.meliskarci.supabasetest.ui.auth
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.meliskarci.supabasetest.domain.usecase.auth.IsUserAuthenticatedUsecase
//import com.meliskarci.supabasetest.domain.usecase.auth.SignInUsecase
//import com.meliskarci.supabasetest.domain.usecase.auth.SignOutUsecase
//import com.meliskarci.supabasetest.domain.usecase.auth.SignUpUsecase
//import dagger.hilt.android.lifecycle.HiltViewModel
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.StateFlow
//import kotlinx.coroutines.flow.asStateFlow
//import kotlinx.coroutines.launch
//import javax.inject.Inject
//
//@HiltViewModel
//class AuthViewModel @Inject constructor(
//    private val signInUsecase: SignInUsecase,
//    private val signUpUsecase: SignUpUsecase,
//    private val signOutUsecase: SignOutUsecase,
//    private val isUserAuthenticatedUsecase: IsUserAuthenticatedUsecase
//) : ViewModel() {
//
//    private val _isAuthenticated = MutableStateFlow(false)
//    val isAuthenticated: StateFlow<Boolean> = _isAuthenticated.asStateFlow()
//
//    private val _errorMessage = MutableStateFlow<String?>(null)
//    val errorMessage: StateFlow<String?> = _errorMessage.asStateFlow()
//
//    init {
//        isUserAuthenticated()
//    }
//
//    private fun isUserAuthenticated() {
//        _isAuthenticated.value = isUserAuthenticatedUsecase()
//    }
//
//    fun signUp(email: String, password: String, passwordConfirmation: String) {
//        if (password != passwordConfirmation) {
//            _errorMessage.value = "Şifreler uyuşmuyor"
//            return
//        }
//
//        viewModelScope.launch {
//            signUpUsecase(email, password).onSuccess { isSuccess ->
//                if (isSuccess) {
//                    _isAuthenticated.value = true
//                    _errorMessage.value = null
//                } else {
//                    _errorMessage.value = "Kayıt başarısız, lütfen tekrar deneyin."
//                }
//            }.onFailure { exception ->
//                _isAuthenticated.value = false
//                _errorMessage.value = exception.localizedMessage
//            }
//        }
//    }
//
//    fun signIn(email: String, password: String) {
//        viewModelScope.launch {
//            signInUsecase(email, password).onSuccess { isSuccess ->
//                if (isSuccess) {
//                    _isAuthenticated.value = true
//                    _errorMessage.value = null
//                } else {
//                    _errorMessage.value = "Giriş başarısız, lütfen tekrar deneyin."
//                }
//            }.onFailure { exception ->
//                _isAuthenticated.value = false
//                _errorMessage.value = exception.localizedMessage
//            }
//        }
//    }
//
//    fun signOut() {
//        viewModelScope.launch {
//            signOutUsecase().onSuccess {
//                _isAuthenticated.value = false
//            }.onFailure { exception ->
//                _errorMessage.value = exception.localizedMessage
//            }
//        }
//    }
//}
