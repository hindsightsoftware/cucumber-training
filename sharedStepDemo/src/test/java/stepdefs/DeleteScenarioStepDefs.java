package stepdefs;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driverfactory.DriverFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageobjects.BookingPage;

import static org.hamcrest.CoreMatchers.is;

public class DeleteScenarioStepDefs {

    private World world;

    public DeleteScenarioStepDefs(World world) {
        this.world = world;
    }

    @When("^a specific booking is deleted by the user$")
    public void a_specific_booking_is_deleted_by_the_user() throws Exception {
        world.bookingPage.clickDelete();
    }

    @Then("^the booking is removed$")
    public void the_booking_is_removed() throws Exception {
        world.bookingPage.waitForDelete();

        int rowCount = world.bookingPage.rowCount();

        Assert.assertThat(rowCount, is(2));
    }

}
