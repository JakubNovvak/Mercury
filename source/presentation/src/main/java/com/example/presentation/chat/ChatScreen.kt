package com.example.presentation.chat

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.presentation.chat.components.ChatMessageBubble
import com.example.presentation.chat.components.ChatTextField
import com.example.presentation.chat.components.ChatTopBar

@Composable
fun ChatScreen(
    onCancel: () -> Unit,
    viewModel: ChatViewModel = hiltViewModel()
) {
    val chatInfo = viewModel.chatInfo
    val chatMessages = viewModel.uiChatMessages.collectAsState().value
    val loggedInUserId = viewModel.loggedInUserId

    Scaffold(
        modifier = Modifier.fillMaxSize().imePadding(),
        containerColor = Color.White,
        topBar = { ChatTopBar(onCancel, chatInfo!!.name) },
        bottomBar = { ChatTextField() },
        content = { innerPadding ->
            LazyColumn(
                contentPadding = innerPadding,
                modifier = Modifier
                    .padding(top = 25.dp)
                    .padding(horizontal = 20.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start,
            ) {
                items(chatMessages) {message ->
                    ChatMessageBubble(
                        content = message.content,
                        isOwnMessage = message.senderId == loggedInUserId,
                        timeStamp = message.timestamp
                    )
                }
            }
        }
    )
}