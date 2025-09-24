package com.example.domain.interfaces

import com.example.domain.entities.Chat

interface ChatRepository {
    fun getChats(): List<Chat>
    fun getChatById(id: String): Chat?
}