package br.com.julianolopes.marcianoapp

import kotlin.math.roundToInt

open class MarcianoAvancado : Marciano() {

    override fun responda(frase: String): String {
        val fraseNormalizada = frase.trim().lowercase()

        val partes = fraseNormalizada.split(" ")
        if (partes.size >= 3) {
            val operacao = partes[0]
            val primeiroNumero = partes.getOrNull(1)?.toDoubleOrNull()
            val segundoNumero = partes.getOrNull(2)?.toDoubleOrNull()

            if (primeiroNumero != null && segundoNumero != null) {
                val resultado: Double? = when (operacao) {
                    "some" -> primeiroNumero + segundoNumero
                    "subtraia" -> primeiroNumero - segundoNumero
                    "multiplique" -> primeiroNumero * segundoNumero
                    "divida" -> {
                        if (segundoNumero != 0.0) primeiroNumero / segundoNumero
                        else null
                    }
                    else -> null
                }

                if (resultado != null) {
                    val resultadoFormatado = if (resultado == resultado.roundToInt().toDouble()) {
                        resultado.roundToInt().toString()
                    } else {
                        resultado.toString()
                    }
                    return "Essa eu sei, $resultadoFormatado"
                }
            }
        }
        return super.responda(frase)
    }
}