package com.example.vote.filter

import org.springframework.context.annotation.ComponentScan
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component
import javax.servlet.Filter
import javax.servlet.FilterChain
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.annotation.WebFilter
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
@WebFilter("/*")
@Order(1)
class VoteFilter: Filter {

    override fun doFilter(request: ServletRequest?, response: ServletResponse?, filterChain: FilterChain?) {
        println("this is VoteFilter")

        val httpRequest = request as HttpServletRequest
        val httpResponse = response as HttpServletResponse

        // 处理跨域问题
        httpResponse.addHeader("Access-Control-Allow-Origin", "*")


        filterChain?.doFilter(httpRequest, httpResponse)


    }
}