package com.huerta.sb_ecom.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huerta.sb_ecom.dto.CategoryDTO;
import com.huerta.sb_ecom.request.CategoryRequest;
import com.huerta.sb_ecom.service.CategoryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@Tag(name = "CRUD Rest API for Category", description = "Category API (create, read, update, delete)")
@RestController
@AllArgsConstructor
@RequestMapping("/api/categories")
public class CategoryController {

    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

    private final CategoryService categoryService;

    @Operation(summary = "Get all categories", description = "Get all categories from the database")
    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAll() {
        logger.info("Entering CategoryController.getAll method");
        List<CategoryDTO> categories = this.categoryService.getAll();
        logger.info("Successfully retrieved {} categories", categories.size());
        return ResponseEntity.ok().body(categories);
    }

    @Operation(summary = "Create a category", description = "Create a category in the database", requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "CategoryRequest", required = true, content = @Content(schema = @Schema(implementation = CategoryRequest.class))))
    @PostMapping
    public ResponseEntity<CategoryDTO> create(@RequestBody CategoryRequest categoryRequest) {
        logger.info("Entering CategoryController.create method");
        logger.info("Creating a category with name: {}", categoryRequest.getCategoryName());
        CategoryDTO categoryDTO = this.categoryService.create(categoryRequest);
        logger.info("Successfully created category with ID: {}", categoryDTO.getCategoryId());
        return ResponseEntity.ok().body(categoryDTO);
    }

}
