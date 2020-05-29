package Steps.Teardown;

import Services.MaatregelenService;
import TestData.DriverSetup;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;

import java.awt.*;

public class Teardown
{
    private final WebDriver driver;
    private final MaatregelenService _maatregelenService;

    public Teardown(DriverSetup driverSetup, MaatregelenService maatregelenService)
    {
        driver = driverSetup.getDriver();
        _maatregelenService = maatregelenService;
    }

    @After(value = "@MaatregelOnderBestaandeFase", order=1)
    public void VerwijderTestMaatregel() throws InterruptedException, AWTException
    {
        _maatregelenService.VerwijderTestMaatregel();
        driver.quit();
    }

    @After(order=0)
    public void CloseBrowser() {
        {
            driver.quit();
        }
    }
}
