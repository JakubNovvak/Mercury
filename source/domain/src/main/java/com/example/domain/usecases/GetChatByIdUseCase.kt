package com.example.domain.usecases

import com.example.domain.entities.Chat
import com.example.domain.interfaces.ChatRepository
import javax.inject.Inject

class GetChatByIdUseCase @Inject constructor(private val repository: ChatRepository){
    operator fun invoke(chatId: String): Chat? { return repository.getChatById(chatId) }
}