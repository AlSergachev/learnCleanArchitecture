package com.example.learncleanarchitecture.presentation

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.learncleanarchitecture.R
import com.example.learncleanarchitecture.data.repository.UserRepositoryImpl
import com.example.learncleanarchitecture.domain.models.UserName
import com.example.learncleanarchitecture.domain.usecase.GetUserNameUseCase
import com.example.learncleanarchitecture.domain.usecase.SaveUserNameUseCase



class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userRepository by lazy { UserRepositoryImpl(context = applicationContext) }
        val getUserNameUseCase by lazy { GetUserNameUseCase(userRepository) }
        val saveUserNameUseCase by lazy { SaveUserNameUseCase(userRepository) }

        val dataTextView = findViewById<TextView>(R.id.dataTextView)
        val putFirstName = findViewById<EditText>(R.id.putFirstName)
        val putLastName = findViewById<EditText>(R.id.putLastName)
        val sendButton = findViewById<Button>(R.id.sendButton)
        val receiveButton = findViewById<Button>(R.id.receiveButton)

        sendButton.setOnClickListener{
            val firstName = putFirstName.text.toString()
            val lastName = putLastName.text.toString()
            val fullName = UserName(firstName = firstName, lastName = lastName)
            val result: Boolean = saveUserNameUseCase.execute(fullName)
            dataTextView.text = "Save result = $result"
        }

        receiveButton.setOnClickListener {
            val userName = getUserNameUseCase.execute()
            dataTextView.text = "${userName.firstName} ${userName.lastName}"
        }
    }
}