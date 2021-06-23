package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class CommonElements {
    protected static WebDriver driver;
    private WebElement subscribeEmailInput;
    @FindBy(xpath = "//button[@class='footer2__subscribe-button button button_blue button_as-input']")
    private WebElement subscribeButton;
    @FindBy(xpath = "//p[@class='subscribe-modal__success']")
    private WebElement subscribeMessage;

    public CommonElements(WebDriver driver){
        CommonElements.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void enterSubscribeEmail(String email){
        subscribeEmailInput.sendKeys(email);
    }

    public void clickSubscribeButton(){
        subscribeButton.click();
    }

    public String getSuccessSubscribeMessage(){
        return subscribeMessage.getText();
    }

    public String getPageTitle(){
        return driver.getTitle();
    }
}