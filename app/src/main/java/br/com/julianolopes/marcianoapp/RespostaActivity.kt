package br.com.julianolopes.marcianoapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RespostaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resposta)

        val answerTextView = findViewById<TextView>(R.id.answerTextView)

        // Pega a resposta do Intent
        val marcianoResponse = intent.getStringExtra("MARCIANO_RESPONSE")

        // Exibe a resposta
        answerTextView.text = marcianoResponse
    }
}