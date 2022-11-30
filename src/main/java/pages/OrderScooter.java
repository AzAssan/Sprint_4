package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderScooter {
    private final WebDriver driver;

    private final By rccButton = By.id("rcc-confirm-button");
    private final By orderButton = By.xpath(".//button[contains(@class,'Button_Button__ra12g') and text()='Заказать']");

    public OrderScooter(WebDriver driver) {
        this.driver = driver;
    }


    public void clickCookieButton() {
        driver.findElement(rccButton).click();
    }

    public void clickOrderButton(int ind) {
        WebElement button = driver.findElements(orderButton).get(ind);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", button);
        button.click();
    }

}








