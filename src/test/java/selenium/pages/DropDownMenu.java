package selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DropDownMenu {
    WebDriver driver;
    Actions actions;

    public DropDownMenu(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//*[@id=\"menu-item-2803\"]/a/span[2]")
    WebElement dropDown;

    @FindBy(xpath = "//option[contains(text(),'Bulgaria')]")
    WebElement country;

    public void getToDropDownMenu() {
        dropDown.click();
        actions = new Actions(driver);
        country.click();
    }

    public void asserts() {
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.globalsqa.com/demo-site/select-dropdown-menu/";
        Assert.assertEquals(currentUrl, expectedUrl);
    }
}