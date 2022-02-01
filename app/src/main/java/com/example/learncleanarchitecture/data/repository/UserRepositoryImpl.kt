package com.example.learncleanarchitecture.data.repository

import android.annotation.SuppressLint
import android.content.Context
import com.example.learncleanarchitecture.domain.models.UserName
import com.example.learncleanarchitecture.domain.repository.UserRepository

private const val SHARED_PREFERENCES = "shred_pref_name"
private const val KEY_FIRST_NAME = "first_name"
private const val KEY_LAST_NAME = "last_name"
private const val KEY_DEFAULT_FIRST_NAME = "Default_first_name"
private const val KEY_DEFAULT_LAST_NAME = "Default_last_name"

class UserRepositoryImpl(private val context: Context): UserRepository{

    private val sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE)

    override fun saveName(userName: UserName): Boolean {
        sharedPreferences.edit().putString(KEY_FIRST_NAME, userName.firstName).apply()
        sharedPreferences.edit().putString(KEY_LAST_NAME, userName.lastName).apply()
        return true
    }

    override fun getName(): UserName {
        val firstName = sharedPreferences.getString(KEY_FIRST_NAME, KEY_DEFAULT_FIRST_NAME) ?: ""
        val lastName = sharedPreferences.getString(KEY_LAST_NAME, KEY_DEFAULT_LAST_NAME) ?: ""
        return UserName(firstName = firstName, lastName = lastName)
    }

}