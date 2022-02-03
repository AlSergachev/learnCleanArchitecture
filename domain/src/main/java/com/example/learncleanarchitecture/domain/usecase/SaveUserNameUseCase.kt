package com.example.learncleanarchitecture.domain.usecase

import com.example.learncleanarchitecture.domain.models.UserName
import com.example.learncleanarchitecture.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(userName: UserName): Boolean {

        if (userName.firstName == userRepository.getName().firstName) {
            return true
        }

        return userRepository.saveName(userName = userName)
    }
}