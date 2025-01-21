package com.huerta.sb_ecom.controller;

import com.huerta.sb_ecom.dto.CategoryDTO;
import com.huerta.sb_ecom.error.ErrorResponseDTO;
import com.huerta.sb_ecom.request.CategoryRequest;
import com.huerta.sb_ecom.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(
    name = "CRUD Rest API for Category",
    description = "Category API (create, read, update, delete)")
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

  @Operation(
      summary = "Create a category",
      description = "Create a category in the database",
      requestBody =
          @io.swagger.v3.oas.annotations.parameters.RequestBody(
              description = "CategoryRequest",
              required = true,
              content = @Content(schema = @Schema(implementation = CategoryRequest.class))))
  @ApiResponse(
      responseCode = "201",
      description = "Category successfully created",
      content = @Content(schema = @Schema(implementation = CategoryDTO.class)))
  @PostMapping
  public ResponseEntity<CategoryDTO> create(@RequestBody CategoryRequest categoryRequest) {
    logger.info("Entering CategoryController.create method");
    logger.info("Creating a category with name: {}", categoryRequest.getCategoryName());
    CategoryDTO categoryDTO = this.categoryService.create(categoryRequest);
    logger.info("Successfully created category with ID: {}", categoryDTO.getCategoryId());
    return ResponseEntity.ok().body(categoryDTO);
  }

  // Add openai documentation to genereate swagger documentation
  @Operation(
      summary = "Delete a category",
      description = "Delete a category from the database",
      parameters = {
        @Parameter(
            name = "categoryId",
            description = "Category ID",
            required = true,
            example = "123e4567-e89b-12d3-a456-426614174000",
            schema = @Schema(implementation = UUID.class))
      })
  @ApiResponses(
      value = {
        @ApiResponse(responseCode = "204", description = "Category successfully deleted"),
        @ApiResponse(
            responseCode = "404",
            description = "Category not found",
            content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class)))
      })
  @DeleteMapping("/{categoryId}")
  public ResponseEntity<Void> deleteById(@PathVariable final UUID categoryId) {
    logger.info("Entering CategoryController.deleteById method");
    logger.info("Deleting category with ID: {}", categoryId);
    this.categoryService.deleteById(categoryId);
    logger.info("Successfully deleted category with ID: {}", categoryId);
    return ResponseEntity.noContent().build();
  }

  @PutMapping("/{categoryId}")
  @Operation(
      summary = "Update a category",
      description = "Update a category in the database",
      parameters = {
        @Parameter(
            name = "categoryId",
            description = "Category ID",
            required = true,
            example = "123e4567-e89b-12d3-a456-426614174000",
            schema = @Schema(implementation = UUID.class))
      })
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "200",
            description = "Category successfully updated",
            content = @Content(schema = @Schema(implementation = CategoryDTO.class))),
        @ApiResponse(
            responseCode = "404",
            description = "Category not found",
            content = @Content(schema = @Schema(implementation = ErrorResponseDTO.class)))
      })
  public ResponseEntity<CategoryDTO> updateById(
      @PathVariable final UUID categoryId, @RequestBody CategoryRequest categoryRequest) {
    logger.info("Entering CategoryController.updateById method");
    logger.info("Updating category with ID: {}", categoryId);
    CategoryDTO categoryDTO = this.categoryService.updateById(categoryId, categoryRequest);
    logger.info("Successfully updated category with ID: {}", categoryId);
    return ResponseEntity.ok().body(categoryDTO);
  }
}
