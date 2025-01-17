package com.huerta.sb_ecom.integration.controller;

import com.intuit.karate.junit5.Karate;

class CategoryCreateTest {

    @Karate.Test
    Karate testCreateCategory() {
        return Karate.run("classpath:features/category-create.feature");
    }
}
