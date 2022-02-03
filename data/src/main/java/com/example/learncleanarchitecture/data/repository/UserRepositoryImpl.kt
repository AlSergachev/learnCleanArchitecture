package com.example.learncleanarchitecture.data.repository

import com.example.learncleanarchitecture.data.storage.User
import com.example.learncleanarchitecture.data.storage.UserStorage
import com.example.learncleanarchitecture.domain.models.UserName
import com.example.learncleanarchitecture.domain.repository.UserRepository


class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {

    override fun saveName(userName: UserName): Boolean {
        val user = User(firstName = userName.firstName, lastName = userName.lastName)
        return userStorage.save(user)
    }

    override fun getName(): UserName {
        val user = userStorage.get()
        return UserName(firstName = user.firstName, lastName = user.lastName)
    }

}