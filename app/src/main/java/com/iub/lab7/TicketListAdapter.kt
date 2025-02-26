package com.iub.lab7

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.iub.lab7.databinding.ListItemTicketBinding
import com.iub.lab7.databinding.ListItemTicketManagerBinding

private const val NORMAL_TICKET = 0
private const val MANAGER_TICKET = 1

class TicketHolder(
    private val binding: ListItemTicketBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(ticket: Ticket) {
        binding.ticketTitle.text = ticket.title
        binding.ticketDate.text = ticket.date.toString()

        binding.root.setOnClickListener {
            Toast.makeText(binding.root.context, "${ticket.title} clicked!", Toast.LENGTH_SHORT).show()
        }
    }
}

class ManagerTicketHolder(
    private val binding: ListItemTicketManagerBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(ticket: Ticket) {
        binding.ticketTitle.text = ticket.title
        binding.ticketDate.text = ticket.date.toString()

        binding.contactManagerButton.setOnClickListener {
            Toast.makeText(binding.root.context, "Contacting manager for ${ticket.title}!", Toast.LENGTH_SHORT).show()
        }
    }
}

class TicketListAdapter(
    private val tickets: List<Ticket>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return if (tickets[position].requiresManager) MANAGER_TICKET else NORMAL_TICKET
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return when (viewType) {
            MANAGER_TICKET -> {
                val binding = ListItemTicketManagerBinding.inflate(inflater, parent, false)
                ManagerTicketHolder(binding)
            }
            else -> {
                val binding = ListItemTicketBinding.inflate(inflater, parent, false)
                TicketHolder(binding)
            }
        }
    }

    override fun getItemCount(): Int = tickets.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val ticket = tickets[position]

        when (holder) {
            is TicketHolder -> holder.bind(ticket)
            is ManagerTicketHolder -> holder.bind(ticket)
        }
    }
}