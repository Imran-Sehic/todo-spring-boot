package com.todoSpringBoot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.JoinColumn;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Todo {
    
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String content;
    private boolean checked;
    private boolean deleted;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    
}
