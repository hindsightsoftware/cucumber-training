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

public class UiStepDefs {

    private WebDriver driver;
    private BookingPage bookingPage;

    @Before
    public void setupDriver(){
        DriverFactory driverFactory = new DriverFactory();
        driver = driverFactory.generateDriver();
    }

    @After
    public void destroyDriver(){
        driver.close();
    }

    @Given("^Hotel Booking has existing bookings$")
    public void hotel_Booking_has_existing_bookings() throws Exception {
        driver.navigate().to("http://localhost:8080/");
        bookingPage = new BookingPage(driver);
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
