package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AbstractFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.File;
import java.net.MalformedURLException;
import java.util.Optional;

/**
 * Factory Bean for ExtendedWebDriver which encapsulates its custom construction logic
 */
public class ExtendedWebDriverFactoryBean extends AbstractFactoryBean<WebDriver> {

    private static final String PLATFORM = "platform";
    private static final String DEFAULT_PLATFORM = "any";
    private static final String BROWSER = "browser";
    private static final String DEFAULT_BROWSER = "chrome";
    private static final String BROWSER_VERSION = "browser_version";

    protected ExtendedWebDriver instance;

    protected DesiredCapabilities desiredCapabilities;

    public DesiredCapabilities getDesiredCapabilities() {
        return desiredCapabilities;
    }

    public void setDesiredCapabilities(DesiredCapabilities desiredCapabilities) {
        this.desiredCapabilities = desiredCapabilities;
    }

    public Class<?> getObjectType() {
        return ExtendedWebDriver.class;
    }

    protected ExtendedWebDriver createInstance() throws Exception {
        if (instance == null) {
                instance = creation();
        }
        return instance;
    }

    public ExtendedWebDriver getInstance(ExtendedWebDriver instance) {
        return instance;
    }

    private ExtendedWebDriver creation() throws MalformedURLException {

        WebDriver webDriver = null;

        String browser = Optional.ofNullable(System.getProperty(BROWSER)).orElse(DEFAULT_BROWSER);
        String browser_version = System.getProperty(BROWSER_VERSION);
        String platform = "windows";
                //= System.getProperty(PLATFORM);

        if(platform.equalsIgnoreCase("windows")) {
            switch (browser.toLowerCase()) {
                case "firefox":
                    System.setProperty("webdriver.gecho.driver", System.getProperty("user.dir") + File.separator + "geckodriver.exe");
                    desiredCapabilities = DesiredCapabilities.firefox();
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.setCapability("marionette", true);
                    firefoxOptions.merge(desiredCapabilities);
                    webDriver = new FirefoxDriver(firefoxOptions);
                    break;
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "chromedriver.exe");
                    desiredCapabilities = DesiredCapabilities.chrome();
                    ChromeOptions options = new ChromeOptions();
                    options.merge(desiredCapabilities);
                    webDriver = new ChromeDriver(options);
                    break;
                case "safari":
                    SafariOptions safariOptions = new SafariOptions();
                    safariOptions.merge(desiredCapabilities);
                    webDriver = new SafariDriver(safariOptions);
                    break;
                default:
                    System.out.println(browser + " browser is not setup in the framework");
                    break;
            }
        } else if (platform.equalsIgnoreCase("mac")) {

            switch (browser.toLowerCase()){
                case "firefox":
                    System.setProperty("webdriver.gecho.driver", System.getProperty("user.dir") + File.separator + "geckodriver.exe");
                    desiredCapabilities = DesiredCapabilities.firefox();
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.setCapability("marionette", true);
                    firefoxOptions.merge(desiredCapabilities);
                    webDriver = new FirefoxDriver(firefoxOptions);
                    break;
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "chromedriver.exe");
                    desiredCapabilities = DesiredCapabilities.chrome();
                    ChromeOptions options = new ChromeOptions();
                    options.merge(desiredCapabilities);
                    webDriver = new ChromeDriver(options);
                    break;
                case "safari":
                    SafariOptions safariOptions = new SafariOptions();
                    safariOptions.merge(desiredCapabilities);
                    webDriver = new SafariDriver(safariOptions);
                    break;
                default:
                    System.out.println(browser + " browser is not setup in the framework");
                    break;
            }
        } else {
            System.out.println(platform + " platform isn't setup in the framework");
        }
        return new ExtendedWebDriver(webDriver);
    }

    public void release() {
        instance = null;
    }
}
