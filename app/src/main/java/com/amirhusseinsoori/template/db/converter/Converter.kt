package com.amirhusseinsoori.template.db

import androidx.room.TypeConverter
import com.amirhusseinsoori.template.db.subdiver.PropertySubEntity
import com.amirhusseinsoori.template.db.subdiver.TransactionSubEntity
import com.amirhusseinsoori.template.db.subdiver.UserAvatarSubEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*

class Converter(){

    private var gson = Gson()


    //Transaction
    @TypeConverter
    fun stringToSomeObjectListTransaction(data: String?): List<TransactionSubEntity?>? {
        if (data == null) {
            return Collections.emptyList()
        }
        val listType = object : TypeToken<List<TransactionSubEntity?>?>() {}.type
        return gson.fromJson<List<TransactionSubEntity?>>(data, listType)
    }
    @TypeConverter
    fun someObjectListToStringTransaction(someObjects: List<TransactionSubEntity?>?): String? = gson.toJson(someObjects)


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
    fun stringToSomeObjectListUserAvatar(data: String?): List<UserAvatarSubEntity?>? {
        if (data == null) {
            return Collections.emptyList()
        }
        val listType = object : TypeToken<List<UserAvatarSubEntity?>?>() {}.type
        return gson.fromJson<List<UserAvatarSubEntity?>>(data, listType)
    }
    @TypeConverter
    fun someObjectListToStringUserAvatar(someObjects: List<UserAvatarSubEntity?>?): String? = gson.toJson(someObjects)

    // Property
    @TypeConverter
    fun stringToSomeObjectListProperty(data: String?): List<PropertySubEntity?>? {
        if (data == null) {
            return Collections.emptyList()
        }
        val listType = object : TypeToken<List<PropertySubEntity?>?>() {}.type
        return gson.fromJson<List<PropertySubEntity?>>(data, listType)
    }
    @TypeConverter
    fun someObjectListToStringProperty(someObjects: List<PropertySubEntity?>?): String? = gson.toJson(someObjects)



}

