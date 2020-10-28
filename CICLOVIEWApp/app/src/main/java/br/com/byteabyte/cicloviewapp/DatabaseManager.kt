package br.com.byteabyte.cicloviewapp

import androidx.room.Room

object DatabaseManager {

    private var dbInstance: CicloviewDatabase

    init {
        val context = CicloviewApplication.getInstance().applicationContext
        dbInstance = Room.databaseBuilder(
            context,
            CicloviewDatabase::class.java,
            "cicloview.sqlite"
        ).build()
    }

    fun getPecaDAO(): PecaDAO {
        return dbInstance.pecaDAO()
    }
}