package selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.NoSuchElementException;

public class AccordionPageFactory {
    WebDriver driver;
    Actions actions;
    FluentWait<WebDriver> wait;

    public AccordionPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
    }

    @FindBy(xpath = "//*[@id=\"sidebar\"]/aside[2]/ul/li[1]/a")
    WebElement accordion;
    @FindBy(css = ".demo-frame")
    WebElement iFrame;
    @FindBy(xpath = "//*[@id='ui-id-3']")
    WebElement section2;

    public void selectSection2() {
        accordion.click();
        driver.switchTo().frame(iFrame);
        actions = new Actions(driver);
        wait.until(ExpectedConditions.elementToBeClickable(section2)).click();
    }

    public void assertions() {
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://jqueryui.com/accordion/";
        Assert.assertEquals(currentUrl, expectedUrl);
        section2.isDisplayed();
    }
}