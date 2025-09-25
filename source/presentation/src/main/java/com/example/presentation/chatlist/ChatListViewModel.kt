package com.example.presentation.chatlist

import androidx.lifecycle.ViewModel
import com.example.domain.entities.Chat
import com.example.domain.usecases.GetChatsUseCase
import com.example.presentation.chatlist.uimodels.UiChatsListItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import javax.inject.Inject

@HiltViewModel
class ChatListViewModel @Inject constructor(private val getChatsUseCase: GetChatsUseCase): ViewModel() {
    private val _chats = MutableStateFlow<List<Chat>>(emptyList())
    val chats: StateFlow<List<Chat>> = _chats
    val uiChatsItems = MutableStateFlow<List<UiChatsListItem>>(emptyList())

    init {
        loadChats()
        uiChatsItems.value = mapChatsToUIChatsListItems()
    }

    fun mapChatsToUIChatsListItems(): List<UiChatsListItem> {

        val uiChatsListItems = _chats.value.map {
            UiChatsListItem(
                id = it.id,
                name = it.name,
                lastMessageTime = convertMillisToHoursAndMinutes(
                    it.chatMessages.last().timestamp
                ),
                lastMessagePreview =
                    if(it.chatMessages.last().senderId == "1")
                        "You: " + it.chatMessages.last().content
                    else
                        it.chatMessages.last().content
            )
        }
        return uiChatsListItems
    }

    fun loadChats() {
        _chats.value = getChatsUseCase.invoke()
    }

    private fun convertMillisToHoursAndMinutes(milliseconds: Long): String {
        val timeFormat = DateTimeFormatter.ofPattern("HH:mm")

        return Instant.ofEpochMilli(milliseconds)
            .atZone(ZoneId.systemDefault())
            .format(timeFormat)
    }
}