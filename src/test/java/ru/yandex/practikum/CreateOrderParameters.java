package ru.yandex.practikum;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.practikum.dataTests.OrderData;
import ru.yandex.practikum.steps.OrderSteps;

import static org.apache.http.HttpStatus.SC_CREATED;
import static org.hamcrest.Matchers.notNullValue;

@RunWith(Parameterized.class)
public class CreateOrderParameters {
    private static String firstName;
    private static String lastName;
    private static String address;
    private static String metroStation;
    private static String phone;
    private static int rentTime;
    private static String deliveryDate;
    private static String comment;
    private static String color;

    private OrderData orderData;

    @Before
    public void setUp() {
        orderData = new OrderData(firstName,lastName, address,  metroStation,  phone,  rentTime,  deliveryDate,  comment, color);
    }

    public CreateOrderParameters(String firstName, String lastName, String address, String metroStation, String phone,
                                 Integer rentTime, String deliveryDate, String comment, String color) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.metroStation = metroStation;
        this.phone = phone;
        this.rentTime = rentTime;
        this.deliveryDate = deliveryDate;
        this.comment = comment;
        this.color = color;
    }

    //введите тестовые данные для создания заказа
    @Parameterized.Parameters
    public static Object[][] getOrderData(){
        return new Object[][]{
                {"Александр", "Сидоров", "г.Москва", "Черкизовская",
                        "+7 800 355 35 35", 4, "2022-10-30", "Saske, come back to Konoha", "BLACK"},
                {"Вася", "Петров", "г.Москва, ул.Какая-нибудь", "Алма-Атинская",
                        "+7 888 888 88 88", 4, "2022-11-10", "Saske, come back to Konoha", "GREY"},
                {"Вася", "Петров", "г.Москва, ул.Какая-нибудь", "Алма-Атинская",
                        "+7 888 888 88 88", 4, "2022-11-10", "Saske, come back to Konoha", ""},
        };
    }

    @Test
    @DisplayName("Тест на создание заказа по параметрам")
    public void checkCreateOrderParameters(){
        OrderSteps orderSteps = new OrderSteps();
        orderSteps.createWithParameters(getOrderData())
                .assertThat()
                .statusCode(SC_CREATED)
                .body("track", notNullValue());
    }
}
