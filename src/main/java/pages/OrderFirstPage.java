package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class OrderFirstPage {
    private final WebDriver driver;
    private final By firstNameField = By.xpath(".//input[@placeholder='* Имя']");
    private final By lastNameField = By.xpath(".//input[@placeholder='* Фамилия']");
    private final By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By stationButton = By.className("select-search");
    private final By phoneField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By nextButton = By.className("Button_Middle__1CSJM");
    private final By orderForm = By.className("Order_Content__bmtHS");


    public OrderFirstPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForForm() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(orderForm));
    }

    public void setFirstNameField(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void setLastNameField(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void setAddressField(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    public void clickStationButton(int ind) {
        driver.findElement(stationButton).click();
        List<WebElement> variants = driver.findElements(By.className("select-search__row"));

        WebElement variant = variants.get(ind);
        scrollIntoView(variant);
        variant.click();

    }

    private void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void setPhoneField(String number) {
        driver.findElement(phoneField).sendKeys(number);
    }

    public void clickNextButton() {

        scrollIntoView(driver.findElement(nextButton));


        driver.findElement(nextButton).click();
    }

    public void fill(String firstName, String lastName, String address, int stationIndex, String number) {
        setFirstNameField(firstName);
        setLastNameField(lastName);
        setAddressField(address);
        clickStationButton(stationIndex);
        setPhoneField(number);
    }
}



