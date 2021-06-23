package pages;

import org.openqa.selenium.WebDriver;

public class MainPage extends CommonElements{
    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void goToPage(){
        driver.get("https://otus.ru");
    }
}
