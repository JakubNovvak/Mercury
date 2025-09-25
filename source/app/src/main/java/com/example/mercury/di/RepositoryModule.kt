package com.example.mercury.di

import com.example.data.mock.MockChatRepository
import com.example.data.mock.MockUserRepository
import com.example.domain.interfaces.ChatRepository
import com.example.domain.interfaces.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideChatRepository(): ChatRepository {
        return MockChatRepository()
    }

    @Provides
    @Singleton
    fun provideUserRepository(): UserRepository {
        return MockUserRepository()
    }
}