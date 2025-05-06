package com.hh.tech_project.model.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Schema(description = "Response DTO for user")
public class UserResponseDto {

    @Schema(description = "Unique user ID", example = "1")
    private Long id;

    @Schema(description = "First name of the user", example = "Alice")
    private String firstName;

    @Schema(description = "Last name of the user", example = "Smith")
    private String lastName;

    @Schema(description = "Email address", example = "alice.smith@example.com")
    private String email;

    @Schema(description = "Account creation timestamp")
    private LocalDateTime createdAt;

    @Schema(description = "Last account update timestamp")
    private LocalDateTime updatedAt;
}