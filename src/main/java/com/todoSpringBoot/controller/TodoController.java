package com.todoSpringBoot.controller;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.todoSpringBoot.model.Todo;
import com.todoSpringBoot.dto.CreateTodo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.springframework.http.ResponseEntity.status;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.todoSpringBoot.service.TodoService;

@RestController
@RequestMapping("/api/todo/")
@AllArgsConstructor
public class TodoController {
    
    private final TodoService todoService;
    
    @GetMapping
    public ResponseEntity<List<Todo>> getAllTodosForUser(){
        return status(HttpStatus.OK).body(todoService.getAllTodosForUser());
    }
    
    @PostMapping
    public ResponseEntity<Void> insertTodo(@RequestBody CreateTodo todo){
        todoService.insertTodo(todo);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    @PutMapping
    public ResponseEntity<Void> updateTodo(@RequestBody Todo todo){
        todoService.updateTodo(todo);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable Long id){
        todoService.deleteTodo(id);
        return ResponseEntity.status(HttpStatus.OK).body("Todo deleted successfully!");
    }
    
}
