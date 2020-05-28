package Services;

import PageObjects.Hoofdpagina;
import PageObjects.Werk;
import TestData.DriverSetup;
import TestData.TestData;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class WerkenService
{
    private final WebDriver driver;
    private final SeleniumService _selenium;

    public WerkenService(DriverSetup driverSetup, SeleniumService selenium)
    {
        driver = driverSetup.getDriver();
        _selenium = selenium;
    }
    public void CreeerNieuwWerk() throws Exception
    {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(Werk.Startdatum)));
        driver.findElement(Werk.Startdatum).click();
        driver .findElement(Werk.VandaagInVanKalender).click();

        driver.findElement(Werk.Einddatum).click();
        _selenium.ClickOnElementBasedOnCoordinates(Werk.LaatstMogelijkeEinddatumX, Werk.LaatstMogelijkeEinddatumY);

        driver.findElement(Werk.AanvragendeDienstDropdown).click();
        _selenium.ClickOnElementBasedOnCoordinates(Werk.MiddenNederlandX, Werk.MiddenNederlandY);

        _selenium.EnterDataInputField(Werk.KorteProjectNaam, TestData.Testomschrijving);

        driver.findElement(Werk.SoortWerk).click();
        _selenium.ClickOnElementBasedOnCoordinates(Werk.AanlegAansluitingX, Werk.AanlegAansluitingY);

        _selenium.EnterDataInputField(Werk.Werkzaamheden, TestData.Testomschrijving);

        driver.findElement(Werk.OpenBesteknummers).click();
        driver.findElement(Werk.EersteBesteknummer).click();
        driver.findElement(Werk.VoegBesteknummerToe).click();
        driver.findElement(Werk.BevestigBesteknummer).click();

        driver.findElement(Werk.WegnummerVan).click();
        _selenium.ClickOnElementBasedOnCoordinates(Werk.VanA12X, Werk.VanA12Y);

        driver.findElement(Werk.Wegzijde).click();
        _selenium.ClickOnElementBasedOnCoordinates(Werk.RechtsX, Werk.RechtsY);

        _selenium.EnterDataInputField(Werk.VanKilometer, "3,300");

        driver.findElement(Werk.WegnummerTot).click();
        _selenium.ClickOnElementBasedOnCoordinates(Werk.TotA12X, Werk.TotA12Y);

        driver.findElement(Werk.WegzijdeTot).click();
        _selenium.ClickOnElementBasedOnCoordinates(Werk.TotRechtsX, Werk.TotRechtsY);

        _selenium.EnterDataInputField(Werk.TotKilometer, "149,000");

        driver.findElement(Werk.Verkeershinder).click();

        driver.findElement(Werk.HinderperiodeVan).click();
        driver.findElement(Werk.VandaagInVanKalender).click();

        driver.findElement(Werk.HinderperiodeTot).click();
        _selenium.ClickOnElementBasedOnCoordinates(Werk.LaatstMogelijkeHinderperiodeX, Werk.LaatstMogelijkeHinderperiodeY);

        driver.findElement(Werk.VerkeershinderCategorie).click();
        _selenium.ClickOnElementBasedOnCoordinates(Werk.CategorieDCoordinaatX, Werk.CategorieDCoordinaatY);

        driver.findElement(Werk.Bewaren).click();
        _selenium.WaitUntilElementIsEnabled(Werk.Sluiten);
        _selenium.WaitUntilClickableThenClick(Werk.Sluiten);
    }

    public void OpenNieuwWerk() throws InterruptedException, AWTException
    {
        Actions actions = new Actions(driver);
        _selenium.ClickOnElementBasedOnCoordinates(Hoofdpagina.BestandX,Hoofdpagina.BestandY);

        //Dit is de enige manier om te navigeren in het menu
        actions.sendKeys((Keys.chord(Keys.ARROW_DOWN, Keys.ARROW_RIGHT, Keys.ENTER)))
                .perform();
    }

    public void VerwijderBestaandWerk() throws Exception
    {
        WebElement werk = VindAangemaakteWerkTerug();
        String korteProjectNaam = _selenium.GetTextFromElement(Hoofdpagina.KorteProjectNaam);
        if (korteProjectNaam.equals(TestData.Testomschrijving))
        {
            Actions actions = new Actions(driver);
            actions.contextClick(werk).perform();
            actions.sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN,
                    Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER)).perform();
            _selenium.WaitUntilClickableThenClick(Hoofdpagina.BevestigVerwijderenWerk);

            BestaandWerkIsVerwijderd();
        }
    }

    public WebElement VindAangemaakteWerkTerug() throws InterruptedException
    {
        _selenium.WaitUntilClickableThenClick(Hoofdpagina.LaatstePagina);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(Hoofdpagina.EersteWerkOpLaatstePagina));

        _selenium.WaitUntilClickableThenClick(Hoofdpagina.Opgeslagen);
        Thread.sleep(500);
        driver.findElement(Hoofdpagina.Opgeslagen).click();

        return driver.findElement(Hoofdpagina.KorteProjectNaam);
    }

    public void WaitUntilHomepageFullyLoaded()
    {
        driver.manage().timeouts().implicitlyWait(
                90, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/div[1]"));

    }

    private void BestaandWerkIsVerwijderd() throws Exception
    {
        for (int i = 0; i < 20; i++)
        {
            String korteProjectNaam = _selenium.GetTextFromElement(Hoofdpagina.KorteProjectNaam);
            if (!korteProjectNaam.equals(TestData.Testomschrijving))
            {
                return;
            }

            Thread.sleep(1000);
        }

        throw new Exception("het werk is niet verwijderd na 15 seconden");
    }
}

