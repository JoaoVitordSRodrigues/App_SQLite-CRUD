package com.example.appfut.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "jogadores")
data class Jogador(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nome: String,
    val idade: Int,
    val posicao: String,
    val clube: String,
    val nacionalidade: String,
    val iconId: Int
)
