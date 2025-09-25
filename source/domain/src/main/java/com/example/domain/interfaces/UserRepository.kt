package com.example.domain.interfaces

import com.example.domain.entities.User

interface UserRepository {
    fun getUsers(): List<User>
    fun getUserById(id: String): User?
}