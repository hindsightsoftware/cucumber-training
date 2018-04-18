package stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.BookingPageHelper;
import org.junit.Assert;
import pageobjects.BookingPage;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;

public class CreateScenarioStepDefs {

    private World world;
    private BookingPageHelper bookingPageHelper;
    private BookingPage bookingPage;
    private List<String> bookingDetails;

    public CreateScenarioStepDefs(World world) {
        this.world = world;
    }

    @Given("^a user wants to make a booking with the following details$")
    public void a_user_wants_to_make_a_booking_with_the_following_details(List<String> bookingDetails) throws Exception {
        world.driver.navigate().to(world.URL);
        this.bookingDetails = bookingDetails;
    }

    @When("^the booking is submitted by the user$")
    public void the_booking_is_submitted_by_the_user() throws Exception {
        bookingPageHelper = new BookingPageHelper(world.driver);
        bookingPageHelper.createBooking(bookingDetails);
    }

    @Then("^the booking is successfully stored$")
    public void the_booking_is_successfully_stored() throws Exception {
        bookingPage = new BookingPage(world.driver);

        bookingPageHelper.waitForRowCount(2);
    }

    @Then("^shown to the user as stored$")
    public void shown_to_the_user_as_stored() throws Exception {
        int lastInstance = bookingPage.getRows().size() - 1;
        String rowText = bookingPage.getRows().get(lastInstance).getText();

        Assert.assertThat(rowText, containsString(bookingDetails.get(0)));
        Assert.assertThat(rowText, containsString(bookingDetails.get(1)));
        Assert.assertThat(rowText, containsString(bookingDetails.get(2)));
        Assert.assertThat(rowText, containsString(bookingDetails.get(3)));
        Assert.assertThat(rowText, containsString(bookingDetails.get(4)));
        Assert.assertThat(rowText, containsString(bookingDetails.get(5)));
        Assert.assertThat(rowText, containsString(bookingDetails.get(6)));
    }

}
