import constants.Color;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.OrderConfirmationPage;
import pages.OrderSecondPage;
import pages.OrderFirstPage;
import pages.OrderScooter;

@RunWith(Parameterized.class)
public class TestOrderForm {
    WebDriver driver;
    private final int orderButtonIndex;
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String phone;
    private final int stationIndex;
    private final String date;
    private final int rentPeriodIndex;
    private final String[] colors;
    private final String comment;

    public TestOrderForm(int orderButtonIndex,
                         String firstName,
                         String lastName,
                         String address,
                         String phone,
                         int stationIndex,
                         String date,
                         int rentPeriodIndex,
                         String[] colors,
                         String comment) {
        this.orderButtonIndex = orderButtonIndex;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.stationIndex = stationIndex;
        this.date = date;
        this.rentPeriodIndex = rentPeriodIndex;
        this.colors = colors;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getCostumerData() {
        return new Object[][]{
                {0, "Александра", "Бережная", "Пчелаводная 19", "54784568498", 9, "30.11.2022", 1, new String[]{Color.BLACK}, "В рабочее время."},
                {1, "Тамара", "Дурова", "Солодовникова 9", "52484848498", 3, "10.12.2022", 2, new String[]{Color.GREY}, ""},
                {1, "Ануар", "Асан", "Гагарина 154А", "77777777777", 0, "2.12.2022", 0, new String[]{Color.GREY, Color.BLACK}, "Не в рабочее время"},

        };
    }


    @Test
    public void checkOrderButton() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage", "--start-maximized");
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");

        OrderScooter objOrderScooter = new OrderScooter(driver);
        objOrderScooter.clickCookieButton();
        objOrderScooter.clickOrderButton(orderButtonIndex);

        OrderFirstPage objOrderFirstPage = new OrderFirstPage(driver);
        objOrderFirstPage.waitForForm();
        objOrderFirstPage.fill(firstName, lastName, address, stationIndex, phone);
        objOrderFirstPage.clickNextButton();

        OrderSecondPage objOrderSecondPage = new OrderSecondPage(driver);
        objOrderSecondPage.fill(date, rentPeriodIndex, colors, comment);
        objOrderSecondPage.clickOrder();

        OrderConfirmationPage objOrderConfirmationPage = new OrderConfirmationPage(driver);
        objOrderConfirmationPage.clickYesButton();

        Assert.assertTrue("Не обнаружена кнопка 'Посмотреть статус'", objOrderConfirmationPage.isStatusButtonDisplayed());
        Assert.assertNotEquals("Не обнаружен текст заказа", "", objOrderConfirmationPage.getOrderText());
    }

    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}

