package com.sparta.scheduleappadvance.dto;

import com.sparta.scheduleappadvance.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDto extends CommonDto {
    private String username;
    private String email;

    public UserResponseDto(User user) {
        this.id = user.getId();
        this.createdAt = user.getCreatedAt();
        this.updatedAt = user.getUpdatedAt();
        this.username = user.getUsername();
        this.email = user.getEmail();
    }
}
