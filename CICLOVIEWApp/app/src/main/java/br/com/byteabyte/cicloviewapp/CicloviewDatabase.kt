package br.com.byteabyte.cicloviewapp

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Pecas::class), version = 1)
abstract class CicloviewDatabase: RoomDatabase() {
    abstract fun pecaDAO(): PecaDAO

}