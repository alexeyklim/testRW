package rocketwash.testautomation.webdriver;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.Logs;

import java.util.Set;

 /**
    Wrapper for org.openqa.selenium.WebDriver.Options
    For easy way of extending base functionality and add custom func
 */

public class ExtendedOptions implements WebDriver.Options {

    protected WebDriver.Options options = null;

    public ExtendedOptions(WebDriver.Options options) {
        this.options = options;
    }

    @Override
    public void addCookie(Cookie cookie) {
        this.options.addCookie(cookie);
    }

    @Override
    public void deleteCookieNamed(String name) {
        this.options.deleteCookieNamed(name);
    }

    @Override
    public void deleteCookie(Cookie cookie) {
        this.options.deleteCookie(cookie);
    }

    @Override
    public void deleteAllCookies() {
        this.options.deleteAllCookies();
    }

    @Override
    public Set<Cookie> getCookies() {
        return this.options.getCookies();
    }

    @Override
    public Cookie getCookieNamed(String name) {
        return this.options.getCookieNamed(name);
    }

    @Override
    public WebDriver.Timeouts timeouts() {
        return this.options.timeouts();
    }

    @Override
    public WebDriver.ImeHandler ime() {
        return this.options.ime();
    }

    @Override
    public WebDriver.Window window() {
        return this.options.window();
    }

    @Override
    public Logs logs() {
        return this.options.logs();
    }
}
