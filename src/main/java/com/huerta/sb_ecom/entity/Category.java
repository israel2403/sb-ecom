package com.huerta.sb_ecom.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "category")
@NoArgsConstructor
@Getter
@Setter
public class Category {

    @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id", columnDefinition = "UUID")
    private UUID categoryId;

    @Column(name = "category_name", nullable = false, unique = true)
    private String categoryName;
}
