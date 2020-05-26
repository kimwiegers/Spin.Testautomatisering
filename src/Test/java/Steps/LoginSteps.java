package Steps;

import Omgevingen.Acceptatie;
import PageObjects.LoginPagina;
import TestData.GebruikersData;
import TestData.DriverSetup;
import cucumber.api.java.nl.Als;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;


public class LoginSteps {

    private GebruikersData Gebruiker;
    private WebDriver driver;
    private DriverSetup _driverSetup;

    public LoginSteps(GebruikersData gebruiker, DriverSetup driverSetup){
        Gebruiker = gebruiker;
        _driverSetup = driverSetup;
    }

    @cucumber.api.java.nl.Gegeven("een medewerker met rechten van Lange Termijn Planner in SPIN")
    public void eenMedewerkerMetRechtenVanLangeTermijnPlannerInSPIN()
    {
        Gebruiker.setGebruikersnaam(Acceptatie.gebruikersnaam);
        Gebruiker.setWachtwoord(Acceptatie.wachtwoord);
    }

    @Als("de medewerker inlogt op de {string} van SPIN")
    public void deMedewerkerInlogtOpDeVanSPIN(String gui) throws Exception {

        driver = _driverSetup.getDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        switch (gui.toLowerCase())
        {
            case "interne gui":
                driver.navigate().to(Acceptatie.interneUrl);

                driver.findElement(LoginPagina.AcceptatieGebruikersnaam)
                        .sendKeys(Gebruiker.getGebruikersnaam());
                driver.findElement(LoginPagina.AcceptatieWachtwoord).sendKeys(Gebruiker.getWachtwoord());
                driver.findElement(LoginPagina.Inlogbutton).click();
                break;
            case "externe gui":
                break;
            default:
                throw new Exception("'{gui}' is niet geimplementeerd als optie");
        }
    }
}
