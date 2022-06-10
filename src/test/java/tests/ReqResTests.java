package tests;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;

public class ReqResTests {

    @Test

    void getListUsersCheck(){

        given()
                .log().all() //вывод всех параметров запроса
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .body("page", is(2))
                .body("per_page", is(6))
                .body("total", is(12))
                .body("total_pages", is(2));
    }

    @Test

    void postNewUser (){
        String newuser = "{\"name\": \"morpheus\",     \"job\": \"leader\" }";

        given()
                .body(newuser)
                .contentType(JSON)
                .log().all() //вывод всех параметров запроса
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .log().all()
                .statusCode(201)
                .body("name",is("morpheus"))
                .body("job", is("leader"));
    }



    }
