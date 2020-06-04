package Services;

import Omgevingen.Acceptatie;
import PageObjects.Hoofdpagina;
import PageObjects.LoginPagina;
import TestData.DriverSetup;
import TestData.GebruikersData;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class SpinService
{
    private final WebDriver driver;
    private final GebruikersData _gebruiker;
    private final SeleniumService _selenium;
    private final Actions actions;

    public SpinService(DriverSetup driverSetup, GebruikersData gebruiker, SeleniumService selenium)
    {
        driver = driverSetup.getDriver();
        _gebruiker = gebruiker;
        _selenium = selenium;
        actions = new Actions(driver);
    }

    public void LogIn(String gui) throws Exception
    {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        switch (gui.toLowerCase())
        {
            case "interne gui":
                driver.navigate().to(Acceptatie.interneUrl);

                driver.findElement(LoginPagina.AcceptatieGebruikersnaam)
                        .sendKeys(_gebruiker.getGebruikersnaam());
                driver.findElement(LoginPagina.AcceptatieWachtwoord).sendKeys(_gebruiker.getWachtwoord());
                driver.findElement(LoginPagina.Inlogbutton).click();
                break;
            case "externe gui":
                break;
            default:
                throw new Exception("'{gui}' is niet geimplementeerd als optie");
        }

        _selenium.WaitUntilHomepageFullyLoaded();

        _selenium.WaitUntilClickableThenClick(Hoofdpagina.FilterWissen);

        _selenium.WaitUntilHomepageFullyLoaded();
    }

    public void ReturnToHomepage()
    {
        _selenium.WaitUntilClickableThenClick(Hoofdpagina.Overzicht);
        actions.sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ENTER)).perform();

        _selenium.WaitUntilHomepageFullyLoaded();
    }
}
