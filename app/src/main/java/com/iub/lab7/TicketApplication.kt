package com.iub.lab7

import android.app.Application

class TicketApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        TicketRepository.initialize(context = this)
    }
}