package Services;

import PageObjects.Fase;
import PageObjects.Hoofdpagina;
import TestData.DriverSetup;
import TestData.TestData;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class FasenService
{
    private final WebDriver driver;
    private final SeleniumService _selenium;

    public FasenService(DriverSetup driverSetup, SeleniumService selenium)
    {
        driver = driverSetup.getDriver();
        _selenium = selenium;
    }
    public void MaakNieuweFaseAan(WebElement werk) throws Exception
    {
        //navigeer in contextmenu naar 'maak nieuwe fase aan'
        Actions actions = new Actions(driver);
        actions.contextClick(werk).perform();
        actions.sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN,
                Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER)).perform();

        _selenium.EnterDataInputField(Fase.Naam, TestData.Testomschrijving);
        _selenium.WaitUntilClickableThenClick(Fase.TijdslotVanToepassingNee);

        _selenium.WaitUntilClickableThenClick(Fase.Verkeershinder);

        _selenium.WaitUntilClickableThenClick(Fase.Verkeershinderklasse);
        _selenium.ClickOnElementBasedOnCoordinates(Fase.Hinderklasse0CoordinaatX, Fase.Hinderklasse0CoordinaatY);

        _selenium.WaitUntilClickableThenClick(Fase.VerkeershinderCategorie);
        _selenium.ClickOnElementBasedOnCoordinates(Fase.HindercategorieACoordinaatX, Fase.HindercategorieACoordinaatY);

        _selenium.WaitUntilClickableThenClick(Fase.Achtergrondinformatie);

        _selenium.WaitUntilClickableThenClick(Fase.Wat);
        _selenium.ClickOnElementBasedOnCoordinates(Fase.GrootschaligeWerkzaamhedenX, Fase.GrootschaligeWerkzaamhedenY);

        _selenium.WaitUntilElementIsEnabled(Fase.Bewaren);
        driver.findElement(Fase.Bewaren).click();
        _selenium.WaitUntilElementIsEnabled(Fase.Sluiten);
        Thread.sleep(2000);
        _selenium.WaitUntilClickableThenClick(Fase.Sluiten);
    }

    public void WachtTotFaseInOverzichtSTaat()
    {
        for (int i = 0; i < 10; i++)
        {

        }
    }

    public WebElement GetBestaandeFase() throws Exception
    {
        String faseNaam = _selenium.GetTextFromElement(Hoofdpagina.FaseNaam);
        if (faseNaam.equals(TestData.Testomschrijving))
        {
            return driver.findElement(Hoofdpagina.FaseNaam);
        }

        throw new Exception(String.format("fasen %s is niet de testfase", faseNaam));

    }
}
