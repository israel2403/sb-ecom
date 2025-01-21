package com.huerta.sb_ecom.error;

import com.huerta.sb_ecom.exceptions.CategoryNotFoundByIdException;
import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalHandlerException {
  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorResponseDTO> handleGlobalException(
      final Exception ex, WebRequest webRequest) {
    final ErrorResponseDTO errorResponseDTO =
        ErrorResponseDTO.builder()
            .apiPath(webRequest.getDescription(false))
            .errorCode(HttpStatus.INTERNAL_SERVER_ERROR)
            .errorMessage(ex.getMessage())
            .errorTime(LocalDateTime.now())
            .build();
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponseDTO);
  }

  @ExceptionHandler(CategoryNotFoundByIdException.class)
  public ResponseEntity<ErrorResponseDTO> handleResourceNotFoundException(
      final CategoryNotFoundByIdException ex, WebRequest webRequest) {
    final ErrorResponseDTO errorResponseDTO =
        ErrorResponseDTO.builder()
            .apiPath(webRequest.getDescription(false))
            .errorCode(HttpStatus.NOT_FOUND)
            .errorMessage(ex.getMessage())
            .errorTime(LocalDateTime.now())
            .build();
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponseDTO);
  }
}
