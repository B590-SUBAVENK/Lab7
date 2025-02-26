package com.iub.lab7

import android.app.ProgressDialog.show
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.iub.lab7.databinding.ListItemTicketBinding

class TicketHolder(
    val binding: ListItemTicketBinding,
    val onTicketClicked: () -> Unit
): RecyclerView.ViewHolder(binding.root) {
        fun bind(ticket: Ticket) {
            binding.ticketTitle.text = ticket.title
            binding.ticketDate.text = ticket.date.toString()

            binding.root.setOnClickListener {
                onTicketClicked()
            }
            binding.ticketSolved.visibility = if (ticket.isSolved) {
                View.VISIBLE
            } else {
                View.GONE
            }

        }

}


class TicketListAdapter(
    private val tickets: List<Ticket>,
    private val onTicketClicked: () -> Unit
) : RecyclerView.Adapter<TicketHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TicketHolder {
        val inflator = LayoutInflater.from(parent.context)
        val binding = ListItemTicketBinding.inflate(inflator, parent, false)
        return TicketHolder(binding, onTicketClicked)
    }

    override fun getItemCount(): Int {
            return tickets.size
    }

    override fun onBindViewHolder(holder: TicketHolder, position: Int) {
        val ticket = tickets[position]
        holder.bind(ticket)
    }
}


