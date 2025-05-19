//package com.meliskarci.supabasetest.domain.usecase.auth
//
//import com.meliskarci.supabasetest.domain.repository.auth.ISupabaseAuth
//import javax.inject.Inject
//
//class SignUpUsecase @Inject constructor(
//    private val repository: ISupabaseAuth
//) {
//    suspend operator fun invoke(email: String, password: String) : Result<Boolean> {
//        return repository.signUp(email, password)
//    }
//}
