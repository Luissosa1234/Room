package com.example.room

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.room.adapter.NotasAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    
    var app:NotaApp?=null
    var myRecyclerNotas:RecyclerView?=null
    var fadAdd:FloatingActionButton?=null
    var notas:ArrayList<Nota>?=null
    var adapter:NotasAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        app = applicationContext as NotaApp

        fadAdd = findViewById(R.id.fabAddNota)
        myRecyclerNotas = findViewById(R.id.myRecyclerNotas)

        notas = ArrayList<Nota>()

        lifecycleScope.launch {
            val notasdb = app!!.db.notaDAO().getAll()
            notas!!.addAll(notasdb)
            adapter!!.notifyDataSetChanged()
        }

        adapter = NotasAdapter(notas!!, this)

        fadAdd!!.setOnClickListener {
            val i = Intent(this, Add_Notas::class.java)
            startActivity(i)
        }

        myRecyclerNotas!!.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        myRecyclerNotas!!.setHasFixedSize(true)
        myRecyclerNotas!!.adapter = adapter

    }

    override fun onResume() {
        super.onResume()
        lifecycleScope.launch {
            adapter!!.notifyDataSetChanged()
        }
    }
}