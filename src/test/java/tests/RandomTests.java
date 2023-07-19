package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.base.BaseClass;
import selenium.pages.FirstPageFactory;

public class RandomTests extends BaseClass {

    FirstPageFactory firstPageFactory;

    @BeforeMethod
    public void initialize() {
        firstPageFactory = new FirstPageFactory(driver);
    }

    @Test
    public void firstTest() {

        firstPageFactory.dragAndDrop();
    }
}
