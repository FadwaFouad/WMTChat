package com.tech4dev.wmtchat

import com.tech4dev.wmtchat.model.*

class SampleData {
    val LIST_OF_FRIENDS: List<User> = listOf(
        User("James Paul", "Hi i am alive"),
        User("Joan Okereke", "Hey i am using whatsapp"),
        User("Miracle Ebere", "Programming vibes"),
        User("Fadwa Fuad", "I love coding"),
        User("Ruth Okeniyi", "Hey i am using whatsapp"),
    )
}
class SampleCalls{
    val LIST_OF_CALLS: MutableList<CallModel> = mutableListOf(
        CallModel("Jerry Springer", "Sptember 15, 10:19"),
        CallModel("Vivian Okorie", "September 16, 11:20"),
        CallModel("Michael Spence", "September 16, 02:13"),
        CallModel("+234 8125260122", "September 22, 12:05")
    )
}
class SampleStatus{
    val LIST_OF_STATUS: List<Status> = listOf(
        Status("Ann B", "23 minutes ago"),
        Status("Jonah Clement", "10 Minutes ago"),
        Status("Eze Emmanuel", "7 hours ago"),
        Status("John Cham", "10 hours ago")
    )
}


class SampleMessages{
    val LIST_OF_MESSAGES: List<Message> = listOf(
        Message("Joan Okereke", "19:00", "I need to get my book","me", R.drawable.avatar_girl),
        Message("Emelda Joe", "07:00", "Hello, hope you are okay","me", R.drawable.avatar_man1),
        Message("Mr. Atimi", "09:00", "Ther will be class","me", R.drawable.avatar_man2),
        Message("Job Man", "17:00", "Come for the interview","me",R.drawable.avatar_man3),
    )
}

class SampleChats{
    val LIST_OF_CHATS: List<Chats> = listOf(
        Chats("Joan Okereke", listOf(
            Message("Joan Okereke", "19:00", "I need to get my book","me",R.drawable.avatar_girl),
            Message("me", "19:00", "I need to get my book","Joan Okereke",R.drawable.avatar_girl),
        )),
        Chats("Emelda Joe", listOf(
            Message("Emelda Joe", "07:00", "Hello, hope you are okay","me",R.drawable.avatar_man1),
        )),
    )

    fun getChatOf (username:String) : Chats? {
        for (item in LIST_OF_CHATS){
            if (item.sender == username)
                return item
        }
        return null
    }
}