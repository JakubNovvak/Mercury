package com.example.presentation.chatlist

import androidx.compose.foundation.Image
import com.example.presentation.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontVariation
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.example.presentation.chatlist.components.ChatListElement

@Composable
fun ChatListScreen(
    viewModel: ChatListViewModel = hiltViewModel(),
    onChatClick: (chatId: String) -> Unit
    ): Unit {
    val chats = viewModel.uiChatsItems.collectAsState().value

    Column {
        Row(
            modifier = Modifier
                .height(110.dp)
                .fillMaxWidth()
                .padding(top = 35.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = (R.drawable.mercury_logo)),
                    contentDescription = "Mercury logo",
                    modifier = Modifier.scale(0.6f, 0.6f)
                )
                Text(
                    text = "Mercury",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.W400,
                    modifier = Modifier.padding(top = 5.dp)
                )
            }

            Row(
                modifier = Modifier.padding(end = 20.dp, top = 5.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.Settings,
                    contentDescription = "Settings Icon",
                    modifier = Modifier.size(35.dp),
                    tint = Color.Gray
                )
            }
        }

        HorizontalDivider(color = Color.LightGray)

        LazyColumn (
            modifier = Modifier
                .fillMaxSize() //will automatically fill the rest of the screen
                .padding(top = 25.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start,
        ) {
            items(chats) { chat ->
                Button(
                    onClick = {onChatClick(chat.id)},
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
                ) {
                    ChatListElement(
                        title = chat.name,
                        lastMessageTime = chat.lastMessageTime,
                        lastMessagePreview = chat.lastMessagePreview
                    )
                }
            }
        }
    }
}