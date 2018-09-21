package rocketwash.testautomation.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.WrapsDriver;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

    /**
     *  Custom implementation of org.openqa.selenium.WebDriver
     *  For easy way of extending base func
     *
    */
@Component
public class ExtendedWebDriver implements WebDriver, WrapsDriver {

    protected WebDriver webDriver;
    protected ExtendedOptions  options = null;
    protected ExtendedNavigation navigation = null;
    protected ExtendedTargetLocator targetLocator = null;

    public ExtendedWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.options = new ExtendedOptions(webDriver.manage());
        this.navigation = new ExtendedNavigation(webDriver.navigate());
        this.targetLocator = new ExtendedTargetLocator(webDriver.switchTo());
    }


    @Override
    public void get(String url) {
        getWrappedDriver().get(url);
    }

    @Override
    public String getCurrentUrl() {
        return getWrappedDriver().getCurrentUrl();
    }

    @Override
    public String getTitle() {
        return getWrappedDriver().getTitle();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return getWrappedDriver().findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return getWrappedDriver().findElement(by);
    }

    @Override
    public String getPageSource() {
        return getWrappedDriver().getPageSource();
    }

    @Override
    public void close() {
        getWrappedDriver().close();
    }

    @Override
    public void quit() {
        getWrappedDriver().quit();
    }

    @Override
    public Set<String> getWindowHandles() {
        return getWrappedDriver().getWindowHandles();
    }

    @Override
    public String getWindowHandle() {
        return getWrappedDriver().getWindowHandle();
    }

    @Override
    public TargetLocator switchTo() {
        return this.targetLocator;
    }

    @Override
    public Navigation navigate() {
        return this.navigation;
    }

    @Override
    public Options manage() {
        return this.options;
    }

    @Override
    public WebDriver getWrappedDriver() {
        return webDriver;
    }
}
