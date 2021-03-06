package rocketwash.testautomation.pageobjectutils;

import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import rocketwash.testautomation.webdriver.ExtendedWebDriver;

import javax.annotation.PostConstruct;


public class Page {

    @Autowired
    protected ExtendedWebDriver extendedWebDriver;

    @PostConstruct
    public void initElements() {
        PageFactory.initElements(new HtmlElementDecorator(extendedWebDriver), this);
        System.out.println("blablabla");
    }


}
