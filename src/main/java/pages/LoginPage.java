package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pageobjectutils.Page;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.TextInput;
import webdriver.ExtendedWebDriver;

@Component
@Scope("prototype")
public class LoginPage extends Page {

    private String LOGIN_PAGE = "https://rocketwash.test.rocketwash.me/#!/sign_in";

    @FindBy(id = "phone-input")
    TextInput phoneInput;

    @FindBy(id = "password-input")
    TextInput passInput;

    @FindBy(id = "sign-in")
    WebElement signInButton;

    @FindBy(className = "blue-link link md-button registration-link")
    Link lostPasswordLink;

    public void LoginPage(ExtendedWebDriver extendedWebDriver) {
        this.extendedWebDriver = extendedWebDriver;
    }

    public void navigate() {
      extendedWebDriver.navigate().to(LOGIN_PAGE);
    }

    public void enterPhone(String phone) {
        phoneInput.sendKeys(phone);
    }

    public void enterPass(String pass) {
        passInput.sendKeys(pass);
    }

    public void clickSignIn() {
        signInButton.click();
    }

    public void clickLostPasswordLink() {
        lostPasswordLink.click();
    }

}
