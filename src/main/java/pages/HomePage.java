package pages;

import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pageobjectutils.Page;
import ru.yandex.qatools.htmlelements.element.Button;

@Component
@Scope("prototype")
public class HomePage extends Page {

    @FindBy(className = "icon-sprite menu-icon")
    Button menuButton;

    @FindBy(className = "log-out-link")
    Button logOutButton;



    public void clickLogOutButton() {
        logOutButton.click();
    }



}
