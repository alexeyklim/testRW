package rocketwash.testautomation.webdriver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

    /**
     *  Wrapper for org.openqa.selenium.WebDriver.TargetLocator
     *  For easy way of extending base func
     *
     */

public class ExtendedTargetLocator implements WebDriver.TargetLocator {

    protected WebDriver.TargetLocator targetLocator = null;

    public ExtendedTargetLocator(WebDriver.TargetLocator targetLocator) {
        this.targetLocator = targetLocator;
    }

    @Override
    public WebDriver frame(int index) {
        return this.targetLocator.frame(index);
    }

    @Override
    public WebDriver frame(String nameOrId) {
        return this.targetLocator.frame(nameOrId);
    }

    @Override
    public WebDriver frame(WebElement frameElement) {
        return this.targetLocator.frame(frameElement);
    }

    @Override
    public WebDriver parentFrame() {
        return this.targetLocator.parentFrame();
    }

    @Override
    public WebDriver window(String nameOrHandle) {
        return this.targetLocator.window(nameOrHandle);
    }

    @Override
    public WebDriver defaultContent() {
        return this.targetLocator.defaultContent();
    }

    @Override
    public WebElement activeElement() {
        return this.targetLocator.activeElement();
    }

    @Override
    public Alert alert() {
        return this.targetLocator.alert();
    }
}
