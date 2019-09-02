package com.example.vote.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import java.lang.RuntimeException
import javax.servlet.http.HttpServletResponse

@Controller
class HelloController {


    @PostMapping("/exception")
    fun testException(response: HttpServletResponse, param: String?): String {
        println("param -------> $param")

        throw RuntimeException("这是一个RuntimeException")

        return "test test"
    }

    @GetMapping("/hello")
    fun hello(): String {
        return "login.html"
    }
}