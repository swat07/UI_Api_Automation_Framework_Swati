package com.example.api.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.*;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TodoApiTest {
    private String token;

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "http://localhost:5000/api";

        String loginPayload = "{ \"email\": \"test@example.com\", \"password\": \"password123\" }";

        Response response = given()
            .contentType("application/json")
            .body(loginPayload)
        .when()
            .post("/auth/login");

        token = response.jsonPath().getString("token");
    }

    @Test
    public void testCreateGetUpdateDeleteTodo() {
        // Create
        int id = given().header("Authorization", "Bearer " + token)
            .contentType("application/json")
            .body("{ \"title\": \"API Todo\" }")
        .when()
            .post("/todos")
        .then()
            .statusCode(201)
            .extract().path("id");

        // Get
        given().header("Authorization", "Bearer " + token)
        .when()
            .get("/todos")
        .then()
            .statusCode(200)
            .body("title", hasItem("API Todo"));

        // Update
        given().header("Authorization", "Bearer " + token)
            .contentType("application/json")
            .body("{ \"title\": \"Updated API Todo\" }")
        .when()
            .put("/todos/" + id)
        .then()
            .statusCode(200)
            .body("title", equalTo("Updated API Todo"));

        // Delete
        given().header("Authorization", "Bearer " + token)
        .when()
            .delete("/todos/" + id)
        .then()
            .statusCode(200);
    }
}