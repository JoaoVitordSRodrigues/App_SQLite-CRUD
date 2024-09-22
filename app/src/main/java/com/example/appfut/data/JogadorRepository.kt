package com.example.appfut.data

import kotlinx.coroutines.flow.Flow

open class JogadorRepository(private val jogadorDao: JogadorDao) {
    fun getJogador(): Flow<List<Jogador>> = jogadorDao.getJogadores()

    fun getJogadorById(id: Int): Flow<Jogador> = jogadorDao.getJogadorById(id)

    suspend fun insertJogador(jogador: Jogador) = jogadorDao.insertJogador(jogador)

    suspend fun deleteJogador(jogador: Jogador) = jogadorDao.deleteJogador(jogador)
}
