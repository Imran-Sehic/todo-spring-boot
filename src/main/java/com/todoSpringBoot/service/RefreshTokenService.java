package com.todoSpringBoot.service;

import com.todoSpringBoot.exceptions.SpringTodoException;
import com.todoSpringBoot.repository.RefreshTokenRepository;
import java.time.Instant;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.todoSpringBoot.model.RefreshToken;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class RefreshTokenService {
    
    private final RefreshTokenRepository refreshTokenRepository;
    
    public RefreshToken generateRefreshToken(){
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setToken(UUID.randomUUID().toString());
        refreshToken.setCreatedDate(Instant.now());
        
        return refreshTokenRepository.save(refreshToken);
    }
    
    void validateRefreshToken(String token){
        refreshTokenRepository.findByToken(token).orElseThrow(() -> new SpringTodoException("Invalid refresh Token"));
    }
    
    public void deleteRefreshToken(String token){
        refreshTokenRepository.deleteByToken(token);
    }
    
}
