package com.huerta.sb_ecom.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "CategoryRequest", description = "Category Request")
public class CategoryRequest {
    private String categoryName;
}
