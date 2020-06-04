package Steps.Teardown;

import PageObjects.Hoofdpagina;
import Services.MaatregelenService;
import Services.SeleniumService;
import TestData.DriverSetup;
import cucumber.api.java.After;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;

public class Teardown
{
    private final WebDriver driver;
    private final MaatregelenService _maatregelenService;
    private final SeleniumService _selenium;

    public Teardown(DriverSetup driverSetup, MaatregelenService maatregelenService, SeleniumService selenium)
    {
        driver = driverSetup.getDriver();
        _maatregelenService = maatregelenService;
        _selenium = selenium;
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
