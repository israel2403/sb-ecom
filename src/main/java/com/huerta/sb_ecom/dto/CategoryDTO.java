package com.huerta.sb_ecom.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Schema(name = "CategoryDTO", description = "Category Data Transfer Object")
@AllArgsConstructor
public class CategoryDTO {

  @Schema(description = "Category ID", example = "123e4567-e89b-12d3-a456-426614174000")
  private UUID categoryId;

  @Schema(description = "Category name", example = "Electronics")
  private String categoryName;
}
