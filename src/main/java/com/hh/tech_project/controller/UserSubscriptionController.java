package com.hh.tech_project.controller;

import com.hh.tech_project.model.dto.request.SubscriptionRequestDto;
import com.hh.tech_project.model.dto.response.SubscriptionResponseDto;
import com.hh.tech_project.service.SubscriptionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/{userId}/subscriptions")
@RequiredArgsConstructor
@Tag(name = "User Subscription Controller", description = "Manage user subscriptions")
public class UserSubscriptionController {

    private final SubscriptionService subscriptionService;

    @PostMapping
    @Operation(summary = "Add a subscription for a user")
    public ResponseEntity<SubscriptionResponseDto> addSubscription(
            @PathVariable Long userId,
            @RequestBody SubscriptionRequestDto request) {
        return ResponseEntity.ok(subscriptionService.addSubscription(userId, request));
    }

    @GetMapping
    @Operation(summary = "Get all subscriptions of a user")
    public ResponseEntity<List<SubscriptionResponseDto>> getUserSubscriptions(
            @PathVariable Long userId) {
        return ResponseEntity.ok(subscriptionService.getUserSubscriptions(userId));
    }

    @DeleteMapping("/{subscriptionId}")
    @Operation(summary = "Delete a specific subscription of a user")
    public ResponseEntity<Void> deleteSubscription(
            @PathVariable Long userId,
            @PathVariable Long subscriptionId) {
        subscriptionService.deleteSubscription(userId, subscriptionId);
        return ResponseEntity.noContent().build();
    }
}
