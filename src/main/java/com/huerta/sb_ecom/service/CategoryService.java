package com.huerta.sb_ecom.service;

import com.huerta.sb_ecom.controller.CategoryController;
import com.huerta.sb_ecom.dto.CategoryDTO;
import com.huerta.sb_ecom.exceptions.CategoryNotFoundByIdException;
import com.huerta.sb_ecom.request.CategoryRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

  private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

  private List<CategoryDTO> categories = new ArrayList<>();

  public CategoryDTO create(final CategoryRequest categoryRequest) {
    logger.info("CategoryService.create - Start creating a new category");
    CategoryDTO categoryDTO = new CategoryDTO(UUID.randomUUID(), categoryRequest.getCategoryName());
    this.categories.add(categoryDTO);
    logger.info(
        "CategoryService.create - Category created successfully with ID: {}",
        categoryDTO.getCategoryId());
    return categoryDTO;
  }

  public List<CategoryDTO> getAll() {
    logger.info("CategoryService.getAll - Start retrieving all categories");
    List<CategoryDTO> categories = this.categories;
    logger.info("CategoryService.getAll - {} categories retrieved", categories.size());
    return categories;
  }

  public void deleteById(UUID categoryId) {
    logger.info("CategoryService.deleteById - Start deleting category with ID: {}", categoryId);
    boolean deleted =
        this.categories.removeIf(category -> category.getCategoryId().equals(categoryId));
    if (!deleted) {
      throw new CategoryNotFoundByIdException(
          "Category with ID: " + categoryId.toString() + " not found");
    }
    logger.info(
        "CategoryService.deleteById - Category deleted successfully with ID: {}", categoryId);
  }

  public CategoryDTO updateById(final UUID categoryId, final CategoryRequest categoryRequest) {
    logger.info("CategoryService.updateById - Start updating category with ID: {}", categoryId);
    CategoryDTO category =
        this.categories.stream()
            .filter(c -> c.getCategoryId().equals(categoryId))
            .findFirst()
            .orElseThrow(
                () ->
                    new CategoryNotFoundByIdException(
                        "Category with ID: " + categoryId.toString() + " not found"));
    category.setCategoryName(categoryRequest.getCategoryName());
    logger.info(
        "CategoryService.updateById - Category updated successfully with ID: {}", categoryId);
    return category;
  }
}
