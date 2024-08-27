package com.sparta.scheduleappadvance.dto;

import com.sparta.scheduleappadvance.entity.User;
import lombok.Getter;

@Getter
public class UserInfoDto {
    private Long id;
    private String username;
    private String email;
    
    public UserInfoDto(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
    }
}
