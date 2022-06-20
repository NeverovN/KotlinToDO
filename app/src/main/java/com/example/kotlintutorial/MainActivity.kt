package com.example.kotlintutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var todoAdapter: ToDoAdapter;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        todoAdapter = ToDoAdapter(mutableListOf());

        rvToDoItems.adapter = todoAdapter;
        rvToDoItems.layoutManager = LinearLayoutManager(this);

        btnAddToDo.setOnClickListener {
            val todoTitle = etTodoInput.text.toString();
            if(todoTitle.isNotEmpty()) {
                val todo = ToDo(todoTitle);
                todoAdapter.addTodo(todo);
                etTodoInput.text.clear();
            }
        }
    }
}