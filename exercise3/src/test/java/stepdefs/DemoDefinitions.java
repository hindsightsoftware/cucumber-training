package stepdefs;

import api.BookingApi;
import com.jayway.restassured.response.Response;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import payloads.Booking;
import payloads.CreatedBooking;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.hamcrest.CoreMatchers.is;

public class DemoDefinitions {

    private SimpleDateFormat dateParser = new SimpleDateFormat("yyyy-MM-dd");
    private Response createdResponse;
    private Response queriedResponse;

    @Given("^Hotel Booking has existing bookings$")
    public void createBookings() throws Exception {
        Date checkin = dateParser.parse("2018-02-01");
        Date checkout = dateParser.parse("2018-02-02");

        Booking booking = new Booking.BookingBuilder()
                .setFirstname("Mark")
                .setLastname("Winteringham")
                .setTotalprice(123)
                .setDepositpaid(true)
                .setCheckin(checkin)
                .setCheckout(checkout)
                .setAdditionalneeds("Breakfast")
                .build();

        createdResponse = BookingApi.postBooking(booking);
    }

    @When("^a specific booking is requested by the user$")
    public void requestBooking() throws Exception {
        int id = createdResponse.as(CreatedBooking.class).getBookingid();

        queriedResponse = BookingApi.getBooking(id);
    }

    @Then("^the booking is shown$")
    public void viewAndAssertBookingResponse() throws Exception {
        String responseBooking = queriedResponse.body().prettyPrint();
        String expectedResponse = "{\n" +
                "    \"firstname\": \"Mark\",\n" +
                "    \"lastname\": \"Winteringham\",\n" +
                "    \"totalprice\": 123,\n" +
                "    \"depositpaid\": true,\n" +
                "    \"additionalneeds\": \"Breakfast\",\n" +
                "    \"bookingdates\": {\n" +
                "        \"checkin\": \"2018-02-01\",\n" +
                "        \"checkout\": \"2018-02-02\"\n" +
                "    }\n" +
                "}";

        Assert.assertThat(expectedResponse, is(responseBooking));
    }

}
