package com.hh.tech_project.service;

import com.hh.tech_project.exception.ResourceNotFoundException;
import com.hh.tech_project.model.converter.UserConverter;
import com.hh.tech_project.model.dto.request.UserRequestDto;
import com.hh.tech_project.model.dto.response.UserResponseDto;
import com.hh.tech_project.model.entity.User;
import com.hh.tech_project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final UserCacheService userCacheService;

    @Transactional
    public UserResponseDto create(UserRequestDto dto) {
        log.info("Creating new user with email={}...", dto.getEmail());

        User user = UserConverter.toEntity(dto);
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());

        return UserConverter.toDto(userRepository.save(user));
    }

    @Cacheable(value = "users", key = "#id")
    public UserResponseDto getById(Long id) {
        log.debug("Fetching user with id={}", id);

        return UserConverter.toDto(findUser(id));
    }

    @Transactional
    public UserResponseDto update(Long id, UserRequestDto dto) {
        log.info("Updating user with id={}...", id);

        User user = findUser(id);
        UserConverter.updateEntity(user, dto);
        user.setUpdatedAt(LocalDateTime.now());

        return userCacheService.putUser(userRepository.save(user));
    }

    @Transactional
    @CacheEvict(value = "users", key = "#id")
    public void delete(Long id) {
        log.warn("Deleting user with id={}...", id);

        User user = findUser(id);

        userRepository.delete(user);
    }

    private User findUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "ID", id.toString()));
    }
}
