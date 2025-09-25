package com.example.domain.mock

import com.example.domain.entities.Message

//TODO(Base time for timestamps is 2 hours into the past. This is due to not yet implemented
// handling of timestamp older than 24h)

val baseTime = System.currentTimeMillis() - 2 * 60 * 60 * 1000

fun addMinutesToBaseTime(minutes: Int): Long = baseTime + minutes * 60 * 1000

val mockMessagesChat1 = listOf(
    Message(
        id ="1",
        chatId = "c1",
        senderId = "2",
        content = "Hello",
        timestamp = addMinutesToBaseTime(0)
    ),
    Message(
        id ="1",
        chatId = "c1",
        senderId = "1",
        content = "Hi",
        timestamp = addMinutesToBaseTime(5)
    ),
    Message(
        id ="1",
        chatId = "c1",
        senderId = "2",
        content = "How are you?",
        timestamp = addMinutesToBaseTime(7)
    ),
    Message(
        id ="1",
        chatId = "c1",
        senderId = "1",
        content = "Good - thanks for asking!",
        timestamp = addMinutesToBaseTime(9)
    )
)

val mockMessagesChat2 = listOf(
    Message(
        id ="1",
        chatId = "c2",
        senderId = "3",
        content = "Hi",
        timestamp = addMinutesToBaseTime(20)
    ),
    Message(
        id ="1",
        chatId = "c2",
        senderId = "3",
        content = "How are you?",
        timestamp = addMinutesToBaseTime(25)
    ),
    Message(
        id ="1",
        chatId = "c2",
        senderId = "3",
        content = "Hope you're doing well",
        timestamp = addMinutesToBaseTime(40)
    )
)

val mockMessagesChat3 = listOf(
    Message(
        id ="1",
        chatId = "c3",
        senderId = "4",
        content = "Hi",
        timestamp = addMinutesToBaseTime(41)
    ),
    Message(
        id ="1",
        chatId = "c3",
        senderId = "4",
        content = "regarding our last call",
        timestamp = addMinutesToBaseTime(44)
    ),
    Message(
        id ="1",
        chatId = "c3",
        senderId = "4",
        content = "I think I will pass today's meeting",
        timestamp = addMinutesToBaseTime(49)
    ),
    Message(
        id ="1",
        chatId = "c3",
        senderId = "1",
        content = "Hi - sorry to hear that",
        timestamp = addMinutesToBaseTime(55)
    ),
    Message(
        id ="1",
        chatId = "c3",
        senderId = "1",
        content = "Maybe next time - we'll be in touch!",
        timestamp = addMinutesToBaseTime(56)
    ),
    Message(
        id ="1",
        chatId = "c3",
        senderId = "4",
        content = "Of course! :)",
        timestamp = addMinutesToBaseTime(70)
    ),
)

val mockMessagesChat4 = listOf(
    Message(
        id ="1",
        chatId = "c4",
        senderId = "1",
        content = "Hi",
        timestamp = addMinutesToBaseTime(90)
    ),
    Message(
        id ="1",
        chatId = "c4",
        senderId = "1",
        content = "Hello?",
        timestamp = addMinutesToBaseTime(92)
    ),
    Message(
        id ="1",
        chatId = "c4",
        senderId = "1",
        content = "Are you there?",
        timestamp = addMinutesToBaseTime(94)
    )
)