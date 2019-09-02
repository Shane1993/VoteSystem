package com.example.vote.result

/**
 * 该对象的data是一个对象，区别于MapResult的data是一个Map
 */
class ObjectResult<T> private constructor(): BasicResult<T>() {


    companion object {

        fun <T> ok(data: T?): ObjectResult<T> {
            val objectResult = ObjectResult<T>()
            objectResult.data = data
            return objectResult
        }

        fun <T> error(msg: String? = "", error: Int = -1): ObjectResult<T> {
            return ObjectResult<T>().also {
                it.error = error
                it.msg = msg
            }

        }
    }
}