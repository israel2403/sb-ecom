package com.huerta.sb_ecom.error;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@Builder
@Schema(description = "Error response details")
public class ErrorResponseDTO {

  @Schema(description = "API path where the error occurred", example = "/api/categories")
  private String apiPath;

  @Schema(description = "HTTP status code of the error", example = "404")
  private HttpStatus errorCode;

  @Schema(description = "Error message", example = "Category not found")
  private String errorMessage;

  @Schema(description = "Time when the error occurred", example = "2025-01-17T10:12:11.790")
  private LocalDateTime errorTime;

  @Schema(description = "List of field errors")
  private List<FieldErrorDTO> errors;
}
