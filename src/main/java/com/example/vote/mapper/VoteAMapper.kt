package com.example.vote.mapper

import com.example.vote.bean.VoteABean
import org.springframework.stereotype.Repository

@Repository
interface VoteAMapper {
    fun insertVoteA(a: Boolean, b: Boolean, c: Boolean, uid: String)

    fun updateVoteA(a: Boolean, b: Boolean, c: Boolean, uid: String)

    fun findVoteA(uid: String): VoteABean?
}