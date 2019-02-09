package com.example.logonrmlocal.githubaac.data.local.empty

import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.util.*

//@Entity("Usuario")  essa anotaçãop criar um banco de dados local como o mesmo nome do objeto com nome usuario

@Entity // essa anotaçãop criar um banco de dados local como o mesmo nome do objeto com nome do objeto da classe
data class User(
        @PrimaryKey(autoGenerate = true)// Da referência como chave primaria a variavel abaixo
        var id: Int = 0,

        var name: String = "",
        @SerializedName("avatar_url")
        var avatarURL: String = "",
        var login: String = "",
        var lastRefresh: Date? = null
) {
    @Ignore constructor() : this(0)
}






