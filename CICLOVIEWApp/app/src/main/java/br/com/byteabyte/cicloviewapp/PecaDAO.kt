package br.com.byteabyte.cicloviewapp

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PecaDAO {

    @Query("SELECT * FROM peca WHERE id = :id")
    fun getById(id:Long): Pecas?

    @Query("SELECT * FROM peca")
    fun getAll(): List<Pecas>

    @Insert
    fun insert(peca: Pecas)

    @Delete
    fun delete(peca: Pecas)
}