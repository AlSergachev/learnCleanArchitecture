package com.example.learncleanarchitecture.data.storage

import android.content.Context

private const val SHARED_PREFERENCES = "shred_pref_name"
private const val KEY_FIRST_NAME = "first_name"
private const val KEY_LAST_NAME = "last_name"
private const val KEY_DEFAULT_FIRST_NAME = "Default_first_name"
private const val KEY_DEFAULT_LAST_NAME = "Default_last_name"

class SharedPrefUserStorage(private val context: Context) : UserStorage {

    private val sharedPreferences =
        context.getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE)

    override fun save(user: User): Boolean {
        sharedPreferences.edit().putString(KEY_FIRST_NAME, user.firstName).apply()
        sharedPreferences.edit().putString(KEY_LAST_NAME, user.lastName).apply()
        return true
    }

    override fun get(): User {
        val firstName = sharedPreferences.getString(KEY_FIRST_NAME, KEY_DEFAULT_FIRST_NAME) ?: ""
        val lastName = sharedPreferences.getString(KEY_LAST_NAME, KEY_DEFAULT_LAST_NAME) ?: ""
        return User(firstName = firstName, lastName = lastName)
    }

}