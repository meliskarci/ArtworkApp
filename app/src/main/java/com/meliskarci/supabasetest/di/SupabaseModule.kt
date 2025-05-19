package com.meliskarci.supabasetest.di

import com.meliskarci.supabasetest.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.jan.supabase.SupabaseClient

import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.storage.Storage
import io.github.jan.supabase.storage.storage

import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object SupabaseModule {

//        @Provides
//        @Singleton
//        fun provideHttpClient(): HttpClient {
//            return HttpClient(OkHttp) {
//                install(HttpTimeout) {
//                    requestTimeoutMillis = 30000
//                    connectTimeoutMillis = 15000
//                }
//                // Gerekirse başka eklentiler de ekleyebilirsin: ContentNegotiation vs.
//            }
//        }


        @Provides
        @Singleton
        fun provideSupabaseClient(

        ): SupabaseClient {
            return createSupabaseClient(

                supabaseUrl = BuildConfig.SUPABASE_URL,
                supabaseKey = BuildConfig.SUPABASE_KEY


//                supabaseUrl = BuildConfig.SUPABASE_URL,
//                supabaseKey = BuildConfig.SUPABASE_KEY,
//                httpClient = httpClient


            ) {
                install(Postgrest)
                install(Storage)
               // install(Auth)
            }
        }

    @Provides
    @Singleton
    fun providePostgrest(client: SupabaseClient): Postgrest = client.postgrest

    @Provides
    @Singleton
    fun provideSupabaseStorage(client: SupabaseClient): Storage = client.storage
//
//    @Provides
//    @Singleton
//    fun provideSupabaseAuth(client: SupabaseClient): Auth = client.auth
}
