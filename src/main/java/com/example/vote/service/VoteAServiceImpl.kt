package com.example.vote.service

import com.example.vote.bean.VoteABean
import com.example.vote.exception.VoteException
import com.example.vote.mapper.UserMapper
import com.example.vote.mapper.VoteAMapper
import com.example.vote.result.ObjectResult
import lombok.extern.slf4j.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
@Slf4j
class VoteAServiceImpl : VoteAService {

    @Autowired
    private lateinit var userMapper: UserMapper

    @Autowired
    private lateinit var voteAMapper: VoteAMapper

    override fun vote(a: Boolean, b: Boolean, c: Boolean, uid: String): VoteABean? {

        val user = userMapper.findUser(uid)
        if (user == null) {
            throw VoteException("请先登录")
        }

        val bean = voteAMapper.findVoteA(uid)
        if (bean == null) {
            voteAMapper.insertVoteA(a, b, c, uid)
            print("vote  --------> 插入成功")
        } else {

            voteAMapper.updateVoteA(a, b, c, uid)
            print("vote  --------> 更新成功")
        }
        return voteAMapper.findVoteA(uid)


    }
}