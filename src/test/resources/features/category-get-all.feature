Feature: Get All Categories

    Scenario: Get all categories
        Given url 'http://localhost:8081/api/categories'
        When method get
        Then status 200
        And match response == [{ "categoryId": "#notnull", "categoryName": "#string" }]