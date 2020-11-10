package com.todoSpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.todoSpringBoot.model.Todo;
import com.todoSpringBoot.model.User;
import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long>{
    List<Todo> findAllByUser(User user);
}
