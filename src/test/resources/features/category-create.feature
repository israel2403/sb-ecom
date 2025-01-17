Feature: Create Category

    Scenario: Create a new category
        Given url 'http://localhost:8081/api/categories'
        And request { "categoryName": "New Category" }
        When method post
        Then status 200
        And match response.categoryId != null
        And match response.categoryName == 'New Category'