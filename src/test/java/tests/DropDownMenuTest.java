package tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.base.BaseClass;
import selenium.pages.DropDownMenu;

public class DropDownMenuTest extends BaseClass {

    DropDownMenu dropDownMenu;

    @BeforeMethod
    public void initialize() {

        dropDownMenu = new DropDownMenu(driver);
    }

    @Test
    public void someTest() {
        dropDownMenu.getToDropDownMenu();
        dropDownMenu.asserts();
    }
}