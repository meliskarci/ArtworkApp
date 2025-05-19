package com.meliskarci.supabasetest.di

//import com.meliskarci.supabasetest.data.remote.repository.SupabaseAuthImpl
import com.meliskarci.supabasetest.data.remote.repository.SupabaseDbImpl
//import com.meliskarci.supabasetest.domain.repository.auth.ISupabaseAuth
//import com.meliskarci.supabasetest.domain.usecase.auth.IsUserAuthenticatedUsecase
//import com.meliskarci.supabasetest.domain.usecase.auth.SignInUsecase
//import com.meliskarci.supabasetest.domain.usecase.auth.SignOutUsecase
//import com.meliskarci.supabasetest.domain.usecase.auth.SignUpUsecase
import com.meliskarci.supabasetest.domain.usecase.db.GetArtworkByIdUsecase
import com.meliskarci.supabasetest.domain.usecase.db.GetArtworkByTypeUsecase
import com.meliskarci.supabasetest.domain.usecase.db.GetArtworksUsecase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton



@Module
@InstallIn(SingletonComponent::class)
object UsecaseModule {

    @Singleton
    @Provides
    fun provideGetArtworksUsecase(repository: SupabaseDbImpl) : GetArtworksUsecase {
        return GetArtworksUsecase(repository)

    }

    @Singleton
    @Provides
    fun provideGetArtworkByIdUsecase(repository: SupabaseDbImpl) : GetArtworkByIdUsecase {
        return GetArtworkByIdUsecase(repository)

    }

    @Singleton
    @Provides
    fun provideGetArtworkByTypeUsecase(repository: SupabaseDbImpl) : GetArtworkByTypeUsecase {
        return GetArtworkByTypeUsecase(repository)

    }

    /////////////////////
//    @Singleton
//    @Provides
//    fun provideSignInUsecase(repository: ISupabaseAuth): SignInUsecase {
//        return SignInUsecase(repository)
//    }
//
//    @Singleton
//    @Provides
//    fun provideSignUpUsecase(repository: ISupabaseAuth): SignUpUsecase {
//        return SignUpUsecase(repository)
//    }
//
//    @Singleton
//    @Provides
//    fun provideSignOutUsecase(repository: ISupabaseAuth): SignOutUsecase {
//        return SignOutUsecase(repository)
//    }
//
//    @Singleton
//    @Provides
//    fun provideIsUserAuthenticatedUsecase(repository: ISupabaseAuth): IsUserAuthenticatedUsecase {
//        return IsUserAuthenticatedUsecase(repository)
//    }



}