package selenium.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;
import java.util.NoSuchElementException;

public class MaintenancePlanning {

    WebDriver driver;
    Actions actions;
    FluentWait<WebDriver> wait;


    public MaintenancePlanning(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(40))
                .pollingEvery(Duration.ofSeconds(10))
                .ignoring(NoSuchElementException.class);
    }

    @FindBy(id = "email")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(xpath = "//button[@class='btn btn-success pull-right']")
    WebElement loginBtn;

    @FindBy(xpath = "//a[@href='#/aogplanning']")
    WebElement mtnPlanning;

    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/div[2]/div/div[1]/button[1]")
    WebElement aogMngmBtn;

    @FindBy(xpath = "//*[@id='s2id_aircraftSelect']")
    WebElement dropDownMenu;

    @FindBy(xpath = "//*[@id=\"select2-chosen-4\"]")
    WebElement airport;

    @FindBy(xpath = "//*[@id=\"maintenancePlanningForm\"]/div[3]/div/textarea")
    WebElement description;

    @FindBy(xpath = "//button[@ng-click='saveAogPlanning();']")
    WebElement saveBtn;

    public void login() {

        username.sendKeys("teodor.galabov@accedia.com");
        password.sendKeys("Pa$$w0rd");
        actions = new Actions(driver);
        loginBtn.click();
    }

    public void newAogEntry() throws Throwable {
        Thread.sleep(10000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", mtnPlanning);
        actions.moveToElement(mtnPlanning).click().build().perform();
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOf(aogMngmBtn)).click();
        Thread.sleep(5000);
        actions.click(dropDownMenu)
                .sendKeys(dropDownMenu, "147" + Keys.RETURN)
                .perform();
        Thread.sleep(1000);
        actions.click(airport)
                .sendKeys("EKVO").perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.RETURN)
                .perform();
        Thread.sleep(2000);
        actions.click(description)
                .sendKeys("lorem ipsum").perform();
        actions.sendKeys(Keys.RETURN).perform();
    }

    public void assertions() {
        String expectedTitle = "Globaljet";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }
}
