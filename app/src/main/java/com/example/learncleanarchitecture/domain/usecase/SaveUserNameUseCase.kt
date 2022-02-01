package com.example.learncleanarchitecture.domain.usecase

import com.example.learncleanarchitecture.domain.models.SaveUserNameParam

class SaveUserNameUseCase {

    fun execute(param: SaveUserNameParam): Boolean{
        if(param.name.isEmpty()){
            return false
        }
        else
            return true
    }
}