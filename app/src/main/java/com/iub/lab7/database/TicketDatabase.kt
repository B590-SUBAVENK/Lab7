package com.iub.lab7.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.iub.lab7.database.TicketTypeConverter
import com.iub.lab7.Ticket

@Database(entities = [Ticket::class], version = 2)
@TypeConverters(TicketTypeConverter::class)
abstract class TicketDatabase : RoomDatabase() {
    abstract fun ticketDao(): TicketDao
}
val migration_1_2 = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL(
            "ALTER TABLE Ticket ADD COLUMN time TEXT NOT NULL DEFAULT ''"
        )
    }
}