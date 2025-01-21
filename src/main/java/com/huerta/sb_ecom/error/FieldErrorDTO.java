package com.huerta.sb_ecom.error;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class FieldErrorDTO {
  private String field;
  private String message;
}
