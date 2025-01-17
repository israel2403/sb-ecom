package com.huerta.sb_ecom.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.huerta.sb_ecom.controller.CategoryController;
import com.huerta.sb_ecom.dto.CategoryDTO;
import com.huerta.sb_ecom.request.CategoryRequest;

@Service
public class CategoryService {

    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

    private List<CategoryDTO> categories = new ArrayList<>();

    public CategoryDTO create(final CategoryRequest categoryRequest) {
        logger.info("CategoryService.create - Start creating a new category");
        CategoryDTO categoryDTO = new CategoryDTO(UUID.randomUUID(), categoryRequest.getCategoryName());
        this.categories.add(categoryDTO);
        logger.info("CategoryService.create - Category created successfully with ID: {}", categoryDTO.getCategoryId());
        return categoryDTO;
    }

    public List<CategoryDTO> getAll() {
        logger.info("CategoryService.getAll - Start retrieving all categories");
        List<CategoryDTO> categories = this.categories;
        logger.info("CategoryService.getAll - {} categories retrieved", categories.size());
        return categories;
    }

}
