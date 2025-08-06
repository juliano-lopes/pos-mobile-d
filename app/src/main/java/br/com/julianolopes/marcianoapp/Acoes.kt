package br.com.julianolopes.marcianoapp

class Acoes {
    private val acoes: Map<Int, AcaoUsuario> = mapOf(
        1 to AcaoContagemRegressiva()
    )

    fun getAcao(value: Int): AcaoUsuario? {
        return acoes[value]
    }
}