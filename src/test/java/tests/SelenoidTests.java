package tests;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class SelenoidTests {

    /*
     Что мы проверяем
    1. Сделать запрос - make response - https://selenoid.autotests.cloud/status
    2. Получить ответ - get response:
    {"total":20,"used":0,"queued":0,"pending":0,"browsers":{"chrome":{"100.0":{},"99.0":{}},"firefox":{"97.0":{},"98.0":{}},"opera":{"84.0":{},"85.0":{}}}}
    3. Проверить - check total is 20
    */

@Test
    void checkTotal() {
        given()
                .log().all() //вывод всех параметров запроса
            .when()
            .get("https://selenoid.autotests.cloud/status")
            .then()
                .log().status()
                .log().body()// вывод body котрый отадет сервер
                .body("browsers.chrome", hasKey("100.0"))
                .body("total", is(20));

}

    /*@Test
    void checkWithoutGetTotal() {
      get("https://selenoid.autotests.cloud/status")
                .then()
                .body("total", is(20));

    }*/

}
