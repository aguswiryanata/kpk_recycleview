package com.gmail.wiryanatha.agus.kpkrecyclerview

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

class Database (ctx: Context):
        ManagedSQLiteOpenHelper(ctx,"kpk", null,1) {
    companion object {
        private var instance: Database? = null
        @Synchronized
        fun getInstance(ctx: Context): Database {
            if (instance == null) {
                instance = Database(ctx.applicationContext)
            }
            return instance!!
        }
    }


    override fun onCreate(db: SQLiteDatabase?) {
   db?.createTable("pelanggan",true,
       "idpel" to TEXT+ PRIMARY_KEY,
       "nama" to TEXT,
       "alamat" to TEXT,
       "tarif" to TEXT,
       "daya" to TEXT,
       "gardu" to TEXT,
       "tiang" to TEXT,
       "notelp" to TEXT

          )
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}


        // akses property dari Context
val Context.database: Database
get() = Database.getInstance(applicationContext)

