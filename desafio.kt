// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class IllegalMatriculaException(mensagem: String) : Throwable(mensagem)

data class Usuario(val nome: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60, val nivel: Nivel)

data class Formacao(val nome: String, val conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    operator fun iterator(): Iterator<Usuario> {
        return inscritos.iterator()
    }

    @Throws(IllegalMatriculaException::class)
    fun matricular(usuario: Usuario) {
        if (inscritos.contains(usuario)) {
            throw IllegalMatriculaException("Usuario ${usuario.nome} já faz parte da formação $nome")
        }
        inscritos.add(usuario)
        println("Usuario ${usuario.nome} adicionado com sucesso a formação $nome")
    }
}

fun main() {
    val user1 = Usuario("Joao")
    val user2 = Usuario("Maria")
    val user3 = Usuario("Jose")

    val conteudo1 = ConteudoEducacional(nome = "Introducao a programacao", nivel = Nivel.BASICO)
    val conteudo2 = ConteudoEducacional(nome = "Laco de repeticao", duracao = 120, nivel = Nivel.INTERMEDIARIO)
    val conteudo3 = ConteudoEducacional(nome = "Orientacao a objetos", duracao = 180, nivel = Nivel.DIFICIL)

    val conteudoList: List<ConteudoEducacional> = listOf(conteudo1, conteudo2, conteudo3)
    val formacaoKotlin = Formacao("Formacao Kotlin", conteudoList)
    formacaoKotlin.matricular(user1)
    formacaoKotlin.matricular(user2)
    formacaoKotlin.matricular(user3)
    formacaoKotlin.matricular(user1)
}
