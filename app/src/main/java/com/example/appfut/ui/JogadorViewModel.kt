package com.example.appfut.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appfut.data.JogadorRepository
import com.example.appfut.data.Jogador
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class JogadorViewModel(private val repository: JogadorRepository) : ViewModel() {

    val jogadorList: Flow<List<Jogador>> = repository.getJogador()

    fun getJogadorById(id: Int): Flow<Jogador> = repository.getJogadorById(id)

    fun addOrUpdateJogador(id: Int? = null, nome: String, idade: Int, posicao: String, clube: String, nacionalidade: String, iconId: Int) {
        val jogador = Jogador(id = id ?: 0, nome = nome,  idade = idade, posicao = posicao, clube = clube, nacionalidade = nacionalidade, iconId = iconId)
        viewModelScope.launch {
            repository.insertJogador(jogador)
        }
    }

    fun deleteJogador(jogador: Jogador) {
        viewModelScope.launch {
            repository.deleteJogador(jogador)
        }
    }
}
