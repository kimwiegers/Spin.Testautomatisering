package Services;

import PageObjects.Hoofdpagina;
import TestData.DriverSetup;
import TestData.WegData;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static PageObjects.StandaardOmleidingen.*;

public class StandaardOmleidingenService
{
    private final WebDriver driver;
    private final Actions actions;
    private final SeleniumService _selenium;

    public StandaardOmleidingenService(DriverSetup driverSetup, SeleniumService selenium)
    {
        driver = driverSetup.getDriver();
        actions = new Actions(driver);
        _selenium = selenium;
    }
    public void OpenStandaardOmleidingenMenu()
    {
        WebElement configuratie = driver.findElement(Hoofdpagina.Configuratie);
        configuratie.click();

        //Dit is de enige manier om te navigeren in het menu
        actions.sendKeys((Keys.chord(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN,
                Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_RIGHT, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER)))
                .perform();
    }

    public Boolean StandaardOmleidingIsAanwezig() throws Exception
    {
        _selenium.SelectFromDropdown(FilterOmleidingWegnummerDropdown, 9);

        _selenium.SelectFromDropdown(FilterOmleidingWegzijde, 1);

        _selenium.EnterDataInputField(FilterOmleidingVanKilometer, WegData.StandaardOmleidingVankilometer);
        _selenium.EnterDataInputField(FilterOmleidingTotKilometer, WegData.StandaardOmleidingTotKilometer);

        _selenium.WaitUntilClickableThenClick(Zoeken);

        _selenium.ClickOnElementBasedOnCoordinates(DatumVanLaatstebewerkingDropdownX, DatumVanLaatsteBewerkingDropdownY);
        actions.sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER)).perform();

        String GeenResultatenTekst = _selenium.GetTextFromElement(GeenGevondenOmleidingen);
        if (GeenResultatenTekst.equals("Geen resultaten gevonden"))
        {
            return false;
        }

        String vanPlek = _selenium.GetTextFromElement(GevondenOmleidingVanPlek);
        String totPlek = _selenium.GetTextFromElement(GevondenOmleidingTotPlek);

        if (vanPlek.equals(WegData.OmleidingVanPlek) && totPlek.equals(WegData.OmleidingTotPlek))
        {
            return true;
        }

        else
        {
            throw new Exception("Verkeerde resultaten gevonden voor de standaard omleiding");
        }
    }

    public void CreeerNieuweStandaardOmleiding() throws Exception
    {
        _selenium.WaitUntilClickableThenClick(Nieuw);

        _selenium.SelectFromDropdown(BlokkadeStartpuntDropdown, 9);
        _selenium.SelectFromDropdown(BlokkadeWegzijdeVanDropdown, 1);
        _selenium.EnterDataInputField(BlokkadeVanKilometer, WegData.BLokkadeVanKilometer);

        _selenium.SelectFromDropdown(BlokkadeEindpuntDropdown, 9);
        _selenium.SelectFromDropdown(BlokkadeWegzijdeTotDropdown, 1);
        _selenium.EnterDataInputField(BlokkadeTotKilometer, WegData.BlokkadeTotKilometer);

        _selenium.SelectFromDropdown(OmleidingStartpuntDropdown, 9);
        _selenium.SelectFromDropdown(OmleidingWegzijdeVanDropdown, 1);
        _selenium.EnterDataInputField(OmleidingVanKilometer, WegData.StandaardOmleidingVankilometer);

        _selenium.SelectFromDropdown(OmleidingEindpuntDropdown, 9);
        _selenium.SelectFromDropdown(OmleidingWegzijdeTotDropdown, 1);
        _selenium.EnterDataInputField(OmleidingTotKilometer, WegData.StandaardOmleidingTotKilometer);

        _selenium.SelectFromDropdown(OmleidingVanPlekDropdown, 0);
        _selenium.SelectFromDropdown(OmleidingTotPlekDropdown, 0);

        _selenium.WaitUntilElementIsEnabled(Bewaren);
        _selenium.WaitUntilClickableThenClick(Bewaren);

        _selenium.SetNewImplicitWaitTime(5);
        if (driver.findElements(FoutmeldingNaOpslaan).size() >= 1)
        {
            _selenium.WaitUntilClickableThenClick(FoutmeldingNaOpslaan);
        }
    }
}
