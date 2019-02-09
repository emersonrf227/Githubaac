package com.example.logonrmlocal.githubaac.data.local.converter

import android.arch.persistence.room.TypeConverter
import java.sql.Timestamp
import java.util.*


object DateConverter {
    //ELE CONVERTE O TIME EM LONG
    @TypeConverter @JvmStatic
    //@type faz a conversão de times para log e o @jvm ele forma de organizar a conversão
    fun toDate(timestamp: Long?): Date? {
        return if (timestamp == null) null else Date(timestamp)

    }

    //ELE CONVERTER LONG EM TIME
    @TypeConverter @JvmStatic
    fun toTimestamp(date: Date?): Long? {

        return date?.time
    }
}