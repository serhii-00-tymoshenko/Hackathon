package com.mintokoneko.hackathon.ui.employees.adapters

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mintokoneko.hackathon.databinding.ItemEmployeeBinding
import com.mintokoneko.hackathon.entities.Employee

class EmployeeAdapter(
    private val onItemClick: (Employee) -> Unit
): ListAdapter<Employee, EmployeeAdapter.EmployeeViewHolder>(DIFF_CALLBACK) {
    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Employee>() {
            override fun areItemsTheSame(oldItem: Employee, newItem: Employee) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Employee, newItem: Employee) =
                oldItem == newItem
        }
    }

    inner class EmployeeViewHolder(private val binding: ItemEmployeeBinding) : RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("ResourceAsColor")
        fun bind(employee: Employee) {
            binding.apply {
                if (adapterPosition != RecyclerView.NO_POSITION) {
                    root.setOnClickListener { onItemClick.invoke(employee) }
                }

                name.text = employee.name
                position.text = employee.position
                photo.setImageResource(employee.photo)
                val trustColor = itemView.context.getColor(employee.trustLevel)
                trustLevel.setTextColor(trustColor)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        val binding = ItemEmployeeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EmployeeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        val currentEmployee = getItem(position)
        holder.bind(currentEmployee)
    }
}