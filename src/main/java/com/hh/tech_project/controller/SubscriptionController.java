package com.hh.tech_project.controller;

import com.hh.tech_project.service.SubscriptionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subscriptions")
@RequiredArgsConstructor
@Tag(name = "Subscription Controller", description = "Public subscriptions operations")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    @GetMapping("/top")
    @Operation(summary = "Get top 3 most popular subscriptions")
    public ResponseEntity<List<String>> getTopSubscriptions() {
        return ResponseEntity.ok(subscriptionService.getTop3Subscriptions());
    }
}
