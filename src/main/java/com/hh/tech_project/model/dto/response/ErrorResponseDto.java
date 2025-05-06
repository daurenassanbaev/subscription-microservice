package com.hh.tech_project.model.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Schema(description = "Structure of error response")
public class ErrorResponseDto {

    @Schema(description = "API path where error occurred", example = "/api/users/1")
    private String apiPath;

    @Schema(description = "HTTP status code", example = "404")
    private HttpStatus errorCode;

    @Schema(description = "Error message", example = "User not found")
    private String errorMessage;

    @Schema(description = "Time of the error")
    private LocalDateTime errorTime;
}