package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactsPage extends CommonElements{
    @FindBy(xpath = "//div[text()='Адрес']/following-sibling::div")
    private WebElement addressText;

    public ContactsPage(WebDriver driver) {
        super(driver);
    }

    public void goToPage(){
        driver.get("https://otus.ru/contacts");
    }

    public String getAddress(){
        return addressText.getText();
    }
}
