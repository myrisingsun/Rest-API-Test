package tests;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class ReqResTests {

    @Test

    void getListUsersCheck(){
        given()
                .log().all() //вывод всех параметров запроса
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()



        ;


    }


}
