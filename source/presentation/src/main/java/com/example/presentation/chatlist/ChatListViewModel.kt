package com.example.presentation.chatlist

import androidx.lifecycle.ViewModel
import com.example.domain.entities.Chat
import com.example.domain.interfaces.ChatRepository
import com.example.domain.usecases.GetChatsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class ChatListViewModel @Inject constructor(private val getChatsUseCase: GetChatsUseCase): ViewModel() {
    private val _chats = MutableStateFlow<List<Chat>>(emptyList())
    val chats: StateFlow<List<Chat>> = _chats

    init {
        loadChats()
    }

    fun loadChats() {
        _chats.value = getChatsUseCase.invoke()
    }
}