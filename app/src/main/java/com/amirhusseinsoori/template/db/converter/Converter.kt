package com.amirhusseinsoori.template.db

import androidx.room.TypeConverter
import com.amirhusseinsoori.template.api.responses.response.diverResponse.Property
import com.amirhusseinsoori.template.api.responses.response.diverResponse.Transaction
import com.amirhusseinsoori.template.api.responses.response.diverResponse.UserAvatar
import com.amirhusseinsoori.template.db.subdiver.PropertySubDiver
import com.amirhusseinsoori.template.db.subdiver.TransactionSubDiver
import com.amirhusseinsoori.template.db.subdiver.UserAvatarSubDiver
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*

class Converter(){

    private var gson = Gson()


    //Transaction
    @TypeConverter
    fun stringToSomeObjectListTransaction(data: String?): List<TransactionSubDiver?>? {
        if (data == null) {
            return Collections.emptyList()
        }
        val listType = object : TypeToken<List<TransactionSubDiver?>?>() {}.type
        return gson.fromJson<List<TransactionSubDiver?>>(data, listType)
    }
    @TypeConverter
    fun someObjectListToStringTransaction(someObjects: List<TransactionSubDiver?>?): String? = gson.toJson(someObjects)


    // ResponseValue
    @TypeConverter
    fun stringToSomeObjectListResponseValue(data: String?): List<Any?>? {
        if (data == null) {
            return Collections.emptyList()
        }
        val listType = object : TypeToken<List<Any?>?>() {}.type
        return gson.fromJson<List<Any?>>(data, listType)
    }
    @TypeConverter
    fun someObjectListToStringResponseValue(someObjects: List<Any?>?): String? = gson.toJson(someObjects)




    // UserAvatar
    @TypeConverter
    fun stringToSomeObjectListUserAvatar(data: String?): List<UserAvatarSubDiver?>? {
        if (data == null) {
            return Collections.emptyList()
        }
        val listType = object : TypeToken<List<UserAvatarSubDiver?>?>() {}.type
        return gson.fromJson<List<UserAvatarSubDiver?>>(data, listType)
    }
    @TypeConverter
    fun someObjectListToStringUserAvatar(someObjects: List<UserAvatarSubDiver?>?): String? = gson.toJson(someObjects)

    // Property
    @TypeConverter
    fun stringToSomeObjectListProperty(data: String?): List<PropertySubDiver?>? {
        if (data == null) {
            return Collections.emptyList()
        }
        val listType = object : TypeToken<List<PropertySubDiver?>?>() {}.type
        return gson.fromJson<List<PropertySubDiver?>>(data, listType)
    }
    @TypeConverter
    fun someObjectListToStringProperty(someObjects: List<PropertySubDiver?>?): String? = gson.toJson(someObjects)



}

