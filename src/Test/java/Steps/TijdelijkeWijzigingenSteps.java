package Steps;

import Services.FileService;
import Services.SeleniumService;
import Services.TijdelijkeWijzigingenService;
import TestData.DriverSetup;
import TestData.TestData;
import TestData.WegData;
import com.opencsv.exceptions.CsvException;
import cucumber.api.java.nl.Dan;
import cucumber.api.java.nl.En;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

import static PageObjects.TijdelijkeWijzigingen.*;
import static org.assertj.core.api.Assertions.assertThat;

public class TijdelijkeWijzigingenSteps {

    private final WebDriver driver;
    private final TijdelijkeWijzigingenService _tijdelijkeWijzigingenService;
    private final SeleniumService _selenium;
    private final TestData _testdata;

    public TijdelijkeWijzigingenSteps(DriverSetup driverSetup, TijdelijkeWijzigingenService tijdelijkeWijzigingenService, SeleniumService selenium, TestData testdata)
    {
        driver = driverSetup.getDriver();
        _tijdelijkeWijzigingenService = tijdelijkeWijzigingenService;
        _selenium = selenium;
        _testdata = testdata;
    }

    @En("de medewerker een nieuwe tijdelijke wijziging opent en alle benodigde informatie geeft")
    public void deMedewerkerEenNieuweTijdelijkeWijzigingOpentEnAlleBenodigdeInformatieGeeft() throws Exception
    {
        _tijdelijkeWijzigingenService.OpenTijdelijkeWijzigingMenu();
        _tijdelijkeWijzigingenService.OpenNieuweTijdelijkeWijziging();
        _tijdelijkeWijzigingenService.VulVerplichteVeldenInVoorEenTijdelijkeWijziging();
    }

    //Stappen bij testgeval 'Verplichte velden tijdelijke wijziging'
    @En("de medewerker laat het verplichte veld {string} leeg")
    public void deMedewerkerLaatHetVerplichteVeldLeeg(String verplichtVeld) throws Exception
    {
        _tijdelijkeWijzigingenService.WisIngevuldeVerplichteVeld(verplichtVeld);
    }


    @Dan("is het niet mogelijk de locatie op te vragen van de tijdelijke wijziging")
    public void isHetNietMogelijkDeLocatieOpTeVragenVanDeTijdelijkeWijziging()
    {
        WebElement zoekLocatieButton = driver.findElement(ZoekLocatie);
        assertThat(zoekLocatieButton.isEnabled()).isTrue();
    }

    //Stappen bij testgeval 'Gegenereerde data bij zoeken naar locatie'
    @Dan("wordt automatisch een naam gegenereerd voor de tijdelijke wijziging")
    public void wordtAutomatischEenNaamGegenereerdVoorDeTijdelijkeWijziging() throws Exception
    {
        String gegenereerdeNaamTijdelijkeWijziging = _selenium.GetTextFromElement(Naam);
        assertThat(gegenereerdeNaamTijdelijkeWijziging).matches(WegData.TijdelijkeWijzigingNaam);
    }

    @En("is de data onder Brondata situatie vooringevuld maar niet bewerkbaar")
    public void isDeDataOnderBrondataSituatieVooringevuldMaarNietBewerkbaar() throws InterruptedException
    {
        assertThat(_selenium.ElementHasContent(RijstrokenBestaand)).isTrue();
        assertThat(_selenium.ElementHasContent(PortalenBestaand)).isTrue();

        assertThat(_selenium.ElementIsEnabled(RijstrokenBestaand)).isFalse();
        assertThat(_selenium.ElementIsEnabled(PortalenBestaand)).isFalse();
    }

    //Stappen bij testgeval 'Zoomfunctie schematische kaart'
    @En("de medewerker volledig uitzoomt op de schematische kaart")
    public void deMedewerkerVolledigUitzoomtOpDeSchematischeKaart()
    {
        for (int i = 0; i < 3; i++)
        {
            WebElement zoomUitknop = driver.findElement(ZoomUitKnop);
            zoomUitknop.click();
        }
    }

    @Dan("is de schematische kaart uitgezoomd")
    public void isDeSchematischeKaartUitgezoomd() throws Exception
    {
        String middelsteKilometerSchaalAanduider = _selenium.GetTextFromElement(MiddelsteKilometerSchaalAanduider);
        String laatsteKilometerSchaalAanduider = _selenium.GetTextFromElement(LaatsteKilometerSchaalAanduider);
        assertThat(middelsteKilometerSchaalAanduider).matches(
                WegData.MiddelsteKilometerSchaalaanduiderVolledigUitgezoomd);
        assertThat(laatsteKilometerSchaalAanduider).matches(
                WegData.LaatsteKilometerSchaalaanduiderVolledigUitgezoomd);
    }

    //Stappen bij testgeval 'Onjuiste rijstrook data ivullen'
    @En("de medewerker onjuiste data invoert over de rijstroken")
    public void deMedewerkerOnjuisteDataInvoertOverDeRijstroken() throws InterruptedException
    {
        Thread.sleep(1000);
        _selenium.EnterDataInputField(RijstrokenNieuw, "N=N=S=");
    }

    @Dan("zijn de onjuiste rijstrookgegevens met rood onderstreept")
    public void zijnDeOnjuisteRijstrookgegevensMetRoodOnderstreept()
    {
        assertThat(_tijdelijkeWijzigingenService.VeldIsRoodOnderstreept(RijstrokenNieuw)).isTrue();
    }

    //Stappen bij testgeval 'Bestaande tijdelijke wijziging bewerken'
    @En("de medewerker een bestaande tijdelijke wijziging selecteert om te bewerken")
    public void deMedewerkerEenBestaandeTijdelijkeWijzigingSelecteertOmTeBewerken() throws Exception
    {
        _tijdelijkeWijzigingenService.OpenTijdelijkeWijzigingMenu();
        _tijdelijkeWijzigingenService.BewerkEersteBestaandeTijdelijkeWijziging();

        //De naam wordt in een property gezet om te kunnen asserten dat de juiste tijdelijke wijziging getoond blijft na bewerken;
        String tijdelijkeWijzigingNaam = _selenium.GetTextFromElement(EersteBestaandeTijdelijkeWijzigingNaam);
        _testdata.setTijdelijkeWijzigingNaam(tijdelijkeWijzigingNaam);
    }

    @Dan("blijft de juiste tijdelijke wijziging geselecteert")
    public void blijftDeJuisteTijdelijkeWijzigingGeselecteert() throws Exception
    {
        String tijdelijkeWijzigingNaam = _selenium.GetTextFromElement(Naam);
        assertThat(tijdelijkeWijzigingNaam).matches(_testdata.getTijdelijkeWijzigingNaam());
    }

    @cucumber.api.java.nl.En("de medewerker maakt een nieuwe tijdelijke wijziging aan")
    public void deMedewerkerMaaktEenNieuweTijdelijkeWijzigingAan() throws Exception
    {
        _tijdelijkeWijzigingenService.OpenTijdelijkeWijzigingMenu();
        _tijdelijkeWijzigingenService.VerwijderBestaandeTestWijzigingen();
        _tijdelijkeWijzigingenService.OpenNieuweTijdelijkeWijziging();
        _tijdelijkeWijzigingenService.VulVerplichteVeldenInVoorEenTijdelijkeWijziging();

        driver.findElement(Bewaren).click();

        //Klik op OK om de maatregelen te accepteren
        Thread.sleep(1300);
        _selenium.ClickOnElementBasedOnCoordinates(BetrokkenMaatregelenAccepterenX, BetrokkenMaatregelenAccepterenY);
    }

    @Dan("is de tijdelijke wijziging aan de tabel Objecten toegevoegd")
    public void isDeTijdelijkeWijzigingAanDeTabelObjectenToegevoegd() throws Exception
    {
        //Sorteer de tijdelijke wijziging op wijzigingsdatum om de nieuwste bovenaan te zien
        _selenium.ClickOnElementBasedOnCoordinates(DatumVanDropdownX, DatumVanDropdownY);
        _selenium.ClickOnElementBasedOnCoordinates(DatumVanAflopendSorterenX, DatumVanAflopendSorterenY);

        String tijdelijkeWijzigingnaam = _selenium.GetTextFromElement(NieuweWijziging);
        assertThat(tijdelijkeWijzigingnaam).matches(WegData.TijdelijkeWijzigingNaam);
    }

    //Stappen bij testgeval 'foutpad - Begindatum na einddatum'
    @En("de medewerker een nieuwe tijdelijke wijziging opent")
    public void deMedewerkerEenNieuweTijdelijkeWijzigingOpent() throws InterruptedException
    {
        _tijdelijkeWijzigingenService.OpenTijdelijkeWijzigingMenu();
        _tijdelijkeWijzigingenService.OpenNieuweTijdelijkeWijziging();
    }

    @En("de medewerker voert een begin- en einddatum in met dezelfde datum")
    public void deMedewerkerVoertEenBeginEnEinddatumInMetDezelfdeDatum() throws InterruptedException
    {
        Thread.sleep(1000);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(DatumTotKalender));
        driver.findElement(DatumTotKalender).click();
        driver.findElement(VandaagInVanKalender).click();

        driver.findElement(DatumVanKalender).click();
        driver.findElement(VandaagInVanKalender).click();
    }

    @Dan("is de onjuiste begindatum met rood onderstreept")
    public void isDeOnjuisteBegindatumMetRoodOnderstreept()
    {
        assertThat(_tijdelijkeWijzigingenService.VeldIsRoodOnderstreept(DatumVan)).isTrue();
    }

    //Stappen voor testgeval 'foutpad - te hoge kilometrage'
    @En("de medewerker voert een te hoge kilometrage in voor de tijdelijke wijziging")
    public void deMedewerkerVoertEenTeHogeKilometrageInVoorDeTijdelijkeWijziging() throws InterruptedException, AWTException
    {
        _tijdelijkeWijzigingenService.VulDetailsIn();
        _selenium.EnterDataInputField(VanKilometer, WegData.VanKilometerTeHogeKilometrage);

        driver.findElement(ZoekLocatie).click();
    }

    @Dan("ziet de klant een pop-up met informatie over de kilometrage")
    public void zietDeKlantEenPopUpMetInformatieOverDeKilometrage()
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(MaximaalKilometrageTekst));
    }

    //Stappen bij testgeval 'Export'
    @En("de medewerker het Tijdelijke Wijzigingen menu opent")
    public void deMedewerkerHetTijdelijkeWijzigingenMenuOpent()
    {
        _tijdelijkeWijzigingenService.OpenTijdelijkeWijzigingMenu();
    }

    @En("de medewerker een export van de tijdeljke wijzigingen maakt in {string}")
    public void deMedewerkerEenExportVanDeTijdeljkeWijzigingenMaaktInFormat(String format) throws Exception
    {
        _tijdelijkeWijzigingenService.FilterTijdelijkeWijzigingen(WegData.Wegnummer, WegData.Wegzijde);

        _tijdelijkeWijzigingenService.ExporteerTijdelijkeWijzigingen(format);
    }

    @Dan("wordt een export gegenereerd in een {string} bestand")
    public void wordtEenExportGegenereerdInEenFormatBestand(String format) throws Exception
    {
        File tijdelijkeWijzigingenExport = new FileService().GetExportedFile();
        String filename = tijdelijkeWijzigingenExport.getName();
        assertThat(filename).contains(format.toLowerCase());

        _testdata.setTijdelijkeWijzigingExportbestand(tijdelijkeWijzigingenExport);
    }

    @En("zijn alleen de gefilterde tijdelijke wijzigingen meegenomen in de export")
    public void zijnAlleenDeGefilterdeTijdelijkeWijzigingenMeegenomenInDeExport() throws Exception
    {
        File tijdelijkeWijzigingenExport = _testdata.getTijdelijkeWijzigingExportbestand();
        String filename = tijdelijkeWijzigingenExport.getName();

        String tijdelijkeWijzigingData = String.format("%s %s", WegData.Wegnummer, WegData.Wegzijde);

        if (filename.toLowerCase().contains("csv"))
        {
            assertThat(new FileService().TextIsPresentInCsvFile(tijdelijkeWijzigingData, tijdelijkeWijzigingenExport)).isTrue();
            assertThat(new FileService().TextIsPresentInCsvFile("A6", tijdelijkeWijzigingenExport)).isFalse();
            assertThat(new FileService().TextIsPresentInCsvFile("A4", tijdelijkeWijzigingenExport)).isFalse();
        }

        else if (filename.toLowerCase().contains("xls"))
        {

        }

        else
        {
            throw new Exception(String.format("geen methode geimplementeerd om data op te halen uit %s", filename));
        }
    }
}
