package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderConfirmationPage {
    private final WebDriver driver;

    private final By yesButton = By.xpath(".//button[contains(@class,'Button_Button__ra12g Button_Middle__1CSJM') and text()='Да']");
    private final By nopeButton = By.xpath(".//button[contains(@class,'Button_Button__ra12g Button_Middle__1CSJM') and text()='Нет']");
    private final By statusButton = By.xpath(".//button[contains(@class,'Button_Button__ra12g Button_Middle__1CSJM') and text()='Посмотреть статус']");
    private final By orderText = By.className("Order_Text__2broi");

    public OrderConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }


    public void clickYesButton() {
        driver.findElement(yesButton).click();
    }

    public void clickNopeButton() {
        driver.findElement(nopeButton).click();
    }

    public String getOrderText() {
        return driver.findElement(orderText).getText();
    }

    public boolean isStatusButtonDisplayed() {
        return driver.findElement(statusButton).isDisplayed();
    }
}
