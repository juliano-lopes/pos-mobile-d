package br.com.julianolopes.marcianoapp

class AcaoContagemRegressiva : AcaoUsuario {
    override fun executarAcao(parametros: String): String {
        val numeroInicial = parametros.toIntOrNull()
        return if (numeroInicial != null && numeroInicial > 0) {
            val sb = StringBuilder()
            for (i in numeroInicial downTo 1) {
                sb.append("$i... ")
            }
            sb.append("Lançar!")
            sb.toString()
        } else {
            "Não entendi para fazer a contagem. Diga 'agir [número]'."
        }
    }
}