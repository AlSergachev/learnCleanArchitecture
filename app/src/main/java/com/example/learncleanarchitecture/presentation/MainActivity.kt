package com.example.learncleanarchitecture.presentation

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.learncleanarchitecture.R
import com.example.learncleanarchitecture.app.App
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var vmFactory: MainViewModelFactory

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (applicationContext as App).appComponent.inject(this)

        Log.e("AAA", "Activity created")

        viewModel = ViewModelProvider(this, vmFactory).get(MainViewModel::class.java)

        val dataTextView = findViewById<TextView>(R.id.dataTextView)
        val putFirstName = findViewById<EditText>(R.id.putFirstName)
        val putLastName = findViewById<EditText>(R.id.putLastName)
        val sendButton = findViewById<Button>(R.id.sendButton)
        val receiveButton = findViewById<Button>(R.id.receiveButton)

        viewModel.resultLife.observe(this, { text ->
            dataTextView.text = text
        })

        sendButton.setOnClickListener {
            val firstName = putFirstName.text.toString()
            val lastName = putLastName.text.toString()
            viewModel.save(firstName, lastName)
        }

        receiveButton.setOnClickListener {
            viewModel.load()
        }
    }
}