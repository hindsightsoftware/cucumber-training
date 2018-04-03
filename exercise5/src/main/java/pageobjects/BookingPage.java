package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BookingPage extends Page {

    @FindBy(how = How.CSS, using = ".glyphicon-remove")
    private WebElement btnDelete;

    @FindBy(how = How.CSS, using = ".row")
    private List<WebElement> divRows;

    private WebDriverWait wait;

    public BookingPage(WebDriver driver) {
        super(driver);

        wait = new WebDriverWait(driver, 10);
    }

    public void clickDelete(){
        btnDelete.click();
    }

    public int rowCount(){
        return divRows.size();
    }

    public void waitForDelete() {
        wait.until((ExpectedCondition<Boolean>) driver -> {
            int elementCount = driver.findElements(By.cssSelector(".glyphicon-remove")).size();
            return elementCount == 0;
        });
    }
}
