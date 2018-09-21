package rocketwash.testautomation.webdriver;

import org.openqa.selenium.WebDriver;

import java.net.URL;

    /**
     *  Wrapper for org.openqa.selenium.WebDriver.Navigation
     *  For easy way of extending base func
     *
    */

public class ExtendedNavigation implements WebDriver.Navigation {

    protected WebDriver.Navigation navigation = null;

    public ExtendedNavigation(WebDriver.Navigation navigation) {
        this.navigation = navigation;
    }

    @Override
    public void back() {
        this.navigation.back();
    }

    @Override
    public void forward() {
        this.navigation.forward();
    }

    @Override
    public void to(String url) {
        this.navigation.to(url);
    }

    @Override
    public void to(URL url) {
        this.navigation.to(url);
    }

    @Override
    public void refresh() {
        this.navigation.refresh();

    }
}
