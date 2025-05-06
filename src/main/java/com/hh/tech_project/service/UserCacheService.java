package com.hh.tech_project.service;

import com.hh.tech_project.model.converter.UserConverter;
import com.hh.tech_project.model.dto.response.UserResponseDto;
import com.hh.tech_project.model.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserCacheService {

    @CachePut(value = "users", key = "#user.id")
    public UserResponseDto putUser(User user) {
        log.debug("Putting user into cache: id={}", user.getId());
        return UserConverter.toDto(user);
    }
}
