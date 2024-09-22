package com.example.appfut.data

import android.content.Context
import androidx.room.Room

class AppContainer(context: Context) {
    private val database: JogadorDatabase by lazy {
        Room.databaseBuilder(context, JogadorDatabase::class.java, "db_futebol").build()
    }

    val jogadorRepository: JogadorRepository by lazy {
        JogadorRepository(database.jogadorDao())
    }
}