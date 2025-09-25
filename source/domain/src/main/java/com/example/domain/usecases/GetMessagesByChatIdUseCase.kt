package com.example.domain.usecases

import com.example.domain.entities.Message
import com.example.domain.interfaces.ChatRepository
import javax.inject.Inject

class GetMessagesByChatIdUseCase @Inject constructor(private val repository: ChatRepository) {
    operator fun invoke(chatId: String): List<Message> {
        val searchedChat = repository.getChats().firstOrNull { it.id == chatId }

        if(searchedChat == null)
            return emptyList<Message>()

        return searchedChat.chatMessages
    }
}