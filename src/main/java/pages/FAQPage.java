package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FAQPage extends CommonElements{
    public FAQPage(WebDriver driver) {
        super(driver);
    }

    public void goToPage(){driver.get("https://otus.ru/faq");}

    public void clickQuestion(String question){
        String locator = String.format("//div[text()='%s']",question);
        driver.findElement(By.xpath(locator)).click();
    }

    public String getAnswer(String question){
        String locator = String.format("//div[text()='%s']/following-sibling::div",question);
        return driver.findElement(By.xpath(locator)).getText();
    }
}