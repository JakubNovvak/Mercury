package com.example.data.mock

import com.example.domain.entities.Chat
import com.example.domain.entities.Message
import com.example.domain.interfaces.ChatRepository
import com.example.domain.mock.mockChats

//The data is mocked for only one User, with id 1
class MockChatRepository: ChatRepository {
    private var availableChats = mockChats

    override fun getChats(): List<Chat> {
        return availableChats
    }

    override fun getChatById(id: String): Chat? {
        return availableChats.firstOrNull { c -> c.id == id }
    }

    override fun getMessagesByChatId(chatId: String): List<Message> {
        return availableChats.firstOrNull { it.id == chatId }!!.chatMessages
    }
}