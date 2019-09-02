package com.example.vote.result

/**
 * 格式化的返回类对象
 * 该data是一个map，由多个键值对拼接而成（ObjectResult的data是一个对象）
 */
class MapResult private constructor() : BasicResult<MutableMap<String, Any?>>() {

    init {
        data = mutableMapOf()
    }


    companion object {

        fun createByKV(key: String, value: Any): MapResult {
            val map = mutableMapOf<String, Any>()
            map[key] = value
            return createByMap(map)
        }

        fun createByMap(map: Map<String, Any>): MapResult {
            val appResult = MapResult()
            appResult.data?.putAll(map)
            return appResult
        }

    }


}