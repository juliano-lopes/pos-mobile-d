package br.com.julianolopes.marcianoapp

open class Marciano {

    open fun responda(frase: String): String {
        val fraseTrimmed = frase.trim()
        if (fraseTrimmed.isEmpty()) {
            return "Não me incomode"
        }

        val eUmaPergunta = fraseTrimmed.endsWith("?")
        val eUmGrito = fraseTrimmed.any { it.isLetter() && it.isUpperCase() } &&
                fraseTrimmed.filter { it.isLetter() }.all { it.isUpperCase() }
        val contemEu = fraseTrimmed.contains("eu", ignoreCase = true)

        if (eUmGrito && eUmaPergunta) {
            return "Relaxa, eu sei o que estou fazendo!"
        }

        if (eUmGrito) {
            return "Opa! Calma aí!"
        }

        if (eUmaPergunta) {
            return "Certamente"
        }

        if (contemEu) {
            return "A responsabilidade é sua"
        }

        return "Tudo bem, como quiser"
    }
}