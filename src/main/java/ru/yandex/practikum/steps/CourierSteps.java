package ru.yandex.practikum.steps;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import ru.yandex.practikum.dataTests.CourierData;
import ru.yandex.practikum.dataTests.EndPoints;
import ru.yandex.practikum.dataTests.LoginRequest;
import static io.restassured.RestAssured.given;
public class CourierSteps extends RestClient {

    @Step("Создаем логин для курьера")
    //create
    public ValidatableResponse create(CourierData courierData) {
        return given()
                .spec(getDefaultRequestSpec())
                .body(courierData)
                .post(EndPoints.COURIER)
                .then();
    }
    @Step("Выполняем вход")
    //login
    public ValidatableResponse login(LoginRequest loginRequest) {
        return given()
                .spec(getDefaultRequestSpec())
                .body(loginRequest)
                .post(EndPoints.LOGIN)
                .then();
    }
    @Step("Удаляем логин курьера")
    //delete
    public ValidatableResponse delete(int id) {
        return given()
                .spec(getDefaultRequestSpec())
                .delete(EndPoints.DELETE+id)
                .then();
    }
}
