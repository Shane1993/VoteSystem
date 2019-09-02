package com.example.vote.bean

data class User(
        var id: Long?,
        var username: String?,
        var password: String?,
        var age: Int?,
        var authKey: String? // token
) {
}