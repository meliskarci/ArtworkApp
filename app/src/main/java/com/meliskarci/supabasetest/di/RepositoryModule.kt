//package com.meliskarci.supabasetest.di
//
//import com.meliskarci.supabasetest.data.remote.repository.SupabaseAuthImpl
//import com.meliskarci.supabasetest.data.remote.repository.SupabaseDbImpl
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.components.SingletonComponent
//import io.github.jan.supabase.auth.Auth
//import io.github.jan.supabase.postgrest.Postgrest
//import io.github.jan.supabase.storage.Storage
//import javax.inject.Singleton
//
//@Module
//@InstallIn(SingletonComponent::class)
//object RepositoryModule {
//
//    @Singleton
//    @Provides
//    fun provideSupabaseDbImpl(postgrest: Postgrest, storage: Storage) : SupabaseDbImpl {
//        return SupabaseDbImpl(postgrest, storage)
//    }
//
//    @Singleton
//    @Provides
//    fun provideSupabaseAuthImpl(auth: Auth) : SupabaseAuthImpl {
//        return SupabaseAuthImpl(auth)
//
//    }
//}


package com.meliskarci.supabasetest.di

//import com.meliskarci.supabasetest.data.remote.repository.SupabaseAuthImpl
import com.meliskarci.supabasetest.data.remote.repository.SupabaseDbImpl
//import com.meliskarci.supabasetest.domain.repository.auth.ISupabaseAuth
import com.meliskarci.supabasetest.domain.repository.db.ISupabaseDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
//import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.storage.Storage
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideSupabaseDbImpl(postgrest: Postgrest, storage: Storage): ISupabaseDb {
        return SupabaseDbImpl(postgrest, storage)
    }

//    @Singleton
//    @Provides
//    fun provideSupabaseAuth(auth: Auth): ISupabaseAuth {
//        return SupabaseAuthImpl(auth)
//    }
}
