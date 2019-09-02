package com.example.vote.result

open class BasicResult<T>{

    var error: Int = 0
    var msg: String? = ""
    var data: T? = null
}