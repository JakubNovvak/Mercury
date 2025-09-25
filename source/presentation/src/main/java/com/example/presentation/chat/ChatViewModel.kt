package com.example.presentation.chat

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.domain.entities.Message
import com.example.domain.usecases.GetChatByIdUseCase
import com.example.domain.usecases.GetMessagesByChatIdUseCase
import com.example.presentation.chat.uimodels.UiMessageBubble
import com.example.presentation.common.helpers.convertMillisToHoursAndMinutes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(
    getChatByIdUseCase: GetChatByIdUseCase,
    private val getMessagesByChatIdUseCase: GetMessagesByChatIdUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    val loggedInUserId = "1" //Hard coded, since there is currently no logging in functionality
    private var _chatId: StateFlow<String> = savedStateHandle.getStateFlow(
        key = "chatId",
        initialValue = "null"
    )
    val chatInfo = getChatByIdUseCase.invoke(_chatId.value)

    private var _chatMessages = MutableStateFlow<List<Message>>(emptyList())
    val uiChatMessages = MutableStateFlow<List<UiMessageBubble>>(emptyList())

    init {
        loadChatMessage()
        uiChatMessages.value = mapMessagesToUIMessageBubbles()
    }

    private fun mapMessagesToUIMessageBubbles(): List<UiMessageBubble> {
        val uiMessageBubbles = _chatMessages.value.map { UiMessageBubble(
            senderId =  it.senderId,
            content = it.content,
            timestamp = convertMillisToHoursAndMinutes(it.timestamp)
        ) }

        return uiMessageBubbles
    }

    private fun loadChatMessage() {
        _chatMessages.value = getMessagesByChatIdUseCase.invoke(_chatId.value)
    }


}