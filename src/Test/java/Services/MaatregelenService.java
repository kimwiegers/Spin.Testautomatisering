package Services;

import PageObjects.Hoofdpagina;
import TestData.DriverSetup;
import TestData.TestData;
import TestData.WegData;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;

import static PageObjects.Maatregel.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MaatregelenService
{

    private final SeleniumService _selenium;
    private final WebDriver driver;
    private final DatesAndTimesService _datesAndTimesService;

    public MaatregelenService(SeleniumService selenium, DriverSetup driverSetup, DatesAndTimesService datesAndTimesService)
    {
        driver = driverSetup.getDriver();
        _selenium = selenium;
        _datesAndTimesService = datesAndTimesService;
    }


    public void OpenNieuweMaatregel() throws Exception
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

    public void VerwijderBestaandeTestMaatregel() throws AWTException, InterruptedException
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

        Thread.sleep(1300);
        _selenium.ContextClickOnElementBasedOnCoordinates(Hoofdpagina.EersteFaseOnderEersteWerkEerstePaginaX,Hoofdpagina.EersteFaseOnderEersteWerkEerstePaginaY);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN,
                Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_RIGHT,
                Keys.ENTER)).perform();

        _selenium.SwitchToCurrentScreen();

        WaitUntilMaatregelPageLoaded();
    }

    public void MaakNieuweMaatregelAan(int begindatumAantalDagenVanafVandaag,
                                       int einddatumAantalDagenVanafVandaag) throws Exception
    {
        EnterMaatregelData(begindatumAantalDagenVanafVandaag, einddatumAantalDagenVanafVandaag);

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
    }

    public void SluitNieuweBewaardeMaatregel() throws Exception
    {
        _selenium.WaitUntilElementIsEnabled(Sluiten);
        _selenium.WaitUntilClickableThenClick(Sluiten);
    }

    public void EnterMaatregelData(int begindatumAantalDagenVanafVandaag, int einddatumAantalDagenVanafVandaag) throws Exception
    {
        EnterTijdvakData(begindatumAantalDagenVanafVandaag, einddatumAantalDagenVanafVandaag);

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

    public void EnterTijdvakData(int aantalDagenVanafVandaagBegindatum, int aantalDagenVanafVandaagEinddatum)
    {
        String begindatum = _datesAndTimesService.GetDatumFormatInvoerveld(aantalDagenVanafVandaagBegindatum);
        String einddatum = _datesAndTimesService.GetDatumFormatInvoerveld(aantalDagenVanafVandaagEinddatum);
        _selenium.EnterDataInputField(BegindatumInputfield, begindatum);

        _selenium.EnterDataInputField(EinddatumInputfield, einddatum);
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

    public void AddStandaardOmleidingTomaatregel() throws Exception
    {
        WaitUntilMaatregelPageLoaded();
        _selenium.SetNewImplicitWaitTime(15);

        VulRouteIn();
        Thread.sleep(1000);

        _selenium.WaitUntilClickableThenClick(OmleidingTabblad);
        _selenium.WaitUntilClickableThenClick(OmleidingToevoegen);

        //Je moet nu switchen tussen zoekopties voordat je daadwerkelijke resultaten ziet = bug
        _selenium.WaitUntilClickableThenClick(BlokkadeLocatie);
        Thread.sleep(500);
        _selenium.WaitUntilClickableThenClick(StandaardOmleidingRaakvlak);
        Thread.sleep(500);

        _selenium.SelectFromDropdown(StandaardOmleidingWegnummerDropdown, 9);
        _selenium.SelectFromDropdown(StandaardOmleidingWegzijdeDropdown, 1);
        _selenium.EnterDataInputField(StandaardOmleidingVanKilometer, WegData.StandaardOmleidingVankilometer);
        _selenium.EnterDataInputField(StandaardOmleidingTotKilometer, WegData.StandaardOmleidingTotKilometer);
        _selenium.WaitUntilElementIsEnabled(StandaardOmleidingZoeken);
        _selenium.WaitUntilClickableThenClick(StandaardOmleidingZoeken);

        _selenium.WaitUntilClickableThenClick(GevondenStandaardOmleiding);
        _selenium.WaitUntilElementIsEnabled(StandaardOmleidingGebruiken);
        _selenium.WaitUntilClickableThenClick(StandaardOmleidingGebruiken);

        _selenium.WaitUntilClickableThenClick(SoortRouteAdviesroute);
        _selenium.EnterDataInputField(OmleidingAanmakenVolgRoute, TestData.Testomschrijving);

        _selenium.WaitUntilElementIsEnabled(OmleidingToepassen);
        _selenium.WaitUntilClickableThenClick(OmleidingToepassen);

        _selenium.WaitUntilElementIsEnabled(OmleidingSluiten);
        _selenium.WaitUntilClickableThenClick(OmleidingSluiten);
    }
}
