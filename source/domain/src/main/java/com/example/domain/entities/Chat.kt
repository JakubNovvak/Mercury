package com.example.domain.entities

data class Chat(
    val id: String,
    val name: String,
    val participantsIds: List<String>,
    val chatMessages: List<Message> = mutableListOf<Message>()
)
