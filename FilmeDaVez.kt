fun main() {

    val filmesDeFantasia = listOf("Harry Potter", "O Senhor dos Aneis", "Hobbit", "Jogos Vorazes", "Percy Jackson", "Divergente", "Star Wars")
    val filmesDeComedia = listOf("Gente Grande", "As Branquelas", "Se Beber, Não Case", "Todo Mundo em Pânico", "As Férias da Minha Vida", "Superbad")
    val filmesDeAcao = listOf("Mad Max", "John Wick", "Die Hard", "Uncharted", "Matrix", "Velozes e Furiosos", "Rambo", "Duro de Matar")
    val filmesDeRomance = listOf("Para Todos os Garotos que já Amei", "Pride and Prejudice", "La La Land", "Titanic", "A Culpa é das Estrelas", "Diário de uma Paixão")
    val filmesDeTerror = listOf("It - A Coisa", "Five Nights at Freddys", "O Chamado", "O Grito", "Invocação do Mal", "Annabelle", "Sexta-Feira 13")

    while (true) {
        println("\nBem-vindo ao Filme da Vez!")
        println("Escolha um gênero de filme:")
        println("1. Fantasia")
        println("2. Comédia")
        println("3. Ação")
        println("4. Romance")
        println("5. Terror")
        println("6. Sair")
        print("Digite o número da sua escolha: ")

        val escolhaGenero = readLine()?.toIntOrNull()

        if (escolhaGenero == 6) {
            println("Até a próxima sessão de filme!")
            break
        }


        val filmeSorteado = sortearFilmePorGenero(
            escolhaGenero,
            filmesDeFantasia,
            filmesDeComedia,
            filmesDeAcao,
            filmesDeRomance,
            filmesDeTerror)


        if (filmeSorteado != null) {
            println("Filme sugerido: $filmeSorteado")
        } else {
            println("Escolha inválida. Tente novamente.")
        }
    }
}

fun sortearFilmePorGenero(
    genero: Int?,
    filmesDeFantasia: List<String>,
    filmesDeComedia: List<String>,
    filmesDeAcao: List<String>,
    filmesDeRomance: List<String>,
    filmesDeTerror: List<String>
): String? {
    return when (genero) {
        1 -> filmesDeFantasia.random()
        2 -> filmesDeComedia.random()
        3 -> filmesDeAcao.random()
        4 -> filmesDeRomance.random()
        5 -> filmesDeTerror.random()
        else -> null
    }
}
