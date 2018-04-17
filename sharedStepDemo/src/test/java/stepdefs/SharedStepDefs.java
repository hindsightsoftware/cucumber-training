package stepdefs;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import driverfactory.DriverFactory;
import pageobjects.BookingPage;

public class SharedStepDefs {

    private World world;

    public SharedStepDefs(World world) {
        this.world = world;
    }

    @Before
    public void setupDriver(){
        DriverFactory driverFactory = new DriverFactory();
        world.driver = driverFactory.generateDriver();
    }

    @After
    public void destroyDriver(){
        world.driver.close();
    }

    @Given("^Hotel Booking has existing bookings$")
    public void hotel_Booking_has_existing_bookings() throws Exception {
        world.driver.navigate().to("http://localhost:8080/");
        world.bookingPage = new BookingPage(world.driver);
    }

}
