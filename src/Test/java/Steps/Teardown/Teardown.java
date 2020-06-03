package Steps.Teardown;

import Services.MaatregelenService;
import TestData.DriverSetup;
import cucumber.api.java.After;
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

    @After(value = "@TestMaatregelVerwijderen", order=2)
    public void VerwijderNieuweTestMaatregel() throws InterruptedException, AWTException
    {
        _maatregelenService.VerwijderBestaandeTestMaatregel();
        driver.quit();
    }

    @After(value = "@MaatregelOnderBestaandeFase", order=1)
    public void VerwijderBestaandeTestMaatregel() throws InterruptedException, AWTException
    {
        _maatregelenService.VerwijderBestaandeTestMaatregel();
        driver.quit();
    }

    @After(order=0)
    public void CloseBrowser() {
        {
            driver.quit();
        }
    }
}
