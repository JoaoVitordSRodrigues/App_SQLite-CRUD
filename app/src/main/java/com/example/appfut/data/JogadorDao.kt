package com.example.appfut.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface JogadorDao {
    @Query("SELECT * FROM jogadores")
    fun getJogadores(): Flow<List<Jogador>>

    @Query("SELECT * FROM jogadores WHERE id = :id")
    fun getJogadorById(id: Int): Flow<Jogador>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertJogador(jogador: Jogador)

    @Delete
    suspend fun deleteJogador(jogador: Jogador)
}
