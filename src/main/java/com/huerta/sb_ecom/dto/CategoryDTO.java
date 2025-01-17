package com.huerta.sb_ecom.dto;

import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Schema(name = "CategoryDTO", description = "Category Data Transfer Object")
@AllArgsConstructor
public class CategoryDTO {

    private UUID categoryId;
    private String categoryName;
}
