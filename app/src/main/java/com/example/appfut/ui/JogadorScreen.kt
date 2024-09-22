package com.example.appfut.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.appfut.R
import com.example.appfut.data.Jogador
import kotlin.random.Random

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JogadorScreen(viewModel: JogadorViewModel) {
    var nome by remember { mutableStateOf("") }
    var idade by remember { mutableStateOf("") }
    var posicao by remember { mutableStateOf("") }
    var clube by remember { mutableStateOf("") }
    var nacionalidade by remember { mutableStateOf("") }
    var selectedJogadorId by remember { mutableStateOf<Int?>(null) }

    val jogadorList by viewModel.jogadorList.collectAsState(initial = emptyList())

    val isFormValid = nome.isNotBlank() && idade.isNotBlank() && posicao.isNotBlank() && clube.isNotBlank() && nacionalidade.isNotBlank()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xF01C7907))
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Cadastrar Jogador",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 28.sp
                )
            )

            TextField(
                value = nome,
                onValueChange = { nome = it },
                label = { Text("Nome", color = Color.Black) },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    focusedContainerColor = Color.White.copy(alpha = 0.9f),
                    unfocusedContainerColor = Color.White.copy(alpha = 0.9f),
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = idade,
                onValueChange = { idade = it },
                label = { Text("Idade", color = Color.Black) },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    focusedContainerColor = Color.White.copy(alpha = 0.9f),
                    unfocusedContainerColor = Color.White.copy(alpha = 0.9f),
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = nacionalidade,
                onValueChange = { nacionalidade = it },
                label = { Text("Nacionalidade", color = Color.Black) },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    focusedContainerColor = Color.White.copy(alpha = 0.9f),
                    unfocusedContainerColor = Color.White.copy(alpha = 0.9f),
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = posicao,
                onValueChange = { posicao = it },
                label = { Text("Posição", color = Color.Black) },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    focusedContainerColor = Color.White.copy(alpha = 0.9f),
                    unfocusedContainerColor = Color.White.copy(alpha = 0.9f),
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = clube,
                onValueChange = { clube = it },
                label = { Text("Clube", color = Color.Black) },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    focusedContainerColor = Color.White.copy(alpha = 0.9f),
                    unfocusedContainerColor = Color.White.copy(alpha = 0.9f),
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = {
                    if (isFormValid) {

                        val iconId = Random.nextInt(0, 7)

                        viewModel.addOrUpdateJogador(selectedJogadorId, nome, idade.toIntOrNull() ?: 1, posicao, clube, nacionalidade, iconId)
                        nome = ""
                        idade = ""
                        posicao = ""
                        clube = ""
                        nacionalidade = ""
                        selectedJogadorId = null
                    }
                },
                modifier = Modifier
                    .padding(top = 16.dp)
                    .align(Alignment.CenterHorizontally),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Blue, disabledContainerColor = Color.Blue.copy(alpha = 0.5f)),
                enabled = isFormValid
            ) {
                Text(if (selectedJogadorId == null) "Adicionar Jogador" else "Atualizar Jogador", color = Color.White)
            }

            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(jogadorList) { jogador ->
                    JogadorCard(
                        jogador = jogador,
                        onEdit = {
                            nome = jogador.nome
                            idade = jogador.idade.toString()
                            posicao = jogador.posicao
                            clube = jogador.clube
                            nacionalidade = jogador.nacionalidade
                            selectedJogadorId = jogador.id
                        },
                        onDelete = { viewModel.deleteJogador(jogador) }
                    )
                }
            }
        }
    }
}

@Composable
fun JogadorCard(jogador: Jogador, onEdit: () -> Unit, onDelete: () -> Unit) {
    val iconResource = when (jogador.iconId) {
        0 -> R.drawable.ic_1
        1 -> R.drawable.ic_2
        2 -> R.drawable.ic_3
        3 -> R.drawable.ic_4
        4 -> R.drawable.ic_5
        5 -> R.drawable.ic_6
        6 -> R.drawable.ic_7
        7 -> R.drawable.ic_8
        else -> R.drawable.ic_default
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                // Ícone de camisa
                Box(
                    modifier = Modifier.size(48.dp),//.padding(8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = iconResource),
                        contentDescription = null,
                        modifier = Modifier.size(500.dp)
                    )
                }

                Spacer(modifier = Modifier.width(8.dp))

                // Nome do jogador
                Text(
                    text = jogador.nome,
                    color = Color.Black,
                    style = MaterialTheme.typography.bodyLarge
                )
            }

            Row {
                IconButton(onClick = onEdit) {
                    Icon(imageVector = Icons.Outlined.Edit, contentDescription = "Editar Jogador")
                }
                IconButton(onClick = onDelete) {
                    Icon(imageVector = Icons.Outlined.Delete, contentDescription = "Excluir Jogador")
                }
            }
        }
    }
}
