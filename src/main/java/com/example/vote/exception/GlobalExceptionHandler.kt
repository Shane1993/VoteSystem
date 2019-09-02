package com.example.vote.exception

import com.example.vote.result.ObjectResult
import lombok.extern.slf4j.Slf4j
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.core.annotation.Order
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import java.lang.Exception

/**
 * 全局异常处理类
 */
@ControllerAdvice
@Slf4j
class GlobalExceptionHandler {

    private val log = LoggerFactory.getLogger(this.javaClass)

    @ExceptionHandler(VoteException::class)
    @ResponseBody
    fun handleVoteException(exception: VoteException): ObjectResult<Any> {
//        println("VoteException -> ${exception.msg}")
        log.error("VoteException", exception.msg)
        return ObjectResult.error(exception.msg, exception.errorCode)
    }

    /**
     * 捕获其他的所有的异常
     */
    @ExceptionHandler(Exception::class)
    @ResponseBody
    fun handleVoteException(exception: Exception): ObjectResult<Any> {
//        println("Exception -> ${exception.message}")
        log.error("Exception", exception.message)
        return ObjectResult.error(exception.message)
    }
}