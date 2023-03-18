package com.example.managerinfo.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserDto {
    private Long id;
    private String email;
    private String password;
    private Long roleId;
    private String phone;
    private String fullname;
}
