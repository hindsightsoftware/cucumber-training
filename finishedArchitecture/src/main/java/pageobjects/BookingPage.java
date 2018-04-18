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

    @FindBy(how = How.ID, using = "firstname")
    private WebElement txtFirstname;

    @FindBy(how = How.ID, using = "lastname")
    private WebElement txtLastname;

    @FindBy(how = How.ID, using = "totalprice")
    private WebElement txtTotalprice;

    @FindBy(how = How.ID, using = "depositpaid")
    private WebElement txtDepositpaid;

    @FindBy(how = How.ID, using = "additionalneeds")
    private WebElement txtAdditionalNeeds;

    @FindBy(how = How.ID, using = "checkin")
    private WebElement txtCheckin;

    @FindBy(how = How.ID, using = "checkout")
    private WebElement txtCheckout;

    @FindBy(how = How.CSS, using = ".addButton")
    private WebElement btnSubmit;

    @FindBy(how = How.CSS, using = ".glyphicon-remove")
    private WebElement btnDelete;

    @FindBy(how = How.CSS, using = "#bookings .row")
    private List<WebElement> listRows;

    private WebDriverWait wait;

    public BookingPage(WebDriver driver) {
        super(driver);

        wait = new WebDriverWait(driver, 10);
    }

    public void clickDelete(){
        btnDelete.click();
    }

    public int rowCount(){
        return listRows.size();
    }

    public void waitForDelete() {
        wait.until((ExpectedCondition<Boolean>) driver -> {
            int elementCount = driver.findElements(By.cssSelector(".glyphicon-remove")).size();
            return elementCount == 0;
        });
    }

    public void setFirstname(String s) {
        txtFirstname.sendKeys(s);
    }

    public void setLastname(String s) {
        txtLastname.sendKeys(s);
    }

    public void setPrice(String s) {
        txtTotalprice.sendKeys(s);
    }

    public void setDeposit(String s) {
        txtDepositpaid.sendKeys(s);
    }

    public void setAdditionalNeeds(String s){
        txtAdditionalNeeds.sendKeys(s);
    }

    public void setCheckin(String s) {
        txtCheckin.sendKeys(s);
    }

    public void setCheckout(String s) {
        txtCheckout.sendKeys(s);
    }

    public void clickSubmit(){
        btnSubmit.click();
    }

    public List<WebElement> getRows() {
        return listRows;
    }

}
