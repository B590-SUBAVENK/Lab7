package com.iub.lab7.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.iub.lab7.database.TicketTypeConverter
import com.iub.lab7.Ticket

@Database(entities = [Ticket::class], version = 1)
@TypeConverters(TicketTypeConverter::class)
abstract class TicketDatabase : RoomDatabase() {
    abstract fun ticketDao(): TicketDao
}