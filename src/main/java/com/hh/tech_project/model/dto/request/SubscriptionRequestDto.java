package com.hh.tech_project.model.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Request DTO for adding a subscription")
public class SubscriptionRequestDto {

    @Schema(description = "Name of the digital service", example = "Netflix")
    private String serviceName;
}
