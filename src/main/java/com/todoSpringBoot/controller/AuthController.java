package com.todoSpringBoot.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.todoSpringBoot.dto.LoginRequest;
import com.todoSpringBoot.dto.LoginResponse;
import com.todoSpringBoot.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import com.todoSpringBoot.dto.RefreshTokenRequest;
import javax.validation.Valid;
import com.todoSpringBoot.dto.RegisterRequest;
import org.springframework.http.HttpStatus;
import com.todoSpringBoot.service.AuthService;
import com.todoSpringBoot.service.RefreshTokenService;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {
    
    private final AuthService authService;
    private final RefreshTokenService refreshTokenService;
    
    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest){
        return authService.login(loginRequest);
    }
    
    @PostMapping("/signup")
    public boolean signup(@RequestBody RegisterRequest registerRequest){
        return authService.signup(registerRequest);
    }
    
    @PostMapping("/refresh/token")
    public LoginResponse refreshToken(@Valid @RequestBody RefreshTokenRequest refreshTokenRequest){
        return authService.refreshToken(refreshTokenRequest);
    }
    
    @PostMapping("/logout")
    public ResponseEntity<String> logout(@Valid @RequestBody RefreshTokenRequest refreshTokenRequest){
        refreshTokenService.deleteRefreshToken(refreshTokenRequest.getRefreshToken());
        return ResponseEntity.status(HttpStatus.OK).body("Logout successfully!");
    }
    
}
