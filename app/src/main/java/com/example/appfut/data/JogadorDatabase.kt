package com.example.appfut.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Jogador::class], version = 1, exportSchema = false)
abstract class JogadorDatabase : RoomDatabase() {
    abstract fun jogadorDao(): JogadorDao
}
