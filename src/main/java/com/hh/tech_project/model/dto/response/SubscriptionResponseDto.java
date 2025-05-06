package com.hh.tech_project.model.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Response DTO for subscription")
public class SubscriptionResponseDto {

    @Schema(description = "Unique ID of the subscription", example = "42")
    private Long id;

    @Schema(description = "Name of the subscribed service", example = "YouTube Premium")
    private String serviceName;
}