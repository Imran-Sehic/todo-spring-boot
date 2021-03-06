package com.todoSpringBoot.dto;

import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginResponse {
    
    private String authenticationToken;
    private String refreshToken;
    private Instant expiresAt;
    private String username;
    
}
