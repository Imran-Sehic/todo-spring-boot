package com.todoSpringBoot.service;

import com.todoSpringBoot.repository.RefreshTokenRepository;
import com.todoSpringBoot.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.todoSpringBoot.dto.UpdateUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.todoSpringBoot.model.User;
import com.todoSpringBoot.dto.RefreshTokenRequest;

@Service
@AllArgsConstructor
public class UserService {
    
    private final UserRepository userRepository;
    private final RefreshTokenRepository refreshTokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthService authService;
    
    public boolean updateUser(UpdateUser updateUser){
        User user = userRepository.findByUsername(authService.getCurrentUser().getUsername()).get();
        
        user.setFirstname(updateUser.getFirstname());
        user.setLastname(updateUser.getLastname());
        
        if(!updateUser.getNewPassword().isEmpty()){
            
            String newPasswordEncoded = passwordEncoder.encode(updateUser.getOldPassword());
            
            if(newPasswordEncoded.equals(user.getPassword())){
                user.setPassword(newPasswordEncoded);
            }else{
                return false;
            }
        }
        
        userRepository.save(user);
        
        
        return true;
    }
    
    public void deleteUser(){
        userRepository.delete(authService.getCurrentUser());
    }
    
}
