package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.BookingPage;

import java.util.List;

public class BookingPageHelper {

    private WebDriver driver;

    private WebDriverWait wait;

    public BookingPageHelper(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public void createBooking(List<String> bookingDetails){
        BookingPage bookingPage = new BookingPage(this.driver);
        bookingPage.setFirstname(bookingDetails.get(0));
        bookingPage.setLastname(bookingDetails.get(1));
        bookingPage.setPrice(bookingDetails.get(2));
        bookingPage.setDeposit(bookingDetails.get(3));
        bookingPage.setCheckin(bookingDetails.get(4));
        bookingPage.setCheckout(bookingDetails.get(5));
        bookingPage.setAdditionalNeeds(bookingDetails.get(6));
        bookingPage.clickSubmit();
    }

    public void waitForRowCount(int count) {
        wait.until((ExpectedCondition<Boolean>) driver -> {
            int elementCount = driver.findElements(By.cssSelector(".glyphicon-edit")).size();
            return elementCount == count;
        });
    }
}
