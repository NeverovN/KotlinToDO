package com.example.kotlintutorial

import android.graphics.Color
import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_todo.view.*


class ToDoAdapter(
    private val todos: MutableList<ToDo>
) : RecyclerView.Adapter<ToDoAdapter.ToDoViewHolder>() {

    class ToDoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView);

    private fun toggleCheckBox(tvToDoDesc: TextView, isChecked: Boolean) {
        if (isChecked) {
            tvToDoDesc.paintFlags = tvToDoDesc.paintFlags or STRIKE_THRU_TEXT_FLAG

        } else {
            tvToDoDesc.paintFlags = tvToDoDesc.paintFlags and STRIKE_THRU_TEXT_FLAG.inv()
        }
    }

    fun addTodo(todo: ToDo) {
        this.todos.add(todo);
        notifyItemInserted(this.todos.size - 1);
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        return ToDoViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_todo,
                parent,
                false
            ),
        );
    }

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        val currentTODo = todos[position];


        holder.itemView.apply {
            tvToDoDesc.text = currentTODo.title;
            cbToDoDone.isChecked = currentTODo.isChecked;
            toggleCheckBox(tvToDoDesc, currentTODo.isChecked);
            cbToDoDone.setOnCheckedChangeListener { some, isChecked ->
                toggleCheckBox(tvToDoDesc, isChecked);
                currentTODo.isChecked = !currentTODo.isChecked
            }
        }
    }

    override fun getItemCount(): Int {
        return this.todos.size;
    };

}