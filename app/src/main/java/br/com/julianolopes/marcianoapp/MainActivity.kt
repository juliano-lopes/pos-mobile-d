package br.com.julianolopes.marcianoapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val messageEditText = findViewById<EditText>(R.id.messageEditText)
        val sendButton = findViewById<Button>(R.id.sendButton)

        val isPremium = intent.getBooleanExtra("IS_PREMIUM", false)

        val marciano: MarcianoAvancado
        if (isPremium) {
            val acaoPersonalizada = AcaoContagemRegressiva()
            marciano = MarcianoPremium(acaoPersonalizada)
        } else {
            marciano = MarcianoAvancado()
        }
        sendButton.setOnClickListener {
            val userMessage = messageEditText.text.toString()

            // Chama a lógica do robô
            val marcianoResponse = marciano.responda(userMessage)

            // Limpa o EditText
            messageEditText.text.clear()

            // Cria um Intent para a próxima tela
            val intent = Intent(this, RespostaActivity::class.java)
            intent.putExtra("MARCIANO_RESPONSE", marcianoResponse)
            startActivity(intent)
        }
    }
}