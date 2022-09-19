package com.tech4dev.wmtchat.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.tech4dev.wmtchat.R
import com.tech4dev.wmtchat.SampleChats
import com.tech4dev.wmtchat.model.Chats
import com.tech4dev.wmtchat.model.Message

class ChatsAdapter (val context : Context, val listOfMessages:  List<Message>): RecyclerView.Adapter<ChatsAdapter.ChatViewHolder> (){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val  itemView: View = LayoutInflater.from(context).inflate(R.layout.chats_layout,parent,false)
        return ChatViewHolder(itemView)
    }

    override fun onBindViewHolder(holder:ChatViewHolder, position: Int) {
         val message: Message= listOfMessages[position]
        if (message.sender == "me"){
            holder.messageSent.text= message.message
            holder.messageSentTime.text=message.time

            holder.leftSection.visibility= View.GONE
        }
        else {
            holder.senderMessage.text= message.message
            holder.sendTime.text=message.time

            holder.rightSection.visibility = View.GONE
        }
    }

    override fun getItemCount(): Int {
        return listOfMessages.size
    }


    class ChatViewHolder (itemView:View ): RecyclerView.ViewHolder(itemView){
        val senderMessage: TextView = itemView.findViewById(R.id.senderMessage)
        val  sendTime : TextView= itemView.findViewById(R.id.sendTime)

        val messageSent: TextView = itemView.findViewById(R.id.messageSent)
        val messageSentTime: TextView = itemView.findViewById(R.id.messageSentTime)

        val leftSection: CardView= itemView.findViewById(R.id.sender_section)
        val rightSection : CardView = itemView.findViewById(R.id.user_section)
    }

}