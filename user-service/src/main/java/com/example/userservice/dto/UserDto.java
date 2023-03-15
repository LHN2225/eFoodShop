package com.example.userservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private Long id;
    private String email;

    public UserDto(Long id, String email) {
        this.id = id;
        this.email = email;
    }
    public UserDto() {
    }

}
