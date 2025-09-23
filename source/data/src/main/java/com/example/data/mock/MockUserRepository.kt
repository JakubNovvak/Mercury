package com.example.data.mock

import com.example.domain.entities.User
import com.example.domain.interfaces.UserRepository

class MockUserRepository: UserRepository {
    private val availableUsers = listOf<User>(
        User(id = "1", username = "jakubnovvak", name = "Jakub", surname = "Nowak"),
        User(id = "2", username = "", name = "Test", surname = "Testowy"),
        User(id = "3", username = "", name = "Jan", surname = "Kowalski"),
        User(id = "4", username = "", name = "Adam", surname = "Gessler"),
        User(id = "5", username = "", name = "John", surname = "Smith")
    )

    override fun getUsers(): List<User> {
        return availableUsers
    }

    override fun getUserById(id: String): User? {
        return availableUsers.firstOrNull{u -> u.id == id}
    }
}