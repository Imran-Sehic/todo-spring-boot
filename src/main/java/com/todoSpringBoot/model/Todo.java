package com.todoSpringBoot.model;

import java.io.Serializable;
import javax.persistence.Entity;
import static javax.persistence.FetchType.LAZY;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Todo implements Serializable{
    
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String content;
    private boolean checked;
    private boolean deleted;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    
}
