package com.example.hoqueiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item

import kotlinx.android.synthetic.main.activity_chat.*
import kotlinx.android.synthetic.main.chat_from_row.view.*
import kotlinx.android.synthetic.main.chat_to_row.view.*

class ChatActivity : AppCompatActivity() {

    companion object {
        val TAG = "ChatLog"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        //verificarLoginUtilizador()

        supportActionBar?.title = "Chat"

        ChatConversas()

        BotaoEnviar.setOnClickListener {
           Log.d(TAG, "Tentativa de envio de mensagem")
            EnviarMensagem()
        }

        }

    private fun EnviarMensagem() {
        // como é que enviar
    }

    private fun ChatConversas() {
        val adapter = GroupAdapter<GroupieViewHolder>()

        adapter.add(ChatFromItem("FROM MESSSSSSSSAGE"))
        adapter.add(ChatToItem("TO MESSAAAAAAAAAAAAAAAAA\nAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAGE"))
        adapter.add(ChatFromItem("FROM MESSSSSSSSAGE"))
        adapter.add(ChatToItem("TO MESSAAAAAAAAAAAAAAAAA\nAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAGE"))
        adapter.add(ChatFromItem("FROM MESSSSSSSSAGE"))
        adapter.add(ChatToItem("TO MESSAAAAAAAAAAAAAAAAA\nAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAGE"))
        adapter.add(ChatFromItem("FROM MESSSSSSSSAGE"))
        adapter.add(ChatToItem("TO MESSAAAAAAAAAAAAAAAAA\nAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAGE"))

        recyclerviewChat.adapter = adapter
    }



    /*private fun verificarLoginUtilizador() {
        val uid = FirebaseAuth.getInstance().uid
        if (uid == null) {
            val x = Intent(this, LoginActivity::class.java)
            x.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(x)
        }*/
}

class ChatFromItem(val text: String): Item<GroupieViewHolder>() {
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.textView_from_row.text = text
    }

    override fun getLayout(): Int {
        return R.layout.chat_from_row
    }

}

class ChatToItem(val text: String): Item<GroupieViewHolder>() {
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.textView_to_row.text = text
    }

    override fun getLayout(): Int {
        return R.layout.chat_to_row
    }

}