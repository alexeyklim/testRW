package rocketwash.testautomation.smoke;

import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import rocketwash.testautomation.BaseTest;

public class newSmokeTest extends BaseTest {

    @Autowired
    protected LoginPage loginPage;
    @Autowired
    protected HomePage homepage;

    @Test(groups = {"test"})
    public void smokeTest() {

        loginPage.navigate();
        loginPage.enterPhone(baseConfig.getUser());
        loginPage.enterPass(baseConfig.getPassword());
        loginPage.clickSignIn();

        homepage.clickLogOutButton();

    }
}
