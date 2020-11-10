package com.todoSpringBoot.model;

import java.time.Instant;
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
@Entity("refresh_token")
public class RefreshToken {
    
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String token;
    private Instant createdDate;
    
}
