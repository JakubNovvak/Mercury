package com.example.mercury

import androidx.compose.runtime.Composable
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavHost
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.presentation.chat.ChatScreen
import com.example.presentation.chat.ChatViewModel
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
            ChatListScreen(onChatClick = {chatId -> navController.navigate("chat/${chatId}")})
        }
        composable(
            "chat/{chatId}",
            arguments = listOf(navArgument("chatId"){ type = NavType.StringType})
        ) {
            //Here hiltViewModel acquires SavedStateHandle with chatId from the NavBackStackEntry.
            //It makes chatId available directly in the ChatViewModel
            val viewModel: ChatViewModel = hiltViewModel()
            ChatScreen(viewModel)
        }
    }
}