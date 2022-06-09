package tests;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
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

}
