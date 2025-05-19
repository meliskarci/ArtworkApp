//package com.meliskarci.supabasetest.data.remote.repository
//
//import com.meliskarci.supabasetest.domain.repository.auth.ISupabaseAuth
//import io.github.jan.supabase.auth.Auth
//import io.github.jan.supabase.auth.providers.builtin.Email
//import javax.inject.Inject
//
//class SupabaseAuthImpl @Inject constructor(
//    private val auth: Auth
//) : ISupabaseAuth {
//
//    override suspend fun signIn(email: String, password: String): Result<Boolean> = try {
//        auth.signInWith(Email) {
//            this.email = email
//            this.password = password
//        }
//        Result.success(true)
//    } catch (e: Exception) {
//        Result.failure(e)
//    }
//
//    override suspend fun signUp(email: String, password: String): Result<Boolean> = try {
//        auth.signUpWith(Email) {
//            this.email = email
//            this.password = password
//        }
//        Result.success(true)
//    } catch (e: Exception) {
//        Result.failure(e)
//    }
//
//    override fun isUserAuthenticated(): Boolean =
//        auth.currentUserOrNull() != null
//
//    override suspend fun signOut(): Result<Unit> = try {
//        auth.signOut()
//        Result.success(Unit)
//    } catch (e: Exception) {
//        Result.failure(e)
//    }
//}
//
//
//
//
//
//
//
//
//
//
//
////package com.meliskarci.supabasetest.data.remote.repository
////
////import com.meliskarci.supabasetest.domain.repository.auth.ISupabaseAuth
////import io.github.jan.supabase.auth.Auth
////import io.github.jan.supabase.auth.providers.builtin.Email
////import javax.inject.Inject
////
////class SupabaseAuthImpl @Inject constructor(
////    private val auth: Auth
////) : ISupabaseAuth {
////    override suspend fun signIn(email: String, password: String): Result<Boolean> {
////        return try {
////            auth.signInWith(Email) {
////                this.email = email
////                this.password = password
////            }
////            Result.success(true)
////            } catch (e: Exception) {
////                Result.failure(e)
////        }
////    }
////
////    override suspend fun signUp(email: String, password: String): Result<Boolean> {
////        return try {
////            auth.signUpWith(Email) {
////                this.email = email
////                this.password = password
////            }
////            Result.success(true)
////        } catch (e: Exception) {
////            Result.failure(e)
////        }
////    }
////
////    override fun isUserAuthenticated(): Boolean {
////        return auth.currentUserOrNull() != null
////    }
////
////
////
////    override suspend fun signOut(): Result<Unit> {
////        return try {
////            auth.signOut()
////            Result.success(Unit)
////        } catch (e: Exception) {
////            Result.failure(e)
////        }
////    }
////}