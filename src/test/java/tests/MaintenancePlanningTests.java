package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.base.BaseClass;
import selenium.pages.MaintenancePlanning;

public class MaintenancePlanningTests extends BaseClass {

    MaintenancePlanning maintenancePlanning;

    @BeforeMethod
    public void initialize() {

        maintenancePlanning = new MaintenancePlanning(driver);
    }


    @Test
    public void setMaintenancePlanning() throws Throwable {
        maintenancePlanning.login();
        maintenancePlanning.newAogEntry();
        maintenancePlanning.assertions();
    }
}
