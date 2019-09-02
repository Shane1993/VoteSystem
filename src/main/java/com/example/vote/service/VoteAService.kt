package com.example.vote.service

import com.example.vote.bean.VoteABean

interface VoteAService {
    fun vote(a: Boolean, b: Boolean, c: Boolean, uid: String): VoteABean?
}