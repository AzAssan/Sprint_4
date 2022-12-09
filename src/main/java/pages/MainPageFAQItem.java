package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPageFAQItem {
    private final WebDriver driver;
    private final WebElement faqItem;
    private final By accordionButton = By.className("accordion__button");
    private final By accordionPanel = By.className("accordion__panel");

    public MainPageFAQItem(WebDriver driver, WebElement faqItem) {
        this.driver = driver;
        this.faqItem = faqItem;
    }

    public void click() {
        faqItem.findElement(accordionButton).click();
    }

    public boolean isAnswerDisplayed() {
        return faqItem.findElement(accordionPanel).isDisplayed();
    }

    public void scroll() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", faqItem);
    }

    public void scrollAndClick() {
        scroll();
        click();
    }
}


