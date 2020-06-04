package Steps;

import PageObjects.Hoofdpagina;
import Services.*;
import TestData.DriverSetup;
import TestData.TestData;
import TestData.WegData;
import TestData.GebruikersData;
import com.opencsv.exceptions.CsvException;
import cucumber.api.java.nl.Als;
import cucumber.api.java.nl.Dan;
import cucumber.api.java.nl.En;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import static PageObjects.Maatregel.*;
import static org.assertj.core.api.Assertions.assertThat;

public class MaatregelsSteps
{
    private final WebDriver driver;
    private final Actions actions;
    private final WerkenService _werkenService;
    private final FasenService _fasenService;
    private final MaatregelenService _maatregelenService;
    private final StandaardOmleidingenService _standaardOmleidingenService;
    private final SeleniumService _selenium;
    private final SpinService _spinService;
    private final DatesAndTimesService _datesAndTimesService;
    private final TestData _testData;
    private final WebDriverWait wait;

    public MaatregelsSteps(DriverSetup driverSetup, WerkenService werkenService, FasenService fasenService,
                           SeleniumService selenium, MaatregelenService maatregelenService, StandaardOmleidingenService
                           standaardOmleidingenService, SpinService spinService,
                           DatesAndTimesService datesAndTimesService,
                           TestData testData)
    {
        driver = driverSetup.getDriver();
        _werkenService = werkenService;
        _fasenService = fasenService;
        _maatregelenService = maatregelenService;
        _standaardOmleidingenService = standaardOmleidingenService;
        _spinService = spinService;
        _selenium = selenium;
        _datesAndTimesService = datesAndTimesService;
        _testData = testData;
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, 10);
    }

    @En("de medewerker een nieuwe maatregel aanmaakt en deze sluit")
    public void deMedewerkerEenNieuweMaatregelAanmaaktEnDezeSluit() throws Exception
    {
        _selenium.WaitUntilHomepageFullyLoaded();

        _selenium.SetNewImplicitWaitTime(30);

        _werkenService.VerwijderBestaandWerk();

        _werkenService.OpenNieuwWerk();

        _werkenService.CreeerNieuwWerk();

        WebElement werk = _werkenService.VindAangemaakteWerkTerug();

        _fasenService.MaakNieuweFaseAan(werk);

        _maatregelenService.OpenNieuweMaatregel();

        _maatregelenService.MaakNieuweMaatregelAan(0, 7);

        _maatregelenService.SluitNieuweBewaardeMaatregel();
    }

    @Dan("is de maatregel getoond in het overzicht")
    public void isDeMaatregelGetoondInHetOverzicht() throws Exception
    {
        _selenium.WaitUntilClickableThenClick(Hoofdpagina.KlapMaatregelInformatieOpen);

        assertThat(_selenium.TextInElementContainsExpectedText(Hoofdpagina.MaatregelSoortWerk, WegData.MaatregelSoortWerk)).isTrue();

        assertThat(_selenium.TextInElementContainsExpectedText(Hoofdpagina.MaatregelWegVan, WegData.Wegnummer)).isTrue();
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
        Boolean TextInElementMatchesExpectedText = _selenium.TextInElementContainsExpectedText(TotKilometer, WegData.GewijzigdeRouteTotKilometer);

        assertThat(TextInElementMatchesExpectedText).isTrue();
    }

    //Teststappen onder 'Conflict getoond met andere maatregel'
    @En("de medewerker maakt een nieuwe maatregel aan met hetzelfde tijdvak als een bestaande maatregel")
    public void deMedewerkerMaaktEenNieuweMaatregelAanMetHetzelfdeTijdvakAlsEenBestaandeMaatregel() throws Exception
    {
        _selenium.WaitUntilClickableThenClick(Hoofdpagina.KlapEersteWerkOpEerstePaginaOpen);
        _maatregelenService.OpenNieuweMaatregelOnderbestaandeFase();

        _maatregelenService.MaakNieuweMaatregelAan(0, 7);

        _maatregelenService.OpenNieuweMaatregelOnderbestaandeFase();

        _maatregelenService.EnterTijdvakData(0, 7);
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

    //Stappen onder testgeval 'standaard omleiding toevoegen aan maatregel
    @En("er is een standaard omleiding aanwezig")
    public void erIsEenStandaardOmleidingAanwezig() throws Exception
    {
        _spinService.LogIn("interne gui");

        _standaardOmleidingenService.OpenStandaardOmleidingenMenu();

        boolean standaardOmleidingIsAanwezig = _standaardOmleidingenService.StandaardOmleidingIsAanwezig();

        if (!standaardOmleidingIsAanwezig)
        {
            _standaardOmleidingenService.CreeerNieuweStandaardOmleiding();
        }

        _spinService.ReturnToHomepage();
    }

    @En("de medewerker voegt een standaard omleiding toe aan de maatregel")
    public void deMedewerkerVoegtEenStandaardOmleidingToeAanDeMaatregel() throws Exception
    {

        _maatregelenService.AddStandaardOmleidingTomaatregel();
    }

    //Stappen onder testgeval 'versionering maatregel'
    @En("de medewerker een nieuwe maatregel aanmaakt en deze geopend houdt")
    public void deMedewerkerEenNieuweMaatregelAanmaaktEnDezeGeopendHoudt() throws Exception
    {
        _selenium.WaitUntilHomepageFullyLoaded();

        _selenium.SetNewImplicitWaitTime(30);

        _werkenService.VerwijderBestaandWerk();

        _werkenService.OpenNieuwWerk();

        _werkenService.CreeerNieuwWerk();

        WebElement werk = _werkenService.VindAangemaakteWerkTerug();

        _fasenService.MaakNieuweFaseAan(werk);

        _maatregelenService.OpenNieuweMaatregel();

        _maatregelenService.MaakNieuweMaatregelAan(0, 7);
    }

    @En("de medewerker wijzigingen aanbrengt en de maatregel opnieuw opslaat")
    public void deMedewerkerWijzigingenAanbrengtEnDeMaatregelOpnieuwOpslaat() throws Exception
    {
        _selenium.WaitUntilClickableThenClick(FilegevoeligJa);

        _selenium.WaitUntilElementIsEnabled(Bewaren);
        _selenium.WaitUntilClickableThenClick(Bewaren);
    }

    @Dan("is het versienummer van de maatregel opgehoogd")
    public void isHetVersienummerVanDeMaatregelOpgehoogd() throws Exception
    {
        boolean versienummer2AanwezigInVersie = _selenium.TextInElementContainsExpectedText(Versienummer, "V2");
        assertThat(versienummer2AanwezigInVersie).isTrue();

        boolean gebruikersnaamAanwezigInVersie =
                _selenium.TextInElementContainsExpectedText(Versienummer, GebruikersData.Gebruiker);
        assertThat(gebruikersnaamAanwezigInVersie).isTrue();
    }

    @Als("de medewerker navigeert naar de vorige versie van de maatregel")
    public void deMedewerkerNavigeertNaarDeVorigeVersieVanDeMaatregel()
    {
        _selenium.WaitUntilClickableThenClick(NavigeerNaarVorigeVersie);
    }

    @Dan("wordt de vorige versie getoond")
    public void wordtDeVorigeVersieGetoond() throws InterruptedException
    {
        Thread.sleep(1000);
        WebElement fileGevoeligNee = driver.findElement(FilegevoeligNee);
        boolean fileGevoeligNeeIsAangevinkt = _selenium.isAttributePresent(fileGevoeligNee, "checked");
        assertThat(fileGevoeligNeeIsAangevinkt).isTrue();
    }

    /*    @En("worden de wijzigingen blauw onderstreept")
    public void wordenDeWijzigingenBlauwOnderstreept()
    {
        WebElement fileGevoeligJaFrame = driver.findElement(FilegevoeligJaFrame);
        boolean filegevoeligJaFrameIsBlauw = _selenium.isAttributePresent(FilegevoeligJaFrame, "x-form-item-framed");
        assertThat(filegevoeligJaFrameIsBlauw).isTrue();
    }*/

    //Stappen onder testgeval 'Maatregel goedkeuren'
    @En("de medewerker de maatregel beoordeelt en hierbij de schematische kaart bekijkt")
    public void deMedewerkerDeMaatregelBeoordeeltEnHierbijDeSchematischeKaartBekijkt()
    {
        _selenium.WaitUntilClickableThenClick(Beoordelen);

        _selenium.WaitUntilClickableThenClick(SchematischeKaart);

        _selenium.SwitchToCurrentScreen();
    }

    @Dan("toont de schematische kaart de juiste maatregel")
    public void toontDeSchematischeKaartDeJuisteMaatregel() throws Exception
    {
        _selenium.SetNewImplicitWaitTime(20);
        String maatregelData =
                WegData.Wegnummer + " " + WegData.Wegzijde + " " + WegData.VanKilometer + " - " + WegData.Wegnummer + " " + WegData.Wegzijde + " " + WegData.TotKilometer;
        _selenium.TextInElementContainsExpectedText(Maatregeldata, maatregelData);

        driver.close();
    }

    @Als("de medewerker de maatregel indient")
    public void deMedewerkerDeMaatregelIndient()
    {
        _selenium.SwitchToCurrentScreen();

        _selenium.WaitUntilClickableThenClick(Volgende);
        _selenium.WaitUntilClickableThenClick(Volgende);
        _selenium.WaitUntilClickableThenClick(Volgende);
        _selenium.WaitUntilClickableThenClick(Goedkeuren);

        _selenium.SwitchToCurrentScreen();
    }

    @Dan("is de status van de maatregel aangepast naar Goedgekeurd")
    public void isDeStatusVanDeMaatregelAangepastNaarGoedgekeurd() throws Exception
    {
        String status = _selenium.GetTextFromElement(Status);
        assertThat(status).matches("Goedgekeurd / gepland");
    }

    //Stappen onder testgeval 'Toevoegingen in schematische kaart'
    @En("de medewerker de schematische kaart opent")
    public void deMedewerkerDeSchematischeKaartOpent() throws Exception
    {
        _selenium.WaitUntilClickableThenClick(SchematischeKaart);
    }

    @En("de medewerker informatieborden en matrixsignaalgevers toevoegt aan de schematische kaart")
    public void deMedewerkerInformatiebordenEnMatrixsignaalgeversToevoegtAanDeSchematischeKaart() throws AWTException, InterruptedException
    {
        _selenium.SetNewImplicitWaitTime(20);
        _selenium.SwitchToCurrentScreen();

        _selenium.WaitUntilClickableThenClick(KaartBewerken);

        _selenium.WaitUntilClickableThenClick(Pictogrammen);
        _selenium.WaitUntilClickableThenClick(ZestigBord);
        _selenium.ClickOnElementBasedOnCoordinates(MatrixSignaalgeverX, MatrixSignaalgeverY);

        _selenium.WaitUntilClickableThenClick(BordPlaatsen);
        _selenium.ClickOnElementBasedOnCoordinates(LocatieOmBordTePlaatsenX, LocatieOmBordTePlaatsenY);

        _selenium.WaitUntilClickableThenClick(Informatieborden);
        _selenium.WaitUntilClickableThenClick(RechtsInvoegenBord);
        Thread.sleep(500);
        _selenium.ClickOnElementBasedOnCoordinates(LocatieOmRechtsInvoegenBordTePlaatsenX, LocatieOmRechtsInvoegenBordTePlaatsenY);
        Thread.sleep(1000);
    }

    @Dan("zijn de wijzigingen aan de schematische kaart opgeslagen")
    public void zijnDeWijzigingenAanDeSchematischeKaartOpgeslagen() throws Exception
    {
        _selenium.WaitUntilClickableThenClick(KaartOpslaan);

        boolean opslaanTekst = _selenium.TextInElementContainsExpectedText(KaartOpslaanBevestigenTekst, "Schematische" +
                " " +
                "kaart is bewaard!");
        assertThat(opslaanTekst).isTrue();
        _selenium.WaitUntilClickableThenClick(KaartOpslaanBevestigen);
    }

    //Stappen onder testgeval 'Verkeersstop toevoegen aan maatregel en exporteren
    @Als("de medewerker een export maakt van de verkeersstop")
    public void deMedewerkerEenExportMaaktVanDeVerkeersstop()
    {
        _selenium.WaitUntilClickableThenClick(VerkeersstopExporteren);
    }

    @En("komt de data overeen met de aangemaakte verkeersstop")
    public void komtDeDataOvereenMetDeAangemaakteVerkeersstop() throws IOException, CsvException
    {
        File export = _testData.getExportbestand();

        String verkeersstopData = String.format("\"%s\";\"%s\";\"%s\"", WegData.Wegnummer, WegData.Wegzijde, WegData.VanKilometer);

        assertThat(new FileService().TextIsPresentInCsvFile(verkeersstopData, export)).isTrue();
    }

    //Stappen onder testgeval 'Maatregel starten'
    @En("de medewerker de bestaande maatregel start")
    public void deMedewerkerDeBestaandeMaatregelStart() throws AWTException
    {
        _selenium.SwitchToCurrentScreen();
        _selenium.ClickOnElementBasedOnCoordinates(Hoofdpagina.KlapEersteFaseOnderEersteWerkOpenX, Hoofdpagina.KlapEersteFaseOnderEersteWerkOpenY);
        _selenium.ClickOnElementBasedOnCoordinates(Hoofdpagina.EersteMaatregelOnderEersteFaseX, Hoofdpagina.EersteMaatregelOnderEersteFaseY);

        driver.findElement(Hoofdpagina.StartMaatregel).click();
    }

    //Stappen onder testgeval 'Actieve maatregel voorbij einddatum'
    //TODO dit kan een beforestap worden met DB aanpassingen
    @En("er is een maatregel aanwezig met een einddatum in het verleden en de status In uitvoering")
    public void erIsEenMaatregelAanwezigMetEenEinddatumInHetVerledenEnDeStatusInUitvoering() throws Exception
    {
        _spinService.LogIn("interne gui");

        _selenium.WaitUntilHomepageFullyLoaded();

        _selenium.SetNewImplicitWaitTime(30);

        _werkenService.VerwijderBestaandWerk();

        _werkenService.OpenNieuwWerk();

        _werkenService.CreeerNieuwWerk();

        WebElement werk = _werkenService.VindAangemaakteWerkTerug();

        _fasenService.MaakNieuweFaseAan(werk);

        _maatregelenService.OpenNieuweMaatregel();

        _maatregelenService.MaakNieuweMaatregelAan(-14, -7);

        _maatregelenService.SluitNieuweBewaardeMaatregel();

        _selenium.SwitchToCurrentScreen();

        _selenium.ClickOnElementBasedOnCoordinates(Hoofdpagina.KlapEersteFaseOnderEersteWerkOpenX, Hoofdpagina.KlapEersteFaseOnderEersteWerkOpenY);
        _selenium.ClickOnElementBasedOnCoordinates(Hoofdpagina.EersteMaatregelOnderEersteFaseX, Hoofdpagina.EersteMaatregelOnderEersteFaseY);
        driver.findElement(Hoofdpagina.StartMaatregel).click();


        //TODO bug: foutmelding bij starten maatregel in t verleden
        if (driver.findElements(Hoofdpagina.FoutmeldingMaatregelStartenInHetVerleden).size() >= 1)
        {
            driver.findElement(Hoofdpagina.FoutmeldingMaatregelStartenInHetVerleden).click();
        }
    }

    @Als("de medewerker de maatregel bekijkt in het overzicht")
    public void deMedewerkerDeMaatregelBekijktInHetOverzicht() throws AWTException
    {
        // Geen code omdat beforescenario niet goed verwerkt kon worden met DB inserts dus er is al ingelogd etc.
    }

    @Dan("is het icoon van de maatregel rood gekleurd")
    public void isHetIcoonVanDeMaatregelRoodGekleurd() throws Exception
    {
        WebElement icoon = driver.findElement(Hoofdpagina.EersteMaatregelIcoon);
        String attribute = _selenium.getAttributeValue(icoon, "Style");

        assertThat(attribute).contains("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAYAAAAf8" +
                "/9hAAAAeUlEQVR42mNgGBTgT1bO/zdMLERjkHoUA7AqmjXn/59ff8A0NnmCBsAMwSVHnAFAF9DfgD9uLv//LFry/4+fDyQMQDSIDxQnzgA9HXjggemyEggNFCfOACERiAYQPnQEwQaKEx0GcOfDMJBPciAihwHBQKQ4JQ5tAAApt0d72h5/kwAAAABJRU5ErkJggg==");
    }

    //Stappen onder testgeval 'Maatregel beeindigen'
    @En("er is een maatregel aanwezig met de status In uitvoering")
    public void erIsEenMaatregelAanwezigMetDeStatusInUitvoering() throws Exception
    {
        _spinService.LogIn("interne gui");

        _selenium.WaitUntilHomepageFullyLoaded();

        _selenium.SetNewImplicitWaitTime(30);

        _werkenService.VerwijderBestaandWerk();

        _werkenService.OpenNieuwWerk();

        _werkenService.CreeerNieuwWerk();

        WebElement werk = _werkenService.VindAangemaakteWerkTerug();

        _fasenService.MaakNieuweFaseAan(werk);

        _maatregelenService.OpenNieuweMaatregel();

        _maatregelenService.MaakNieuweMaatregelAan(0, 7);

        _maatregelenService.SluitNieuweBewaardeMaatregel();

        _selenium.SwitchToCurrentScreen();

        _selenium.ClickOnElementBasedOnCoordinates(Hoofdpagina.KlapEersteFaseOnderEersteWerkOpenX, Hoofdpagina.KlapEersteFaseOnderEersteWerkOpenY);
        _selenium.ClickOnElementBasedOnCoordinates(Hoofdpagina.EersteMaatregelOnderEersteFaseX, Hoofdpagina.EersteMaatregelOnderEersteFaseY);
        driver.findElement(Hoofdpagina.StartMaatregel).click();

        Thread.sleep(1000);
        if (driver.findElements(By.xpath("/html/body/div[6]/div[2]/div[1]/div/div/div/div/div[2]/div/table[2]/tbody/tr[2]/td[2]/em/button")).size() >= 1)
        {
            driver.findElement(By.xpath("/html/body/div[6]/div[2]/div[1]/div/div/div/div/div[2]/div/table[2]/tbody/tr[2]/td[2]/em/button")).click();
        }
    }

    @Als("de medewerker de maatregel beeindigt")
    public void deMedewerkerDeMaatregelBeeindigt()
    {
        _selenium.WaitUntilClickableThenClick(Hoofdpagina.BeeindigMaatregel);
    }

    @Dan("is de status van de maatregel veranderd naar {string}")
    public void isDeStatusVanDeMaatregelVeranderdNaarGerealiseerd(String status) throws Exception
    {
        _selenium.TextInElementContainsExpectedText(Hoofdpagina.EersteMaatregelStatus, status.toLowerCase());
    }

    //Stappen onder testgeval 'Maatregel op Niet uitgevoerd zetten'
    @Als("de medewerker de maatregel op niet uitgevoerd zet")
    public void deMedewerkerDeMaatregelOpNietUitgevoerdZet() throws AWTException
    {
        _selenium.ClickOnElementBasedOnCoordinates(Hoofdpagina.EersteMaatregelOnderEersteFaseX, Hoofdpagina.EersteMaatregelOnderEersteFaseY);
        _selenium.WaitUntilClickableThenClick(Hoofdpagina.ZetMaatregelOpNietUitgevoerd);

        _selenium.EnterDataInputField(Hoofdpagina.OpmerkingenveldMaatregelNietUitgevoerd, TestData.Testomschrijving);
        _selenium.WaitUntilClickableThenClick(Hoofdpagina.MaatregelNietUitgevoerdBevestiging);
    }
}
