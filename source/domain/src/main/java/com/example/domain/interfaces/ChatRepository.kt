package com.example.domain.interfaces

import com.example.domain.entities.Chat
import com.example.domain.entities.Message

interface ChatRepository {
    fun getChats(): List<Chat>
    fun getChatById(id: String): Chat?
    fun getMessagesByChatId(chatId: String): List<Message>
}