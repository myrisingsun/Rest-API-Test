package tests;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.*;

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

    @Test
    void registerNewUserSucess() {
        String body = "{\"email\": \"eve.holt@reqres.in\", \"password\": \"pistol\" }";

        given()
                .body(body)
                .contentType(JSON)
                .when()
                .post("https://reqres.in/api/register")
                .then()
                .log().all()
                .statusCode(200)
                .body("id", is(4))
                .body("token", is("QpwL5tke4Pnpja7X4"));
    }
@Test
 void registerNewUserUnsucess(){

    String body = "{ \"email\": \"sydney@fife\" }";
            given()
                    .log().all()
                    .contentType(JSON)
                    .body(body)
                    .when()
                    .post("https://reqres.in/api/register")
                    .then()
                    .log().all()
                    .statusCode(400)
                    .body("error", is("Missing password"));
        }

        @Test

    void userDataUpdate(){
        String body = "{ \"name\": \"morpheus\", \"job\": \"zion resident\" }";
            given()
                    .log().all()
                    .contentType(JSON)
                    .body(body)
                    .when()
                    .put("https://reqres.in/api/users/2")
                    .then()
                    .log().all()
                    .statusCode(200)
                    .body("name", is("morpheus"))
                    .body("job", is("zion resident"));


            }



    }

