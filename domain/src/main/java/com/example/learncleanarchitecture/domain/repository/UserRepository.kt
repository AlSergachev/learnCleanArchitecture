package com.example.learncleanarchitecture.domain.repository

import com.example.learncleanarchitecture.domain.models.UserName

interface UserRepository {

    fun saveName(userName: UserName): Boolean

    fun getName(): UserName

}