
import pages.MainPageFAQ;
import pages.MainPageFAQItem;
import org.hamcrest.MatcherAssert;

import static org.hamcrest.CoreMatchers.is;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.After;
import org.junit.Test;

import java.util.ArrayList;


public class TestFAQ {

    private WebDriver driver;

    @Test
    public void checkFAQ() {
        // драйвер для браузера Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");

        MainPageFAQ mainPageFAQ = new MainPageFAQ(driver);
        ArrayList<MainPageFAQItem> mainPageFAQItems = mainPageFAQ.faqItems();
        for (int i = 0; i < mainPageFAQItems.size(); i++) {
            MainPageFAQItem mainPageFAQItem = mainPageFAQItems.get(i);
            mainPageFAQItem.scrollAndClick();
            boolean isAnswerDisplayed = mainPageFAQItem.isAnswerDisplayed();
            MatcherAssert.assertThat(isAnswerDisplayed, is(true));
        }
    }


    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}
