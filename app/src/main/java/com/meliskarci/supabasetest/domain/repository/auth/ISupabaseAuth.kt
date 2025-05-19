//package com.meliskarci.supabasetest.domain.repository.auth
//
//
//import kotlinx.coroutines.flow.Flow
//
//interface ISupabaseAuth {
//    suspend fun signIn(email: String, password: String): Result<Boolean>
//    suspend fun signUp(email: String, password: String): Result<Boolean>
//    fun isUserAuthenticated(): Boolean
//    suspend fun signOut(): Result<Unit>
//
//}