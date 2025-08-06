package br.com.julianolopes.marcianoapp

open class MarcianoPremium(private val acao: AcaoUsuario) : MarcianoAvancado() {

    override fun responda(frase: String): String {
        val fraseNormalizada = frase.trim().lowercase()

        if (fraseNormalizada.contains("agir")) {
            val partes = fraseNormalizada.split(" ", limit = 2)
            val parametrosAcao = if (partes.size > 1) partes[1].trim() else ""
            return "É pra já! ${acao.executarAcao(parametrosAcao)}"
        }

        return super.responda(frase)
    }
}