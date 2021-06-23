package ru.otus.StepsDefinitions;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Также;
import io.cucumber.java.ru.Тогда;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.ContactsPage;
import pages.FAQPage;
import pages.MainPage;
import utils.WebDriverFactory;
import utils.WebDriverType;

import java.util.concurrent.TimeUnit;

public class StepsDefinitions {
    protected static WebDriver driver;
    MainPage mainPage;
    ContactsPage contactsPage;
    FAQPage faqPage;

    @Дано("Инициализация драйвера")
    public void StartUp() {
        driver = WebDriverFactory.createDriver(WebDriverType.CHROME);
        if (driver != null) {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
    }

    @Также("Закрываем драйвер")
    public void shutDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Дано("Пользователь переходит на главную страницу")
    public void gotoMainPage() {
        mainPage = new MainPage(driver);
        mainPage.goToPage();
    }

    @Дано("Пользователь переходит на страницу Контакты")
    public void gotoContactsPage() {
        contactsPage = new ContactsPage(driver);
        contactsPage.goToPage();
    }

    @Дано("Пользователь вводит электронную почту {string}")
    public void enterSubscribeEmail(String email) {
        mainPage.enterSubscribeEmail(email);
    }

    @Когда ("Пользователь нажимает кнопку Подписаться")
    public void clickSubscribeButton(){
        mainPage.clickSubscribeButton();
    }

    @Тогда("Выводится сообщение сообщение об успешной подписке {string}")
    public void checkSuccessMessage(String message) {
        Assert.assertEquals(message,mainPage.getSuccessSubscribeMessage());
    }

    @Тогда("Отображается заголовок страницы {string}")
    public void checkPageTitle(String title) {
        Assert.assertEquals(title,mainPage.getPageTitle());
    }

    @Тогда("Отображается контактный адрес {string}")
    public void checkContactAddress(String address) {
        Assert.assertEquals(address,contactsPage.getAddress());
    }

    @Дано("Пользователь переходит на страницу FAQ")
    public void gotoFAQPage() {
        faqPage = new FAQPage(driver);
        faqPage.goToPage();
    }

    @Когда("Пользователь щелкает на вопрос {string}")
    public void clickQuestion(String question) {
        faqPage.clickQuestion(question);
    }

    @Тогда("Отображается ответ {string} на вопрос {string}")
    public void отображаетсяОтветНаВопрос(String answer, String question) {
        Assert.assertEquals(answer,faqPage.getAnswer(question));
    }
}