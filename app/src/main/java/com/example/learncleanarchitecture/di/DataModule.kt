package com.example.learncleanarchitecture.di

import android.content.Context
import com.example.learncleanarchitecture.data.repository.UserRepositoryImpl
import com.example.learncleanarchitecture.data.storage.SharedPrefUserStorage
import com.example.learncleanarchitecture.data.storage.UserStorage
import com.example.learncleanarchitecture.domain.repository.UserRepository
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideUserStorage(context: Context): UserStorage {
        return SharedPrefUserStorage(context = context)
    }

    @Provides
    fun provideUserRepository(userStorage: UserStorage): UserRepository {
        return UserRepositoryImpl(userStorage = userStorage)
    }
}