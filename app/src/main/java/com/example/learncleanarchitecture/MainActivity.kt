package com.example.learncleanarchitecture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.learncleanarchitecture.domain.models.SaveUserNameParam
import com.example.learncleanarchitecture.domain.usecase.GetUserNameUseCase
import com.example.learncleanarchitecture.domain.usecase.SaveUserNameUseCase

    private val getUserNameUseCase = GetUserNameUseCase()
    private val saveUserNameUseCase = SaveUserNameUseCase()

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataTextView = findViewById<TextView>(R.id.dataTextView)
        val dataEditText = findViewById<EditText>(R.id.dataEditText)
        val sendButton = findViewById<Button>(R.id.sendButton)
        val receiveButton = findViewById<Button>(R.id.receiveButton)

        sendButton.setOnClickListener{
            val text = dataEditText.text.toString()
            val param = SaveUserNameParam(text)
            val result: Boolean = saveUserNameUseCase.execute(param)
            dataTextView.text = "Save result = $result"
        }

        receiveButton.setOnClickListener {
            val userName = getUserNameUseCase.execute()
            dataTextView.text = "${userName.firstName} ${userName.lastName}"
        }
    }
}