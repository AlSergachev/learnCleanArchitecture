package com.example.learncleanarchitecture.presentation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.learncleanarchitecture.data.repository.UserRepositoryImpl
import com.example.learncleanarchitecture.data.storage.SharedPrefUserStorage
import com.example.learncleanarchitecture.domain.models.UserName
import com.example.learncleanarchitecture.domain.usecase.GetUserNameUseCase
import com.example.learncleanarchitecture.domain.usecase.SaveUserNameUseCase

class MainViewModel(
    private val saveUserNameUseCase : SaveUserNameUseCase,
    private val getUserNameUseCase: GetUserNameUseCase
): ViewModel() {

    var resultLife = MutableLiveData<String>()

    fun save(firstName: String, lastName: String){
        val fullName = UserName(firstName = firstName, lastName = lastName)
        val resultData: Boolean = saveUserNameUseCase.execute(fullName)
        resultLife.value = "Save result = $resultData"
    }

    fun load(){
        val userName = getUserNameUseCase.execute()
        resultLife.value =  "${userName.firstName} ${userName.lastName}"
    }


    init {Log.e("AAA", "VM created")}

    override fun onCleared() {
        Log.e("AAA", "VM cleared")
        super.onCleared()
    }

}