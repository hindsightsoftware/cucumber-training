package api;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import payloads.Booking;

import static com.jayway.restassured.RestAssured.given;

public class BookingApi {

    final static String baseUrl = "http://localhost:8080";

    public static Response postBooking(Booking booking){
        return given()
            .body(booking)
            .contentType(ContentType.JSON)
            .when()
            .post(baseUrl + "/booking");
    }

    public static Response getBooking(int id){
        return given()
                .accept(ContentType.JSON)
                .get(baseUrl + "/booking/" + id);
    }
}
