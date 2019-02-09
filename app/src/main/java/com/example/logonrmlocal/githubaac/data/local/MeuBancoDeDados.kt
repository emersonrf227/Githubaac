package com.example.logonrmlocal.githubaac.data.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverter
import android.arch.persistence.room.TypeConverters
import com.example.logonrmlocal.githubaac.data.local.converter.DateConverter
import com.example.logonrmlocal.githubaac.data.local.dao.UserDao
import com.example.logonrmlocal.githubaac.data.local.empty.User


@Database(entities = [User::class], version = 1)// declarações do que o banco precisa
@TypeConverters(DateConverter::class) // declarações do que o banco precisa
abstract class MeuBancoDeDados: RoomDatabase() {



    abstract fun userDao(): UserDao

  //comapanio deixa essa classe visivel em qualquer classe
    companion object {
        private val INSTANCE: MeuBancoDeDados? = null


    }
}