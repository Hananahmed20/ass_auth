package com.example.ass_auth.chat


data class Message(
    val text: String = "",
    val senderId: String = "",
    val receiverId :String = "",
    val timestamp: Long = 0

)