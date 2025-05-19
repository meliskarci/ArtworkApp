//package com.meliskarci.supabasetest.domain.usecase.auth
//
//import com.meliskarci.supabasetest.domain.repository.auth.ISupabaseAuth
//import javax.inject.Inject
//
//class SignOutUsecase @Inject constructor(
//    private val repository: ISupabaseAuth
//) {
//    suspend operator fun invoke(): Result<Unit> {
//        return repository.signOut()
//    }
//}
