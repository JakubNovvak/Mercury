package com.example.domain.mock

import com.example.domain.entities.Chat

val mockChats = listOf(
    Chat(
        id = "c1",
        name = "Test Testowy",
        participantsIds = listOf("1", "2"),
        chatMessages = mockMessagesChat1
    ),

    Chat(
        id = "c2",
        name = "Jan Kowalski",
        participantsIds = listOf("1", "3"),
        chatMessages = mockMessagesChat2
    ),

    Chat(
        id = "c3",
        name = "Chat with Adam 🍏",
        participantsIds = listOf("1", "4"),
        chatMessages = mockMessagesChat3
    ),

    Chat(
        id = "c4",
        name = "John Smith",
        participantsIds = listOf("1", "5"),
        chatMessages = mockMessagesChat4
    )
)