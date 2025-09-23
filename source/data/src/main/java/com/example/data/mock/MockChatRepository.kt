package com.example.data.mock

import com.example.domain.entities.Chat
import com.example.domain.interfaces.ChatRepository

//The data is mocked for only one User, with id 1
class MockChatRepository: ChatRepository {
    private val availableChats = listOf<Chat>(
        Chat(id = "c1", name = "Test Testowy", participantsIds = listOf("1", "2")),
        Chat(id = "c2", name = "Jan Kowalski", participantsIds = listOf("1", "3")),
        Chat(id = "c3", name = "Adam Gessler", participantsIds = listOf("1", "4")),
        Chat(id = "c4", name = "John Smith", participantsIds = listOf("1", "5"))
    )

    override fun getChats(): List<Chat> {
        return availableChats
    }

    override fun getChatById(id: String): Chat? {
        return availableChats.firstOrNull { c -> c.id == id }
    }
}