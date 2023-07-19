package tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.base.BaseClass;
import selenium.pages.AccordionPageFactory;

public class WidgetsTests extends BaseClass {

    AccordionPageFactory accordionPageFactory;

    @BeforeMethod
    public void initialize() {

        accordionPageFactory = new AccordionPageFactory(driver);
    }
    @Test
    public void secondTest() {
        accordionPageFactory.selectSection2();
        accordionPageFactory.assertions();
    }
}