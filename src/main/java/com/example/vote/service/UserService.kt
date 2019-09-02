package com.example.vote.service

import com.example.vote.bean.User

interface UserService {

    fun registerUser(username: String?, password: String?)

    fun loginUser(username: String?, password: String?): User?

    fun findUser(username: String): User?
}