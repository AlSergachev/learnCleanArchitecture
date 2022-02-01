package com.example.learncleanarchitecture.domain.usecase

import com.example.learncleanarchitecture.domain.models.UserName

class GetUserNameUseCase {

    fun execute(): UserName {
        return UserName(firstName = "Alex", lastName = "Miller")
    }
}