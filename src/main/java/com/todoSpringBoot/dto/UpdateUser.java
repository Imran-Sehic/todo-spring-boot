package com.todoSpringBoot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUser {
    
    private String firstname;
    private String lastname;
    private String oldPassword;
    private String newPassword;
    
}
