import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Test extends LinksAndResources {

    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void startUp() {

        System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver");

        //System.setProperty("webdriver.gecko.driver", "webdrivers/geckodriver");
        //("webdriver.chrome.driver", "webdrivers/chromedriver");
        //("webdriver.gecko.driver", "webdrivers/geckodriver");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 20);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    @org.junit.Test
    public void firstTest() {

        //Перейти по ссылке http://www.sberbank.ru/ru/person
        driver.get(getBaseUrl());

        //Нажать на – Страхование
        WebElement insuranceLinkElement = driver.findElement(By.xpath(getInsuranceLink()));
        wait.until(ExpectedConditions.elementToBeClickable(insuranceLinkElement));
        insuranceLinkElement.click();

        //Выбрать – Путешествие и покупки
        // не понятно как это работает, ибо через раз
        WebElement insuranceAndBuyLinkElement = driver.findElement(By.xpath(getInsuranceAndBuyLink()));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(getInsuranceAndBuyLink())));
        insuranceAndBuyLinkElement.click();

        //Нажать на – Оформить Онлайн
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(getButtonApplyOnline())));
        WebElement buttonApplyOnline = driver.findElement(By.xpath(getButtonApplyOnline()));

        //проверяем наличие заголовка
        String findText = driver.findElement(By.xpath(getTitleAboutInsurence())).getText();
        Assert.assertThat("Текст на странице не соответствует ожидаемому", findText, Is.is("Страхование путешественников"));

        //через executor пролистываем вниз до появления кнопки Оформить онлайн
        WebElement buttonApply = driver.findElement(By.xpath(getButtonApplyOnline()));
        JavascriptExecutor executor;
        executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView();", buttonApply);
        buttonApplyOnline.click();

        //На вкладке – Выбор полиса выбрать сумму страховой защиты – Минимальная Нажать Оформить
        WebElement minInsurance = driver.findElement(By.xpath(getMinInsurance()));
        executor.executeScript("arguments[0].scrollIntoView();", minInsurance);
        minInsurance.click();

        WebElement elementButtonArrange = driver.findElement(By.xpath(getButtonArrange()));
        executor.executeScript("arguments[0].scrollIntoView();", elementButtonArrange);
        elementButtonArrange.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(getInputName())));

        WebElement elementInputSurname = driver.findElement(By.xpath(getInputSurname()));
        elementInputSurname.sendKeys("Sokolov");

        WebElement elementInputName = driver.findElement(By.xpath(getInputName()));
        elementInputName.sendKeys("Nikita");

        WebElement elementInputBirth = driver.findElement(By.xpath(getInputBirthDate()));
        elementInputBirth.sendKeys("30.12.1987");
    }
}



/**




 * На вкладке Оформить заполнить поля:
 * Фамилию и Имя, Дату рождения застрахованных
 * Данные страхователя: Фамилия, Имя, Отчество, Дата рождения, Пол Паспортные данные
 * Контактные данные не заполняем
 *
 * Проверить, что все поля заполнены правильно Нажать продолжить
 *
 * Проверить, что появилось сообщение - Заполнены не все обязательные поля

 * *** пункт 5 работает не всегда
 * кто сообразит, что нужно загуглить чтобы работало и сделает, тот молодец причем, такая штука в реальных проектах встречается часто
 *
 *
 *

• Сборка проекта с помощью Maven
        • Аннотации JUnit (@Before, @After,....)
        • Assert, AssertThat
        • Параметризация (заполнять страницу с фио 3 раза)
        • Выбор браузера (IE, Chrome, FireFox) через переменную и запуск теста в выбранном браузере через командную строку



 */