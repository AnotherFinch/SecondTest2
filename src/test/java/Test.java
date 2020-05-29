import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

@RunWith(Parameterized.class)
public class Test extends LinksAndResources {


    private WebDriver driver;
    private WebDriverWait wait;

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    @Before
    public void startUp() {

        String browser = System.getProperty("browser", "chrome");
        if ("chrome".equals(browser)) {
            System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver");
            driver = new ChromeDriver();
        } else if ("firefox".equals(browser)) {
            System.setProperty("webdriver.gecko.driver", "webdrivers/geckodriver");
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 20);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

    }

    @org.junit.Test
    public void firstTest()  {

        //Перейти по ссылке http://www.sberbank.ru/ru/person
        driver.get(getBaseUrl());
        //Нажать на – Страхование
        waitAndClick(getInsuranceLink());
        //Выбрать – Путешествие и покупки
        waitAndClick(getInsuranceAndBuyLink());
        //проверяем наличие заголовка
        findOnText(getTitleAboutInsurence(), "Текст на странице не соответствует ожидаемому", "Страхование путешественников");
        //Нажать на – Оформить Онлайн
        waitAndClick(getButtonApplyOnline());
        //На вкладке – Выбор полиса выбрать сумму страховой защиты – Минимальная Нажать Оформить
        waitAndClick(getMinInsurance());
        waitAndClick(getButtonArrange());

        //На вкладке Оформить заполнить поля:
        //Фамилию и Имя, Дату рождения застрахованных

        getWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath(getInputSurname())));
        waitAndClick(getInputSurname());
        sendKey(getInputSurname(), surname);

        waitAndClick(getInputName());
        sendKey(getInputName(), name);

        waitAndClick(getInputBirthDate());
        sendKey(getInputBirthDate(), bd);

        //Данные страхователя: Фамилия, Имя, Отчество, Дата рождения, Пол Паспортные данные
        // Пришлось поставить костыль, без него пишет, что используются недопустимые символы
        getWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath(getInputLastName())));
        waitAndClick(getInputLastName());
        sendKey(getInputLastName(), lastName);

        waitAndClick(getInputFirstName());
        sendKey(getInputFirstName(), firstName);

        waitAndClick(getInputMiddleName());
        sendKey(getInputMiddleName(), middleName);

        waitAndClick(getInputBD());
        sendKey(getInputBD(), birthDate);

        waitAndClick(getInputMiddleName());
        waitAndClick(getInputSex());

        waitAndClick(getInputPassSeries());
        sendKey(getInputPassSeries(), passSeries);

        waitAndClick(getInputPassNum());
        sendKey(getInputPassNum(), passNum);

        waitAndClick(getInputDatePass());
        sendKey(getInputDatePass(), datePass);

        waitAndClick(getInputIssued());
        sendKey(getInputIssued(), issued);

        assertElement("Не указана фамилия", surname, getInputSurname());
        assertElement("Не указано имя", name, getInputName());
        assertElement("Не указана дата", bd, getInputBirthDate());
        assertElement("Не указана фамилия", lastName, getInputLastName());
        assertElement("Не указано имя", firstName, getInputFirstName());
        assertElement("Не указано отчество", middleName, getInputMiddleName());
        assertElement("Не указана дата", birthDate, getInputBD());
        assertElement("Не указана серия паспорта", passSeries, getInputPassSeries());
        assertElement("Не указан номер паспорта ", passNum, getInputPassNum());
        assertElement("Не указана дата паспорта ", datePass, getInputDatePass());
        assertElement("Не указано кем выдан ", issued, getInputIssued());

        waitAndClick(getButtonSubmit());
        findIs(getAlert(), "Не отображается текст", true);
    }

    @After
    public void quit() {
        driver.quit();
    }


    void waitAndClick(String XPath) {
        Actions actions = new Actions(getDriver());
        WebElement element = getDriver().findElement(By.xpath(XPath));
        getWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPath)));
        getWait().until(ExpectedConditions.elementToBeClickable(element));
        actions.moveToElement(element).build().perform();
        JavascriptExecutor executor;
        executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }

    void findOnText(String XPath, String badText, String goodText) {
        String findText = driver.findElement(By.xpath(XPath)).getText();
        Assert.assertThat(badText, findText, Is.is(goodText));
    }

    void findIs(String XPath, String badText, boolean yesOrNo) {
        WebElement elementAlert = driver.findElement(By.xpath(XPath));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPath)));
        Assert.assertEquals(badText, yesOrNo, elementAlert.isDisplayed());
    }


    void sendKey(String XPath, String text) {
        WebElement element = getDriver().findElement(By.xpath(XPath));
        element.sendKeys(text);
    }

    void assertElement(String badText, String goodText, String XPath) {
        WebElement element = getDriver().findElement(By.xpath(XPath));
        Assert.assertEquals(badText, goodText, element.getAttribute("value"));
    }

}
