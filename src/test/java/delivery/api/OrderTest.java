package delivery.api;

import delivery.dto.OrderDto;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import delivery.utils.ApiClient;

public class OrderTest extends BaseSetupApi {

    @Test
    void getOrderInformationAndCheckResponse() {

        Response response = ApiClient.getOrders(getAuthenticatedRequestSpecification() );

        Assertions.assertAll("Test description",
                () -> Assertions.assertEquals(HttpStatus.SC_OK, response.getStatusCode(), "Status code is OK")
        );
    }

    @RepeatedTest(5)
    void createOrderAndCheckResponse() {

        Response responseOrderCreation = ApiClient.createOrder(getAuthenticatedRequestSpecification(), OrderDto.createRandomOrder());

        Assertions.assertAll("Test description",
                () -> Assertions.assertEquals(HttpStatus.SC_OK, responseOrderCreation.getStatusCode(), "Status code is OK"),
                () -> Assertions.assertNotNull(responseOrderCreation.getBody().path("id")),
                () -> Assertions.assertNull(responseOrderCreation.getBody().path("courierId"))
        );
    }
    @Test
    void deleteOrderByIdAndCheckResponse() {
        Response responseOrderCreation = ApiClient.createOrder(getAuthenticatedRequestSpecification(), OrderDto.createRandomOrder());
        int orderId = responseOrderCreation.getBody().path("id");
        Response responseOrderDeletion = ApiClient.deleteOrderById(getAuthenticatedRequestSpecification(), orderId);

        Assertions.assertAll("Test description",
                () -> Assertions.assertEquals(HttpStatus.SC_OK, responseOrderDeletion.getStatusCode(), "Status code is OK")
        );
    }
}
