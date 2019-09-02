package com.example.vote.controller

import com.example.vote.bean.User
import com.example.vote.exception.VoteException
import com.example.vote.param.LoginParam
import com.example.vote.result.MapResult
import com.example.vote.result.ObjectResult
import com.example.vote.service.UserService
import com.example.vote.utils.RandomNumberUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.resource.HttpResource
import java.lang.RuntimeException
import javax.servlet.http.HttpServletResponse

@RestController
@RequestMapping("/user")
class UserController {

    @Autowired
    private lateinit var userService: UserService

    @PostMapping("/register")
    fun registerUser(username: String?, password: String?): ObjectResult<User> {

        var resultUser: User? = null

        username?.apply {
            val user = userService.findUser(username)

            if (user != null) {
                return ObjectResult.error("用户已存在", -1)
            }

            userService.registerUser(username, password)

            resultUser = userService.findUser(username)
        }

        if (resultUser == null) {
            return ObjectResult.error("注册失败", -1)
        } else {
            return ObjectResult.ok(resultUser)
        }

    }

    @PostMapping("/login")
    fun loginUser(loginParam: LoginParam?): ObjectResult<User> {

//        println("------userLogin")

        var user: User? = null

        loginParam?.apply {
            user = userService.loginUser(loginParam.username, loginParam.password)
        }

//        println("------user------" + user?.username + ", password --->" + user?.password)
        return ObjectResult.ok(user)
//        return ObjectResult.ok(User(111, "lllzzzsss", "ppp", 18, ""))

    }

    @PostMapping("/find")
    fun findUser(id: String): ObjectResult<User> {
        return ObjectResult.ok(userService.findUser(id))
    }

    /**
     * 抛出异常到GlobalExceptionHandler中处理
     */
    @PostMapping("/testException")
    fun textException() {
        println("-------testException--------")
        throw VoteException("This is test VoteException", -1)
    }
}