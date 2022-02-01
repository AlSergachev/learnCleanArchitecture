package com.example.learncleanarchitecture.domain.usecase

import com.example.learncleanarchitecture.domain.models.UserName
import com.example.learncleanarchitecture.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository){

    fun execute(): UserName {
        return userRepository.getName()
    }
}