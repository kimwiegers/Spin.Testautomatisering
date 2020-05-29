package Services;

import PageObjects.Hoofdpagina;
import PageObjects.Maatregel;
import TestData.DriverSetup;
import TestData.TestData;
import TestData.WegData;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.util.List;

import static PageObjects.Maatregel.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MaatregelenService
{

    private final SeleniumService _selenium;
    private final WebDriver driver;

    public MaatregelenService(SeleniumService selenium, DriverSetup driverSetup)
    {
        driver = driverSetup.getDriver();
        _selenium = selenium;
    }


    public void OpenNieuweMaatregel(WebElement fase) throws Exception
    {
        Actions actions = new Actions(driver);
        actions.moveByOffset(Hoofdpagina.FaseX, Hoofdpagina.FaseY).perform();
        actions.contextClick().perform();

        actions.sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN,
                Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_RIGHT,
                Keys.ENTER)).perform();

        _selenium.SwitchToCurrentScreen();

        WaitUntilMaatregelPageLoaded();
    }

    public void VerwijderTestMaatregel() throws AWTException, InterruptedException
    {
        _selenium.WaitUntilClickableThenClick(Sluiten);
        _selenium.SetNewImplicitWaitTime(5);
        Thread.sleep(1000);
        _selenium.SwitchToCurrentScreen();
            _selenium.ClickOnElementBasedOnCoordinates(Hoofdpagina.KlapEersteFaseOnderEersteWerkOpenX, Hoofdpagina.KlapEersteFaseOnderEersteWerkOpenY);
            _selenium.ContextClickOnElementBasedOnCoordinates(Hoofdpagina.EersteMaatregelOnderEersteFaseX, Hoofdpagina.EersteMaatregelOnderEersteFaseY);
            Thread.sleep(500);
            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN,
                    Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER)).perform();

            _selenium.WaitUntilClickableThenClick(Hoofdpagina.BevestigVerwijderenMaatregel);
    }

    public void OpenNieuweMaatregelOnderbestaandeFase() throws Exception
    {
        _selenium.SwitchToCurrentScreen();

        Thread.sleep(1000);
        _selenium.ContextClickOnElementBasedOnCoordinates(Hoofdpagina.EersteFaseOnderEersteWerkEerstePaginaX,Hoofdpagina.EersteFaseOnderEersteWerkEerstePaginaY);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN,
                Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_RIGHT,
                Keys.ENTER)).perform();

        _selenium.SwitchToCurrentScreen();

        WaitUntilMaatregelPageLoaded();
    }

    public void MaakNieuweMaatregelAan() throws Exception
    {
        EnterMaatregelData();

        Thread.sleep(3000);
        _selenium.WaitUntilElementIsEnabled(Bewaren);
        _selenium.WaitUntilClickableThenClick(Bewaren);

        Thread.sleep(1000);
        _selenium.SetNewImplicitWaitTime(5);
        if (driver.findElements(MaatregelBuitenTIjdvakFase).size() >= 1)
        {
            driver.findElement(MaatregelBuitenTIjdvakFase).click();
        }

        Thread.sleep(1000);
        if (driver.findElements(MaatregelDesondanksOpgeslagen).size() >= 1)
        {
            driver.findElement(MaatregelDesondanksOpgeslagen).click();
        }

        _selenium.WaitUntilElementIsEnabled(Sluiten);
        _selenium.WaitUntilClickableThenClick(Sluiten);
    }

    public void EnterMaatregelData() throws Exception
    {
        EnterTijdvakData();

        Actions actions = new Actions(driver);

        _selenium.WaitUntilClickableThenClick(WegwerktypeDropdown);
        actions.sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ENTER)).perform();

        driver.findElement(Wegbeheerder).clear();
        _selenium.WaitUntilClickableThenClick(WegbeheerderDropdown);
        actions.sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ENTER)).perform();

        _selenium.WaitUntilClickableThenClick(BesteknummerDropdown);
        actions.sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ENTER)).perform();

        VulRouteIn();

        _selenium.WaitUntilClickableThenClick(VerkeershinderklasseDropdown);
        actions.sendKeys(Keys.chord(Keys.ENTER)).perform();

        driver.findElement(FilegevoeligNee).click();
        driver.findElement(WeergevoeligNee).click();
        driver.findElement(SnelheidslimietNee).click();

        _selenium.WaitUntilClickableThenClick(Afzetsysteem);
        actions.sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ENTER)).perform();
        _selenium.WaitUntilClickableThenClick(CompleteWegafsluitingNee);

        _selenium.WaitUntilClickableThenClick(Dwarsprofiel1);
        _selenium.WaitUntilClickableThenClick(Dwarsprofiel1PijlOmhoog);

        _selenium.EnterDataInputField(Breedte, WegData.Breedte);
        _selenium.WaitUntilClickableThenClick(HoogteNee);
        _selenium.WaitUntilClickableThenClick(LengteNee);

        _selenium.WaitUntilClickableThenClick(VerkeersloketDropdown);
        actions.sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ENTER)).perform();

        _selenium.WaitUntilClickableThenClick(OpmerkingToevoegen);
        _selenium.EnterDataInputField(OpmerkingInput, TestData.Testomschrijving);
        _selenium.WaitUntilElementIsEnabled(OpmerkingToevoegenOk);
        driver.findElement(OpmerkingToevoegenOk).click();
    }

    public void EnterTijdvakData()
    {
        _selenium.WaitUntilClickableThenClick(Startdatum);
        _selenium.WaitUntilClickableThenClick(VandaagInVanKalender);

        String datum = new DatesAndTimesService().GetDatumInToekomstFormatInvoerveld(7);
        _selenium.EnterDataInputField(EinddatumInputfield, datum);
    }

    public void WaitUntilMaatregelPageLoaded() throws Exception
    {
        assertThat(_selenium.VeldIsRoodOnderstreept(EinddatumInputfield)).isTrue();
    }

    public void VulRouteIn() throws Exception
    {
        Actions actions = new Actions(driver);

        //De enige manier om de A12 goed te selecteren voor zowel Van als Tot wegnummer
        driver.findElement(VanWegnummer).clear();
        _selenium.WaitUntilClickableThenClick(VanWegnummerDropdown);
        actions.sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN,
                Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER)).perform();

        driver.findElement(TotWegnummer).clear();
        _selenium.WaitUntilClickableThenClick(TotWegnummerDropdown);
        actions.sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN,
                Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER)).perform();

        Thread.sleep(500);
        driver.findElement(VanWegzijde).clear();
        _selenium.WaitUntilClickableThenClick(VanWegzijdeDropdown);
        actions.sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER)).perform();

        driver.findElement(TotWegzijde).clear();
        _selenium.WaitUntilClickableThenClick(TotWegzijdeDropdown);
        actions.sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER)).perform();

        _selenium.EnterDataInputField(VanKilometer, WegData.VanKilometer);
        _selenium.EnterDataInputField(TotKilometer, WegData.TotKilometer);
    }
}
