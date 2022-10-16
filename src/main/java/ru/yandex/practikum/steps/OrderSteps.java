package ru.yandex.practikum.steps;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import ru.yandex.practikum.dataTests.EndPoints;
import static io.restassured.RestAssured.given;

public class OrderSteps extends RestClient {
    @Step("Создание заказа по параметрам")
    //create order
    public ValidatableResponse createWithParameters(Object[][] orderData) {
        return given()
                .spec(getDefaultRequestSpec())
                .body(orderData)
                .post(EndPoints.ORDERS)
                .then();
    }
    @Step("Получение списка заказа")
    public ValidatableResponse getListOrder(){
        return given()
                .spec(getDefaultRequestSpec())
                .get(EndPoints.ORDERS)
                .then();
    }
}
