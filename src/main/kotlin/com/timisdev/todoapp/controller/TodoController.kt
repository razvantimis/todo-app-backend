package com.timisdev.todoapp.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

data class Todo (
    val text: String,
)

@RestController
@RequestMapping("/api/v1/todo")
class TodoController {
    
    @GetMapping()
    fun getTodos(): ArrayList<Todo> {
        
        val list = arrayListOf(
            Todo("merg la cumparaturi")
        )
        
        return list
        
    }
}