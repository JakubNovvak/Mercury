package com.example.presentation.chat

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Cancel
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.internal.composableLambda
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.presentation.R
import com.example.presentation.chat.components.ChatMessageBubble
import com.example.presentation.chat.components.ChatTextField
import com.example.presentation.chat.components.ChatTopBar

@Composable
fun ChatScreen(
    onCancel: () -> Unit,
    viewModel: ChatViewModel = hiltViewModel()
): Unit {
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