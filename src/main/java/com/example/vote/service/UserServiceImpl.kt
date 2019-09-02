package com.example.vote.service

import com.example.vote.bean.User
import com.example.vote.exception.VoteException
import com.example.vote.mapper.UserMapper
import com.example.vote.result.ObjectResult
import com.example.vote.utils.RandomNumberUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserServiceImpl: UserService {

    @Autowired
    private lateinit var userMapper: UserMapper

    override fun registerUser(username: String?, password: String?) {
        userMapper.registerUser(username, password)
    }

    override fun loginUser(username: String?, password: String?): User? {
        val user = userMapper.loginUser(username, password)

        if (user == null) {
            throw VoteException("账号或密码错误")
        } else {
            with(user) {
                // 生成token
                val token = RandomNumberUtil.creatUUID32()
                authKey = token

                // 更新数据库中的token数据
                userMapper.updateUser(user)

                return user
            }
        }
    }

    override fun findUser(id: String): User? {
        return userMapper.findUser(id)
    }
}