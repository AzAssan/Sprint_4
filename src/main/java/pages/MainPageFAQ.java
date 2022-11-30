package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class MainPageFAQ {

    private final WebDriver driver;
    private final By faq = By.className("Home_FAQ__3uVm4");
    private final By accordionItem = By.className("accordion__item");

    public MainPageFAQ(WebDriver driver) {
        this.driver = driver;
    }

    public ArrayList<MainPageFAQItem> faqItems() {
        List<WebElement> items = driver.findElement(faq).findElements(accordionItem);
        ArrayList<MainPageFAQItem> faqItems = new ArrayList<>();

        for (int i = 0; i < items.size(); i++) {
            WebElement item = items.get(i);
            MainPageFAQItem faqItem = new MainPageFAQItem(driver, item);
            faqItems.add(faqItem);
        }

        return faqItems;
    }
}

