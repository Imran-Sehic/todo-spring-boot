package com.todoSpringBoot.service;

import com.todoSpringBoot.repository.TodoRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.todoSpringBoot.model.Todo;
import com.todoSpringBoot.dto.CreateTodo;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class TodoService {
    
    private final TodoRepository todoRepository;
    private final AuthService authService;
    
    @Transactional(readOnly = true)
    public List<Todo> getAllTodosForUser(){
        return todoRepository.findAllByUser(authService.getCurrentUser());
    }
    
    public void insertTodo(CreateTodo createTodo){
        Todo todo = new Todo();
        
        todo.setContent(createTodo.getContent());
        todo.setChecked(false);
        todo.setDeleted(false);
        todo.setUser(authService.getCurrentUser());
        
        todoRepository.save(todo);
    }
    
    public void updateTodo(Todo todo){
        todoRepository.save(todo);
    }
    
    public void deleteTodo(Long id){
        todoRepository.deleteById(id);
    }
    
}
