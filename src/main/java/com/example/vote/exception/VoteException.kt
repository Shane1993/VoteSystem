package com.example.vote.exception

class VoteException(
    var msg: String? = "",
    var errorCode: Int = -1
) : RuntimeException() {


}