package com.hh.tech_project.model.converter;

import com.hh.tech_project.model.dto.request.UserRequestDto;
import com.hh.tech_project.model.dto.response.UserResponseDto;
import com.hh.tech_project.model.entity.User;

import java.time.LocalDateTime;

public class UserConverter {

    public static UserResponseDto toDto(User user) {
        UserResponseDto dto = new UserResponseDto();
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setCreatedAt(user.getCreatedAt());
        dto.setUpdatedAt(user.getUpdatedAt());
        return dto;
    }

    public static User toEntity(UserRequestDto dto) {
        User user = new User();
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        return user;
    }

    public static void updateEntity(User user, UserRequestDto dto) {
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        user.setUpdatedAt(LocalDateTime.now());
    }

}
