package ru.yandex.practikum;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.practikum.steps.OrderSteps;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.notNullValue;
public class GetOrderListTest {

    private OrderSteps orderSteps;

    @Before
    public void setUp() {
        orderSteps = new OrderSteps();
    }

    @Test
    @DisplayName("Тест на получение списка заказа")
    public void checkGetListOrder(){
        orderSteps.getListOrder()
                .assertThat()
                .statusCode(SC_OK)
                .body("orders", notNullValue());
        System.out.println();
    }
}
