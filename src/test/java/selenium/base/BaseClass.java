package selenium.base;

import newOne.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BaseClass {
    public WebDriver driver;
    String url = "https://www.globalsqa.com/demo-site/draganddrop/";
    String url2 = "https://jqueryui.com";
    String url3 = "http://10.43.1.20:3000/#/dashboard";
    @BeforeClass
    public void setUp() {
        driver = new DriverManager().initializeDriver();
        driver.get(url3);
        driver.manage().window().maximize();
    }

//    public void firstTest() {
//
//        WebElement iFrame = driver.findElement(By.cssSelector(".demo-frame.lazyloaded"));
//        driver.switchTo().frame(iFrame);
//        WebElement dragAndDropEl = driver.findElement(By.xpath("/html/body/div[1]/ul/li[4]/img"));
//        WebElement trashBin = driver.findElement(By.id("trash"));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dragAndDropEl);
//        Actions action = new Actions(driver);
//        action.clickAndHold(dragAndDropEl).moveToElement(trashBin).release().build().perform();
//    }
}