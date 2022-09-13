package com.tech4dev.wmtchat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.tech4dev.wmtchat.adapter.ChatsAdapter

class ChatActivity : AppCompatActivity() {
    private lateinit var toolbar: Toolbar
    private lateinit var messageRV: RecyclerView
    private lateinit var message : EditText
    private lateinit var sendButton : FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        message= findViewById(R.id.message)
        sendButton=findViewById(R.id.sendButton)

        sendButton.setOnClickListener{
            val userInput= message.text.toString() ?: ""
            Toast.makeText(this,userInput, Toast.LENGTH_LONG).show()
        }

        val username: String = intent.getStringExtra("USER") ?: ""
        setupToolbar(username)
        setChatRecycleView(username)


    }

    private fun setChatRecycleView(username: String) {
        messageRV = findViewById(R.id.messageSection)
        messageRV.layoutManager = LinearLayoutManager(this)
        messageRV.adapter = ChatsAdapter(this, username)
    }

    private fun setupToolbar(username : String) {
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = username
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}