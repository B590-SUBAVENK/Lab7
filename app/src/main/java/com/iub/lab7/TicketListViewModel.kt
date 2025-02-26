package com.iub.lab7

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iub.lab7.Ticket
import com.iub.lab7.TicketRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
private const val TAG = "TicketListViewModel"

class TicketListViewModel : ViewModel() {

    private val ticketRepository = TicketRepository.get()

    private val _tickets: MutableStateFlow<List<Ticket>> = MutableStateFlow(emptyList())
    val tickets: StateFlow<List<Ticket>>
        get() = _tickets.asStateFlow()

    init {
        viewModelScope.launch {
            ticketRepository.getTickets().collect {
                _tickets.value = it
            }
        }
    }
}