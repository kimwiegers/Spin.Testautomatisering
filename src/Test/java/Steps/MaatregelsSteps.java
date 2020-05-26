package Steps;

import PageObjects.Hoofdpagina;
import Services.FasenService;
import Services.SeleniumService;
import Services.WerkenService;
import TestData.DriverSetup;
import cucumber.api.java.nl.Dan;
import cucumber.api.java.nl.En;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class MaatregelsSteps
{
    private final WebDriver driver;
    private final WerkenService _werkenService;
    private final FasenService _fasenService;
    private final SeleniumService _selenium;

    public MaatregelsSteps(DriverSetup driverSetup, WerkenService werkenService, FasenService fasenService, SeleniumService selenium)
    {
        driver = driverSetup.getDriver();
        _werkenService = werkenService;
        _fasenService = fasenService;
        _selenium = selenium;
    }

    @En("de medewerker maakt een nieuwe maatregel aan")
    public void deMedewerkerMaaktEenNieuweMaatregelAan() throws Exception
    {
        _werkenService.WaitUntilHomepageFullyLoaded();

        _selenium.SetNewImplicitWaitTime(30);

        _werkenService.VerwijderBestaandWerk();

        _werkenService.OpenNieuwWerk();

        _werkenService.CreeerNieuwWerk();

        WebElement werk = _werkenService.VindAangemaakteWerkTerug();

        _fasenService.MaakNieuweFaseAan(werk);



    }

    @Dan("is de maatregel getoond in het overzicht")
    public void isDeMaatregelGetoondInHetOverzicht()
    {
    }
}
