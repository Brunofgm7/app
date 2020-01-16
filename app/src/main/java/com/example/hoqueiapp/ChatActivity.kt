package com.example.hoqueiapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item
import kotlinx.android.synthetic.main.activity_chat.*
import kotlinx.android.synthetic.main.chat_from_row.view.*
import kotlinx.android.synthetic.main.chat_to_row.view.*


class ChatActivity : AppCompatActivity() {

    val adapter = GroupAdapter<GroupieViewHolder>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)
        supportActionBar?.hide()

        recyclerviewChat.adapter = adapter

        verificarLoginUtilizador()

        listenForMessages()

        BotaoEnviar.setOnClickListener {
            EnviarMensagem()
        }
    }

    private fun listenForMessages() {
        val ref = FirebaseDatabase.getInstance().getReference("/mensagens")

        ref.addChildEventListener(object : ChildEventListener {
            override fun onChildAdded(p0: DataSnapshot, p1: String?) {
                val chatMessage = p0.getValue(ChatMessage::class.java)

                if (chatMessage != null) {
                    recyclerviewChat.scrollToPosition(adapter.itemCount - 1)

                    if (chatMessage.fromId == FirebaseAuth.getInstance().uid) {
                        adapter.add(ChatToItem(chatMessage.text))
                    } else {
                        adapter.add(ChatFromItem(chatMessage.text))
                    }
                }
            }

            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onChildChanged(p0: DataSnapshot, p1: String?) {

            }

            override fun onChildMoved(p0: DataSnapshot, p1: String?) {

            }

            override fun onChildRemoved(p0: DataSnapshot) {

            }
        })
    }

    private fun verificarLoginUtilizador() {
        if (FirebaseAuth.getInstance().currentUser == null) {
            BotaoEnviar.setBackgroundResource(R.drawable.rounded_button_red)
            BotaoEnviar.isEnabled = false
            InserirMensagem.isEnabled = false
            Toast.makeText(this, "Iniciar sessão para enviar mensagem", Toast.LENGTH_LONG).show()
        }
    }

    private fun EnviarMensagem() {
        val text = InserirMensagem.text.toString()

        val fromId = FirebaseAuth.getInstance().uid
        if (fromId == null) return

        val reference = FirebaseDatabase.getInstance().getReference("/mensagens").push()
        val chatMessage = ChatMessage(reference.key!!, text, fromId)
        reference.setValue(chatMessage)
            .addOnSuccessListener {
                InserirMensagem.text.clear()
                recyclerviewChat.scrollToPosition(adapter.itemCount - 1)
            }
    }


    class ChatFromItem(val text: String) : Item<GroupieViewHolder>() {
        override fun bind(viewHolder: GroupieViewHolder, position: Int) {
            viewHolder.itemView.textView_from_row.text = text
        }

        override fun getLayout(): Int {
            return R.layout.chat_from_row
        }

    }

    class ChatToItem(val text: String) : Item<GroupieViewHolder>() {
        override fun bind(viewHolder: GroupieViewHolder, position: Int) {
            viewHolder.itemView.textView_to_row.text = text
        }

        override fun getLayout(): Int {
            return R.layout.chat_to_row
        }
    }
}