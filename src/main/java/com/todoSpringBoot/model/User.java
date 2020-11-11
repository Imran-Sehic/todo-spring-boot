package com.todoSpringBoot.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import static javax.persistence.GenerationType.IDENTITY;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User implements Serializable{
    
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    
}
