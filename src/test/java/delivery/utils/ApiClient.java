package delivery.utils;

import com.google.gson.Gson;
import delivery.api.BaseSetupApi;
import delivery.api.OrderTest;
import delivery.dto.LoginDto;
import delivery.dto.OrderDto;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class ApiClient extends BaseSetupApi {
    public static Response getOrders(RequestSpecification spec){

        return given()
                .spec(spec)
                .log()
                .all()
                .get( "orders")
                .then()
                .log()
                .all()
                .extract()
                .response();
    }
    public static Response createOrder(RequestSpecification spec, OrderDto orderDto){

        return given()
                .spec(spec)
                .log()
                .all()
                .body(orderDto)
                .post( "orders")
                .then()
                .log()
                .all()
                .extract()
                .response();
    }
    public static Response deleteOrderById(RequestSpecification spec, int orderId){

        return given()
                .spec(spec)
                .log()
                .all()
                .delete( "orders/" + orderId)
                .then()
                .log()
                .all()
                .extract()
                .response();
    }

    public static String authorizeAndGetToken(String username, String password){

        LoginDto loginDto = new LoginDto(username, password);

        return given()
                .log()
                .all()
                .contentType(ContentType.JSON)
                .body( new Gson().toJson( loginDto) )
                .post("login/student" )
                .then()
                .log()
                .all()
                .extract()
                .response()
                .asString();
    }

}