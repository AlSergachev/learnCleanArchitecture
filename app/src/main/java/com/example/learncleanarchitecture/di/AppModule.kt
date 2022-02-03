package com.example.learncleanarchitecture.di

import android.content.Context
import com.example.learncleanarchitecture.domain.usecase.GetUserNameUseCase
import com.example.learncleanarchitecture.domain.usecase.SaveUserNameUseCase
import com.example.learncleanarchitecture.presentation.MainViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModule(val context: Context) {

    @Provides
    fun provideContext(): Context {
        return context
    }

    @Provides
    fun provideMainViewModelFactory(
        getUserNameUseCase: GetUserNameUseCase,
        saveUserNameUseCase: SaveUserNameUseCase
    ): MainViewModelFactory {
        return MainViewModelFactory(
            getUserNameUseCase = getUserNameUseCase,
            saveUserNameUseCase = saveUserNameUseCase
        )
    }

}