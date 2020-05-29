package Steps;

import PageObjects.Hoofdpagina;
import PageObjects.Maatregel;
import Services.FasenService;
import Services.MaatregelenService;
import Services.SeleniumService;
import Services.WerkenService;
import TestData.DriverSetup;
import TestData.TestData;
import TestData.WegData;
import cucumber.api.java.nl.Dan;
import cucumber.api.java.nl.En;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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
    @En("de medewerker opent een nieuwe maatregel onder een bestaande fase")
    public void deMedewerkerOpentEenNieuweMaatregelOnderEenBestaandeFase() throws Exception
    {
        _selenium.WaitUntilClickableThenClick(Hoofdpagina.KlapEersteWerkOpEerstePaginaOpen);
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
    public void deMedewerkerBekijktDeMaatregelenInHetzelfdeTijdvak()
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

    //Teststappen voor testgeval ' Verkeerstop toevoegen aan maatregel'
    @En("de medewerker voegt een verkeersstop toe aan de maatregel")
    public void deMedewerkerVoegtEenVerkeersstopToeAanDeMaatregel() throws Exception
    {
        driver.findElement(VerkeersstopTabblad).click();
        _selenium.WaitUntilClickableThenClick(VerkeersstopAanmaken);

        _selenium.WaitUntilClickableThenClick(NieuweVerkeersstop);

        _selenium.WaitUntilClickableThenClick(Datum);
        _selenium.WaitUntilClickableThenClick(VandaagInVanKalender);

        _selenium.WaitUntilClickableThenClick(Weg);
        actions.sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN,
                Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER)).perform();

        _selenium.WaitUntilClickableThenClick(Zijde);
        actions.sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER)).perform();

        _selenium.EnterDataInputField(Kilometer, WegData.VanKilometer);

        _selenium.WaitUntilClickableThenClick(Duur);
        actions.sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ENTER)).perform();

        _selenium.EnterDataInputField(AantalWISAangevraagd, WegData.AantalWISAangevraagd);

        _selenium.WaitUntilClickableThenClick(AlternatiefMogelijkNee);

        _selenium.EnterDataInputField(ToelichtingAannemer, TestData.Testomschrijving);

        _selenium.WaitUntilElementIsEnabled(Toepassen);
        _selenium.WaitUntilClickableThenClick(Toepassen);

        _selenium.WaitUntilElementIsEnabled(VerkeersstopsSluiten);
        _selenium.WaitUntilClickableThenClick(VerkeersstopsSluiten);
    }

    @Dan("is de verkeersstop te zien in het tabblad Verkeersstop")
    public void isDeVerkeersstopTeZienInHetTabbladVerkeersstop() throws Exception
    {
        //In het tabblad is al te zien dat er een verkeersstop is
        String verkeersstopTabblad = _selenium.GetTextFromElement(VerkeersstopTabblad);
        assertThat(verkeersstopTabblad).contains("Verkeersstop (1)");

        String wegnummer = _selenium.GetTextFromElement(VerkeersstopWegnummer);
        assertThat(wegnummer).matches(WegData.Wegnummer);

        String wegzijde = _selenium.GetTextFromElement(VerkeersstopWegzijde);
        assertThat(wegzijde).matches(WegData.Wegzijde);

        String vanKilometer = _selenium.GetTextFromElement(VerkeersstopVanKilometer);
        assertThat(vanKilometer).matches(WegData.VanKilometer);
    }

    //Stappen onder testgeval 'Omleiding toevoegen aan een maatregel'
    @En("de medewerker voegt een omleiding toe aan de maatregel")
    public void deMedewerkerVoegtEenOmleidingToeAanDeMaatregel() throws Exception
    {
        _maatregelenService.WaitUntilMaatregelPageLoaded();
        _selenium.SetNewImplicitWaitTime(15);

        _maatregelenService.VulRouteIn();
        Thread.sleep(500);

        _selenium.WaitUntilClickableThenClick(OmleidingTabblad);
        _selenium.WaitUntilClickableThenClick(OmleidingToevoegen);
        _selenium.WaitUntilClickableThenClick(NieuweOmleiding);

        driver.findElement(OmleidingWegnummerVan).clear();
        _selenium.WaitUntilClickableThenClick(OmleidingWegummerVanDropdown);
        actions.sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN,
                Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER)).perform();
        actions.sendKeys(Keys.ENTER).perform();

        driver.findElement(OmleidingWegnummerTot).clear();
        _selenium.WaitUntilClickableThenClick(OmleidingWegnummerTotDropdown);
        actions.sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN,
                Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER)).perform();
        actions.sendKeys(Keys.ENTER).perform();

        driver.findElement(OmleidingWegzijdeVan).clear();
        _selenium.WaitUntilClickableThenClick(OmleidingWegzijdeVanDropdown);
        actions.sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ENTER)).perform();
        actions.sendKeys(Keys.ENTER).perform();

        driver.findElement(OmleidingWegzijdeTot).clear();
        _selenium.WaitUntilClickableThenClick(OmleidingWegzijdeTotDropdown);
        actions.sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ENTER)).perform();
        actions.sendKeys(Keys.ENTER).perform();

        Thread.sleep(500);
        _selenium.EnterDataInputField(OmleidingVanKilometer, WegData.VanKilometer);
        _selenium.EnterDataInputField(OmleidingTotKilometer, WegData.OmleidingTotKilometer);

        _selenium.WaitUntilClickableThenClick(OmleidingAanmakenOmleidingVan);
        actions.sendKeys(Keys.chord(Keys.ENTER)).perform();

        _selenium.WaitUntilClickableThenClick(OmleidingAanmakenOmleidingTot);
        actions.sendKeys(Keys.chord(Keys.ENTER)).perform();

        _selenium.WaitUntilClickableThenClick(OmvangRouteKleinschalig);
        _selenium.WaitUntilClickableThenClick(SoortRouteAdviesroute);
        _selenium.EnterDataInputField(OmleidingAanmakenVolgRoute, TestData.Testomschrijving);

        _selenium.ContextClickOnElementBasedOnCoordinates(SchematischeKaartX, SchematischeKaartY);
        actions.sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER)).perform();

        _selenium.WaitUntilElementIsEnabled(OmleidingToepassen);
        _selenium.WaitUntilClickableThenClick(OmleidingToepassen);

        _selenium.WaitUntilElementIsEnabled(OmleidingSluiten);
        _selenium.WaitUntilClickableThenClick(OmleidingSluiten);
    }

    @Dan("is de omleiding te zien in het tabblad Omleiding")
    public void isDeOmleidingTeZienInHetTabbladOmleiding() throws Exception
    {

        String omleidingVan = _selenium.GetTextFromElement(OmleidingVan);
        assertThat(omleidingVan).matches(WegData.OmleidingVanPlek);

        String omleidingTot = _selenium.GetTextFromElement(OmleidingTot);
        assertThat(omleidingTot).matches(WegData.OmleidingTotPlek);

        String volgRoute = _selenium.GetTextFromElement(VolgRoute);
        assertThat(volgRoute).matches(TestData.Testomschrijving);
    }
}
