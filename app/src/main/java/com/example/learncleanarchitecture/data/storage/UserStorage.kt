package com.example.learncleanarchitecture.data.storage

interface UserStorage {

    fun save(user: User): Boolean

    fun get(): User

}