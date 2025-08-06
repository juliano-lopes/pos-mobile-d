package br.com.julianolopes.marcianoapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class EscolhaRoboActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_escolha_robo)

        val btnAvancado = findViewById<Button>(R.id.btnAvancado)
        val btnPremium = findViewById<Button>(R.id.btnPremium)

        btnAvancado.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("IS_PREMIUM", false)
            startActivity(intent)
        }

        btnPremium.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("IS_PREMIUM", true)
            startActivity(intent)
        }
    }
}