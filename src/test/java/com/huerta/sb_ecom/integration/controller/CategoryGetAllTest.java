package com.huerta.sb_ecom.integration.controller;

import com.intuit.karate.junit5.Karate;

class CategoryGetAllTest {

    @Karate.Test
    Karate testGetAllCategories() {
        return Karate.run("classpath:features/category-get-all.feature");
    }
}
