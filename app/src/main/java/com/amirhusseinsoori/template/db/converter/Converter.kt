package com.amirhusseinsoori.template.db

import androidx.room.TypeConverter
import com.amirhusseinsoori.template.api.responses.response.diverResponse.Property
import com.amirhusseinsoori.template.api.responses.response.diverResponse.Transaction
import com.amirhusseinsoori.template.api.responses.response.diverResponse.UserAvatar
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*

class Converter(){

    private var gson = Gson()


    //Transaction
    @TypeConverter
    fun stringToSomeObjectListTransaction(data: String?): List<Transaction?>? {
        if (data == null) {
            return Collections.emptyList()
        }
        val listType = object : TypeToken<List<Transaction?>?>() {}.type
        return gson.fromJson<List<Transaction?>>(data, listType)
    }
    @TypeConverter
    fun someObjectListToStringTransaction(someObjects: List<Transaction?>?): String? = gson.toJson(someObjects)


    // ResponseValue
    @TypeConverter
    fun stringToSomeObjectListResponseValue(data: String?): List<Any?>? {
        if (data == null) {
            return Collections.emptyList()
        }
        val listType = object : TypeToken<List<Any?>?>() {}.type
        return gson.fromJson<List<Transaction?>>(data, listType)
    }
    @TypeConverter
    fun someObjectListToStringResponseValue(someObjects: List<Any?>?): String? = gson.toJson(someObjects)


    // Property
    @TypeConverter
    fun stringToSomeObjectListProperty(data: String?): List<Property?>? {
        if (data == null) {
            return Collections.emptyList()
        }
        val listType = object : TypeToken<List<Property?>?>() {}.type
        return gson.fromJson<List<Property?>>(data, listType)
    }
    @TypeConverter
    fun someObjectListToStringProperty(someObjects: List<Property?>?): String? = gson.toJson(someObjects)

    // UserAvatar
    @TypeConverter
    fun stringToSomeObjectListUserAvatar(data: String?): List<UserAvatar?>? {
        if (data == null) {
            return Collections.emptyList()
        }
        val listType = object : TypeToken<List<UserAvatar?>?>() {}.type
        return gson.fromJson<List<UserAvatar?>>(data, listType)
    }
    @TypeConverter
    fun someObjectListToStringTransactionX(someObjects: List<UserAvatar?>?): String? = gson.toJson(someObjects)





}

