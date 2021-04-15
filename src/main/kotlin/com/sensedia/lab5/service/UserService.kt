package com.sensedia.lab5.service

import com.sensedia.lab5.model.User

interface UserService {
    fun getCurrentUser(): User?
}