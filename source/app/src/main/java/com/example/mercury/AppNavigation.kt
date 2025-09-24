package com.example.mercury

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.presentation.chat.ChatScreen
import com.example.presentation.chatlist.ChatListScreen
import com.example.presentation.login.LoginScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "login",
    )
    {
        composable("login") {
            LoginScreen(onLogin = { navController.navigate("chats") })
        }
        composable("chats") {
            ChatListScreen(onChatClick = {navController.navigate("chat/{chatId}")})
        }
        composable("chat/{chatId}") {
            ChatScreen()
        }
    }
}