package com.example.domain.usecases

import com.example.domain.entities.Chat
import com.example.domain.interfaces.ChatRepository
import javax.inject.Inject

class GetChatsUseCase @Inject constructor(private val repository: ChatRepository) {
    operator fun invoke(): List<Chat> { return repository.getChats() }
}