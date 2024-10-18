package com.example.filmedavez

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.filmedavez.ui.theme.FilmeDaVezTheme
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.unit.dp

val filmesDeFantasia = listOf("Harry Potter", "O Senhor dos Aneis", "Hobbit", "Jogos Vorazes", "Percy Jackson", "Divergente", "Star Wars")
val filmesDeComedia = listOf("Gente Grande", "As Branquelas", "Se Beber, Não Case", "Todo Mundo em Pânico", "As Férias da Minha Vida", "Superbad")
val filmesDeAcao = listOf("Mad Max", "John Wick", "Die Hard", "Uncharted", "Matrix", "Velozes e Furiosos", "Rambo", "Duro de Matar")
val filmesDeRomance = listOf("Para Todos os Garotos que já Amei", "Pride and Prejudice", "La La Land", "Titanic", "A Culpa é das Estrelas", "Diário de uma Paixão")
val filmesDeTerror = listOf("It - A Coisa", "Five Nights at Freddys", "O Chamado", "O Grito", "Invocação do Mal", "Annabelle", "Sexta-Feira 13")

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FilmeDaVezTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Escolha um gênero de filme",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
        setContent {
            FilmeDaVezTheme {
                var selectedGenre by remember { mutableStateOf<String?>(null) }
                var selectedMovie by remember { mutableStateOf<String?>(null) }

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
                        if (selectedGenre == null) {
                            GenreSelection { genre ->
                                selectedGenre = genre
                                selectedMovie = getRandomMovie(genre)
                            }
                        } else {
                            Text(text = "Selected Genre: $selectedGenre")
                            Text(text = "Random Movie: $selectedMovie")
                        }
                    }
                }
            }
        }
    }
}
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun GenreSelection(onGenreSelected: (String) -> Unit) {
    val genres = listOf("Fantasy", "Comedy", "Action", "Romance", "Horror")
    Column {
        genres.forEach { genre ->
            Button(onClick = { onGenreSelected(genre) }) {
                Text(text = genre)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FilmeDaVezTheme {
        Greeting("Escolha um gênero de filme")
    }
}

@Preview(showBackground = true)
@Composable
fun MovieApp() {
    FilmeDaVezTheme {
        GenreSelection {
            Column {
                Text(text = "Selected Genre: $it")
                Column(
                    modifier = Modifier
                        .background(Color.LightGray)
                        .padding(16.dp)
                ) {
                }
            }
        }
    }

    fun getRandomMovie(genre: String): String {
        return when (genre) {
            "Fantasia" -> filmesDeFantasia.random()
            "Comedia" -> filmesDeComedia.random()
            "Ação" -> filmesDeAcao.random()
            "Romance" -> filmesDeRomance.random()
            "Horror" -> filmesDeTerror.random()
            else -> "No movies available"
        }
    }
}

