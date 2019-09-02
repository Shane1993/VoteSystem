package com.example.vote.mapper

import com.example.vote.bean.User
import org.springframework.stereotype.Repository

@Repository
interface UserMapper {

    fun registerUser(username: String?, password: String?)

    fun loginUser(username: String?, password: String?): User?

    fun findUser(id: String): User?

    fun updateUser(user: User)
}