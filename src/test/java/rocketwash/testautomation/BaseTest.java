package rocketwash.testautomation;

import config.BaseConfig;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import ru.qatools.properties.PropertyLoader;
import webdriver.ExtendedWebDriver;
import webdriver.ExtendedWebDriverFactoryBean;

import java.util.concurrent.TimeUnit;

@ContextConfiguration(locations = {"classpath:" + BaseTest.CONFIGURATION_FILE})
public class BaseTest extends AbstractTestNGSpringContextTests {

    public static final String CONFIGURATION_FILE = "configuration.xml";

    @Autowired
    protected ExtendedWebDriverFactoryBean driverFactory;

//    @Autowired
//    protected DesiredCapabilities desiredCapabilities;

    @Autowired
    protected ExtendedWebDriver extendedWebDriver;

    public WebDriver getWebDriver() {
        return extendedWebDriver.getWrappedDriver();
    }

    public BaseConfig baseConfig;

   // ApplicationContext context = new ClassPathXmlApplicationContext("configuration.xml");


    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        baseConfig = PropertyLoader.newInstance().populate(BaseConfig.class);
        extendedWebDriver.manage().window().maximize();
        extendedWebDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        extendedWebDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        extendedWebDriver.quit();

    }
}
