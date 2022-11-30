package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderSecondPage {
    private final WebDriver driver;
    private final By calendarButton = By.className("react-datepicker__day--selected");

    private final By dateInput = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private final By rentPeriodDropdown = By.className("Dropdown-control");

    private final By rentPeriodOption = By.xpath("//div[@class='Dropdown-option']");

    private final By comment = By.xpath(".//input[@placeholder='Комментарий для курьера']");

    private final By orderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");


    public OrderSecondPage(WebDriver driver) {
        this.driver = driver;
    }


    public void setDate(String date) {
        driver.findElement(dateInput).sendKeys(date);
        driver.findElement(calendarButton).click();
    }

    public void clickRentPeriod(int ind) {
        driver.findElement(rentPeriodDropdown).click();
        driver.findElements(rentPeriodOption).get(ind).click();
    }


    public void clickColor(String color) {
        String xpath = ".//input[@class='Checkbox_Input__14A2w' and @id='" + color + "']";
        driver.findElement(By.xpath(xpath)).click();
    }

    public void setComment(String text) {
        driver.findElement(comment).clear();
        driver.findElement(comment).sendKeys(text);
    }

    public void clickOrder() {
        driver.findElement(orderButton).click();
    }


    public void fill(String date, int rentPeriodIndex, String[] colors, String comment) {
        setDate(date);
        clickRentPeriod(rentPeriodIndex);
        for (int i = 0; i < colors.length; i++) {
            clickColor(colors[i]);
        }
        setComment(comment);
    }
}

