package ru.yandex.practikum;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.practikum.steps.CourierSteps;
import static org.apache.http.HttpStatus.*;
import static org.hamcrest.Matchers.*;
import static ru.yandex.practikum.generator.CourierDataGenerator.*;

public class CreateCourierTests {
    private CourierSteps courierSteps;
    //переменная для получения ID, используется для удаления данных
    private Integer id;

    @Before
    public void setUp() {
        courierSteps = new CourierSteps();
    }

    @After
    @DisplayName("Удаляем логин курьера после каждого теста если получен ID")
    //удаляем данные после каждого теста
    public void tearDown(){
        if(id != null){
            courierSteps.delete(id).assertThat().statusCode(SC_OK).body("ok", equalTo(true));
        }
    }

    @Test
    @DisplayName("Регистрация логина курьера в системе с валидными значениями")
    public void checkCreateLoginCourierValidCredentials() {
        //создается логин
        courierSteps.create(getCourierRequestCreate())
                .assertThat()
                .statusCode(SC_CREATED)
                .body("ok", equalTo(true));
        //проверка создан ли логин, можно ли залогиниться
        id = courierSteps.login(getCourierRequestLogin())
                .assertThat()
                .statusCode(SC_OK)
                .body("id", notNullValue())
                .extract()
                .path("id");
    }

    @Test
    @DisplayName("Регистрация логина с уже используемыми данными")
    public void checkCannotCreateExistingCourier() {
        //создается логин
        courierSteps.create(getCourierRequestCreateLoginAgain())
                .assertThat()
                .statusCode(SC_CREATED)
                .body("ok", equalTo(true));
        //выполнить вход для получения id
        id = courierSteps.login(getCourierRequestLoginAgain())
                .assertThat()
                .statusCode(SC_OK)
                .body("id", notNullValue())
                .extract()
                .path("id");
        //проверка создать логин с теми же данными
        courierSteps.create(getCourierRequestCreateLoginAgain())
                .assertThat()
                .statusCode(SC_CONFLICT)
                .body("message", equalTo("Этот логин уже используется"));
    }

    @Test
    @DisplayName("Тест на регистрацию логина без поля login")
    public void checkCreateLoginCourierWithoutLoginField(){
        courierSteps.create(getCreateLoginCourierWithoutLoginField())
                .assertThat()
                .statusCode(SC_BAD_REQUEST)
                .body("message", equalTo("Недостаточно данных для создания учетной записи"));
    }

    @Test
    @DisplayName("Тест на регистрацию логина без поля password")
    public void checkCreateLoginCourierWithoutPasswordField(){
        courierSteps.create(getCreateLoginCourierWithoutPasswordField())
                .assertThat()
                .statusCode(SC_BAD_REQUEST)
                .body("message", equalTo("Недостаточно данных для создания учетной записи"));
    }
}