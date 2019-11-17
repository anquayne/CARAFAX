package com.carafax.data.cache

import com.google.gson.Gson
import java.lang.reflect.Type
import javax.inject.Inject

class Serializer @Inject constructor() {
    private var gson: Gson? = null

    init {
        gson = Gson()
    }

    fun serialize(objectData: Any): String? {
        return gson!!.toJson(objectData, objectData.javaClass)
    }

    fun <E> deserialize(content: String?, entity: Class<E>): E {
        return gson!!.fromJson(content, entity)
    }

    fun <E> deserializeList(content: String?, type: Type?): List<E> {
        return gson!!.fromJson(content, type)
    }
}