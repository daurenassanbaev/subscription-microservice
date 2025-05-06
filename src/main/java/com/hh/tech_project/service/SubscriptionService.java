package com.hh.tech_project.service;

import com.hh.tech_project.exception.ResourceNotFoundException;
import com.hh.tech_project.model.converter.SubscriptionConverter;
import com.hh.tech_project.model.dto.request.SubscriptionRequestDto;
import com.hh.tech_project.model.dto.response.SubscriptionResponseDto;
import com.hh.tech_project.model.entity.Subscription;
import com.hh.tech_project.model.entity.User;
import com.hh.tech_project.repository.SubscriptionRepository;
import com.hh.tech_project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final UserRepository userRepository;

    @Transactional
    @Caching(evict = {
            @CacheEvict(value = "subscriptions", key = "#userId")
    })
    public SubscriptionResponseDto addSubscription(Long userId, SubscriptionRequestDto dto) {
        log.info("Adding subscription for userId={} to service={}", userId, dto.getServiceName());

        User user = findUser(userId);

        Subscription subscription = SubscriptionConverter.toEntity(dto, user);
        subscriptionRepository.save(subscription);

        return SubscriptionConverter.toDto(subscription);
    }

    @Cacheable(value = "subscriptions", key = "#userId")
    public List<SubscriptionResponseDto> getUserSubscriptions(Long userId) {
        log.debug("Fetching subscriptions from DB for userId={}", userId);

        return subscriptionRepository.findByUserId(userId).stream()
                .map(SubscriptionConverter::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    @Caching(evict = {
            @CacheEvict(value = "subscriptions", key = "#userId")
    })
    public void deleteSubscription(Long userId, Long subscriptionId) {
        log.warn("Deleting subscription with id={} for userId={}", subscriptionId, userId);

        Subscription subscription = subscriptionRepository.findByIdAndUserId(subscriptionId, userId)
                .orElseThrow(() -> new ResourceNotFoundException("Subscription", "ID", subscriptionId.toString()));

        subscriptionRepository.delete(subscription);
    }

    @Cacheable(value = "topSubscriptions")
    public List<String> getTop3Subscriptions() {
        log.debug("Fetching top 3 popular subscriptions");

        return subscriptionRepository.findTop3PopularServices();
    }

    private User findUser(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "ID", userId.toString()));
    }
}
