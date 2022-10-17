package ru.yandex.practikum.generator;
import io.qameta.allure.Step;
import ru.yandex.practikum.dataTests.CourierData;
import ru.yandex.practikum.dataTests.LoginRequest;
public class CourierDataGenerator {

    @Step("Ввод данных для создания курьера")
    public static CourierData getCourierRequestCreate(){
        CourierData courierData = new CourierData();
        courierData.setLogin("qwerqwrqwr1");
        courierData.setPassword("1234");
        courierData.setFirstName("adsgrsrtg");
        return courierData;
    }
    @Step("Ввод данных для проверки логина в системе")
    public static LoginRequest getCourierRequestLogin() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setLogin("qwerqwrqwr1");
        loginRequest.setPassword("1234");
        return loginRequest;
    }
    @Step("Ввод данных для проверки регистрации курьера с одинаковыми данными")
    public static CourierData getCourierRequestCreateLoginAgain(){
        CourierData courierData = new CourierData();
        courierData.setLogin("ahgr5h");
        courierData.setPassword("3453");
        courierData.setFirstName("dshgsb");
        return courierData;
    }

    @Step("Ввод данных для проверки регистрации курьера с одинаковыми данными")
    public static LoginRequest getCourierRequestLoginAgain() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setLogin("ahgr5h");
        loginRequest.setPassword("3453");
        return loginRequest;
    }
    @Step("Данные для проверки возможности регистрации без поля login")
    public static CourierData getCreateLoginCourierWithoutLoginField() {
        CourierData courierData = new CourierData();
        courierData.setPassword("3453");
        courierData.setFirstName("dshgsb");
        return courierData;
    }

    @Step("данные для проверки возможности регистрации без поля password")
    public static CourierData getCreateLoginCourierWithoutPasswordField() {
        CourierData courierData = new CourierData();
        courierData.setLogin("ahgr5h");
        courierData.setFirstName("dshgsb");
        return courierData;
    }
    @Step ("Данные для проверки возможности выполнить вход без поля login")
    public static LoginRequest getCourierRequestLoginWithoutLogin() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setPassword("1234");
        return loginRequest;
    }
    @Step("данные для проверки возможности выполнить вход без поля password")
    public static LoginRequest getCourierRequestLoginWithoutPassword() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setLogin("qwerqwrqwr1");
        loginRequest.setPassword("");
        return loginRequest;
    }
    @Step("данные для теста с невалидными данными")
    public static LoginRequest getCourierRequestLoginWithInvalidCredentials() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setLogin("qwerqwrqwrssrhtdtyhd");
        loginRequest.setPassword("20347856");
        return loginRequest;
    }
}
