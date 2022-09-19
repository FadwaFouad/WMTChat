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
import com.tech4dev.wmtchat.model.Chats
import com.tech4dev.wmtchat.model.Message
import java.text.SimpleDateFormat
import java.util.*

class ChatActivity : AppCompatActivity() {
    private lateinit var toolbar: Toolbar
    private lateinit var messageRV: RecyclerView
    private lateinit var messageTyped : EditText
    private lateinit var sendButton : FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        messageTyped= findViewById(R.id.message)
        sendButton=findViewById(R.id.sendButton)


        // get list of messages
        val sendername: String = intent.getStringExtra("USER") ?: ""
        val sampleChats= SampleChats()
        val chat: Chats? = sampleChats.getChatOf(sendername)
        val listOfMessages : MutableList<Message> = chat!!.message.toMutableList()

        sendButton.setOnClickListener{
            val userInput= messageTyped.text.toString()
            val time: String= SimpleDateFormat("h:mm a").format(Date())
            // should get the specific avatar
            val defaultAvatar= R.drawable.avatar_man1
            val userMessage= Message("me", time,userInput,sendername,defaultAvatar )
            listOfMessages.add(userMessage)
            setChatRecycleView(listOfMessages)
            messageTyped.setText("")

        }


        setupToolbar(sendername)
        setChatRecycleView(listOfMessages)


    }

    private fun setChatRecycleView(listOfMessages: List<Message>) {
        messageRV = findViewById(R.id.messageSection)
        messageRV.layoutManager = LinearLayoutManager(this)
        messageRV.adapter = ChatsAdapter(this, listOfMessages)
    }

    private fun setupToolbar(username : String) {
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = username
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}