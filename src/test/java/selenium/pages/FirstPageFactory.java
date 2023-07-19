package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FirstPageFactory {
    WebDriver driver;
    Actions actions;

    public FirstPageFactory(WebDriver ldriver) {
        this.driver = ldriver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".demo-frame")
    WebElement iFrame;
    @FindBy(xpath = "//p[contains(text(),'Drag me to my target')]")
    WebElement element;
    @FindBy(xpath = "/html[1]/body[1]/div[2]")
    WebElement drop;
    @FindBy(xpath = "//a[@href='https://jqueryui.com/droppable/']")
    WebElement droppableLink;

    public void dragAndDrop() {
        droppableLink.click();
        driver.switchTo().frame(iFrame);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

        actions = new Actions(driver);
        actions.dragAndDrop(element, drop).perform();
    }
}