package com.example.room

import androidx.room.*

@Dao
interface NotaDAO {

    @Query("SELECT * FROM Nota")
    suspend fun getAll():List<Nota>

    @Query("SELECT * FROM Nota WHERE id = :id")
    suspend fun getById(id:Int):Nota

    @Update
    suspend fun update(nota:Nota)

    @Insert
    suspend fun insert(notas:List<Nota>)

    @Delete
    suspend fun delete(nota: Nota)


}