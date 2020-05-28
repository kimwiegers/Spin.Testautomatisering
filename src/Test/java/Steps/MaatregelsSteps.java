package Steps;

import PageObjects.Hoofdpagina;
import PageObjects.Maatregel;
import Services.FasenService;
import Services.MaatregelenService;
import Services.SeleniumService;
import Services.WerkenService;
import TestData.DriverSetup;
import TestData.WegData;
import cucumber.api.java.nl.Dan;
import cucumber.api.java.nl.En;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;

import static PageObjects.Maatregel.*;
import static org.assertj.core.api.Assertions.assertThat;

public class MaatregelsSteps
{
    private final WebDriver driver;
    private final Actions actions;
    private final WerkenService _werkenService;
    private final FasenService _fasenService;
    private final MaatregelenService _maatregelenService;
    private final SeleniumService _selenium;

    public MaatregelsSteps(DriverSetup driverSetup, WerkenService werkenService, FasenService fasenService,
                           SeleniumService selenium, MaatregelenService maatregelenService)
    {
        driver = driverSetup.getDriver();
        _werkenService = werkenService;
        _fasenService = fasenService;
        _maatregelenService = maatregelenService;
        _selenium = selenium;
        actions = new Actions(driver);
    }

    @En("de medewerker maakt een nieuwe maatregel aan")
    public void deMedewerkerMaaktEenNieuweMaatregelAan() throws Exception
    {
        _selenium.WaitUntilHomepageFullyLoaded();

        _selenium.SetNewImplicitWaitTime(30);

        _werkenService.VerwijderBestaandWerk();

        _werkenService.OpenNieuwWerk();

        _werkenService.CreeerNieuwWerk();

        WebElement werk = _werkenService.VindAangemaakteWerkTerug();

        _fasenService.MaakNieuweFaseAan(werk);

        WebElement fase = _fasenService.GetBestaandeFase();

        _maatregelenService.OpenNieuweMaatregel(fase);

        _maatregelenService.MaakNieuweMaatregelAan();
    }

    @Dan("is de maatregel getoond in het overzicht")
    public void isDeMaatregelGetoondInHetOverzicht() throws Exception
    {
        _selenium.WaitUntilClickableThenClick(Hoofdpagina.KlapMaatregelInformatieOpen);

        assertThat(_selenium.TextInElementMatchesExpectedText(Hoofdpagina.MaatregelSoortWerk, WegData.MaatregelSoortWerk)).isTrue();

        assertThat(_selenium.TextInElementMatchesExpectedText(Hoofdpagina.MaatregelWegVan, WegData.Wegnummer)).isTrue();
    }

    //Stappen voor testgeval 'Route aanpassen bestaande maatregel'
    @En("de medewerker creeert een maatregel onder een bestaande fase")
    public void deMedewerkerCreeertEenMaatregelOnderEenBestaandeFase() throws Exception
    {
        _maatregelenService.OpenNieuweMaatregelOnderbestaandeFase();
    }

    @En("de medewerker past de route handmatig aan")
    public void deMedewerkerPastDeRouteHandmatigAan() throws Exception
    {
        _maatregelenService.WaitUntilMaatregelPageLoaded();
        _maatregelenService.VulRouteIn();
        _selenium.WaitUntilClickableThenClick(ToonRoute);

        //_selenium.SwitchToCurrentScreen();
        _selenium.WaitUntilClickableThenClick(LocatieBewerkenVanWegnummer);

        _selenium.WaitUntilClickableThenClick(ZoomOut);

        Thread.sleep(1000);
        _selenium.ContextClickOnElementBasedOnCoordinates(1300, 570);

        driver.findElement(EindPuntPlaatsen).click();
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ENTER)).perform();

        driver.findElement(LocatieOpslaan).click();
    }

    @Dan("worden de wijzigingen automatisch toegapast op de routedata")
    public void wordenDeWijzigingenAutomatischToegapastOpDeRoutedata() throws Exception
    {
        Boolean TextInElementMatchesExpectedText = _selenium.TextInElementMatchesExpectedText(TotKilometer, WegData.GewijzigdeRouteTotKilometer);

        assertThat(TextInElementMatchesExpectedText).isTrue();
    }

    //Teststappen onder 'Conflict getoond met andere maatregel'
    @En("de medewerker maakt een nieuwe maatregel aan met hetzelfde tijdvak als een bestaande maatregel")
    public void deMedewerkerMaaktEenNieuweMaatregelAanMetHetzelfdeTijdvakAlsEenBestaandeMaatregel() throws Exception
    {
        _selenium.WaitUntilClickableThenClick(Hoofdpagina.KlapEersteWerkOpEerstePaginaOpen);
        _maatregelenService.OpenNieuweMaatregelOnderbestaandeFase();

        _maatregelenService.MaakNieuweMaatregelAan();

        _maatregelenService.OpenNieuweMaatregelOnderbestaandeFase();

        _maatregelenService.EnterTijdvakData();
        _maatregelenService.VulRouteIn();
    }

    @En("de medewerker bekijkt de maatregelen in hetzelfde tijdvak")
    public void deMedewerkerBekijktDeMaatregelenInHetzelfdeTijdvak() throws InterruptedException
    {
        //data wordt alleen de tweede keer van openen getoond...
        _selenium.WaitUntilClickableThenClick(MaatregelInTijdvak);
        _selenium.WaitUntilClickableThenClick(MaatregelInTijdvakSluiten);
        _selenium.WaitUntilClickableThenClick(MaatregelInTijdvak);

        WebElement bekijkMaatregel = driver.findElement(BekijkMaatregel);
        actions.contextClick(bekijkMaatregel).perform();
        actions.sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ENTER)).perform();
    }

    @Dan("ziet de medewerker dat er een conflict is met een andere maatregel in hetzelfde tijdvak")
    public void zietDeMedewerkerDatErEenConflictIsMetEenAndereMaatregelInHetzelfdeTijdvak() throws Exception
    {
        _selenium.WaitUntilClickableThenClick(WegnummerConflict);

        String wegnummer = _selenium.GetTextFromElement(WegnummerConflict);
        assertThat(wegnummer).matches(WegData.Wegnummer);

        String wegzijde = _selenium.GetTextFromElement(WegzijdeConflict);
        assertThat(wegzijde).matches(WegData.Wegzijde);

        String vanKilometer = _selenium.GetTextFromElement(VanKilometerConflict);
        assertThat(vanKilometer).matches(WegData.VanKilometer);
    }
}
