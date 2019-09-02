package com.example.vote.controller

import com.example.vote.bean.VoteABean
import com.example.vote.exception.VoteException
import com.example.vote.result.ObjectResult
import com.example.vote.service.VoteAService
import lombok.Lombok
import lombok.extern.slf4j.Slf4j
import org.apache.ibatis.logging.slf4j.Slf4jImpl
import org.apache.logging.slf4j.SLF4JLogger
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/voteA")
@Slf4j
class VoteAController {

    @Autowired
    private lateinit var voteAService: VoteAService

    @PostMapping("/vote")
    fun vote(a: Boolean, b: Boolean, c: Boolean, uid: String): ObjectResult<VoteABean> {

        println("vote -----")
        val bean = voteAService.vote(a, b, c, uid)

        return ObjectResult.ok(bean)

    }
}