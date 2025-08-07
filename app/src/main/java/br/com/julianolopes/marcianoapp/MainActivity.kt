package br.com.julianolopes.marcianoapp

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private val messagesList = mutableListOf<String>()
    private lateinit var messageAdapter: MessageAdapter
    private lateinit var messageEditText: EditText
    private lateinit var marciano: MarcianoAvancado
    private lateinit var messagesRecyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        messageEditText = findViewById(R.id.messageEditText)
        val sendButton = findViewById<Button>(R.id.sendButton)
        messagesRecyclerView = findViewById(R.id.messagesRecyclerView)


        // Configure o RecyclerView
        messageAdapter = MessageAdapter(messagesList) { clickedMessage ->
            sendMessage(clickedMessage)
        }
        messagesRecyclerView.layoutManager = LinearLayoutManager(this)
        messagesRecyclerView.adapter = messageAdapter

        val isPremium = intent.getBooleanExtra("IS_PREMIUM", false)


        if (isPremium) {
            val acaoPersonalizada = AcaoContagemRegressiva()
            marciano = MarcianoPremium(acaoPersonalizada)
        } else {
            marciano = MarcianoAvancado()
        }
        sendButton.setOnClickListener {
            val userMessage = messageEditText.text.toString()
            if (userMessage.isNotBlank()) {
                sendMessage(userMessage, true)
            } else {
                Toast.makeText(this, "Por favor, digite uma pergunta.", Toast.LENGTH_SHORT).show()

            }
        }
    }

    private fun sendMessage(message: String, isNew: Boolean = false) {
        // Adiciona a mensagem à lista e notifica o adaptador
        if (isNew) {
            messagesList.add(message)
            messageAdapter.notifyItemInserted(messagesList.size - 1)
            if (messagesRecyclerView.contentDescription.isNotEmpty()) {
                messagesRecyclerView.contentDescription = ""
            }


        }

        val marcianoResponse = marciano.responda(message)

        // Limpa o EditText
        messageEditText.text.clear()

        val intent = Intent(this, RespostaActivity::class.java)
        intent.putExtra("MARCIANO_RESPONSE", marcianoResponse)
        startActivity(intent)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            // Chama a função finish() para fechar esta Activity e voltar para a anterior
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}