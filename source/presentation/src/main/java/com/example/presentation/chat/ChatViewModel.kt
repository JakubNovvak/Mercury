package com.example.presentation.chat

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(
  savedStateHandle: SavedStateHandle
) : ViewModel() {

    val chatId: StateFlow<String> = savedStateHandle.getStateFlow(
        key = "chatId",
        initialValue = "null"
    )
}