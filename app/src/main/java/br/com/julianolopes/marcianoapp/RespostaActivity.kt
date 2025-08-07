package br.com.julianolopes.marcianoapp

import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RespostaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resposta)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val answerTextView = findViewById<TextView>(R.id.answerTextView)

        val marcianoResponse = intent.getStringExtra("MARCIANO_RESPONSE")
        answerTextView.text = marcianoResponse
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}