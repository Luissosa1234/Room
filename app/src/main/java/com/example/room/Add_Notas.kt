package com.example.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.room.adapter.NotasAdapter
import kotlinx.coroutines.launch

class Add_Notas : AppCompatActivity() {


    var app:NotaApp?=null
    var etTitulo: EditText?=null
    var etContenido: EditText?=null
    var imgBtnGuardar: ImageButton?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add__notas)


        app = applicationContext as NotaApp

        etTitulo = findViewById(R.id.tvTituloNota)
        etContenido = findViewById(R.id.tvContenidoNota)
        imgBtnGuardar = findViewById(R.id.imgBtnGuardar)

        imgBtnGuardar!!.setOnClickListener{
            val titulo = etTitulo!!.text.toString()
            val contenido = etContenido!!.text.toString()

            if( titulo != ""){
                val nota = Nota(id = 0, titulo, contenido)
                val notas = listOf<Nota>(nota)


                lifecycleScope.launch {
                    app!!.db.notaDAO().insert(notas)
                }

                etTitulo!!.setText("")
                etContenido!!.setText("")

            }else{
                Toast.makeText(this, "Ingresa un titulo", Toast.LENGTH_SHORT).show()
            }
        }


    }
}