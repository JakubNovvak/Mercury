package com.example.presentation.chatlist.uimodels

data class UiChatsListItem(
    val id: String,
    val name: String,
    val lastMessageTime: String,
    val lastMessagePreview: String
)