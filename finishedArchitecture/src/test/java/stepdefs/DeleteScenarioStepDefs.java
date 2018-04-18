package stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pageobjects.BookingPage;

import static org.hamcrest.CoreMatchers.is;

public class DeleteScenarioStepDefs {

    private World world;
    private BookingPage bookingPage;

    public DeleteScenarioStepDefs(World world) {
        this.world = world;
    }

    @Given("^Hotel Booking has existing bookings$")
    public void hotel_Booking_has_existing_bookings() throws Exception {
        world.driver.navigate().to(this.world.URL);
        bookingPage = new BookingPage(world.driver);
    }

    @When("^a specific booking is deleted by the user$")
    public void a_specific_booking_is_deleted_by_the_user() throws Exception {
        bookingPage.clickDelete();
    }

    @Then("^the booking is removed$")
    public void the_booking_is_removed() throws Exception {
        bookingPage.waitForDelete();

        int rowCount = bookingPage.rowCount();

        Assert.assertThat(rowCount, is(2));
    }

}
