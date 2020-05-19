package Steps;

import TestData.TestData;
import PageObjects.TijdelijkeWijzigingen;
import Services.SeleniumService;
import Services.TijdelijkeWijzigingenService;
import TestData.DriverSetup;
import TestData.WegData;
import cucumber.api.java.nl.Dan;
import cucumber.api.java.nl.En;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.awt.*;

import static org.assertj.core.api.Assertions.*;

public class TijdelijkeWijzigingenSteps {

    private final WebDriver driver;
    private final TijdelijkeWijzigingenService _tijdelijkeWijzigingen;
    private final SeleniumService _selenium;
    private final TestData _testdata;

    public TijdelijkeWijzigingenSteps(DriverSetup driverSetup, TijdelijkeWijzigingenService tijdelijkeWijzigingen, SeleniumService selenium, TestData testdata)
    {
        driver = driverSetup.getDriver();
        _tijdelijkeWijzigingen = tijdelijkeWijzigingen;
        _selenium = selenium;
        _testdata = testdata;
    }

    @cucumber.api.java.nl.En("de medewerker maakt een nieuwe tijdelijke wijziging aan")
    public void deMedewerkerMaaktEenNieuweTijdelijkeWijzigingAan() throws Exception
    {
        _tijdelijkeWijzigingen.OpenTijdelijkeWijzigingMenu();

        _tijdelijkeWijzigingen.VulVerplichteVeldenInVoorEenTijdelijkeWijziging();
    }

    //Stappen bij testgeval 'Verplichte velden tijdelijke wijziging'
    @En("de medewerker laat het verplichte veld {string} leeg")
    public void deMedewerkerLaatHetVerplichteVeldLeeg(String verplichtVeld) throws Exception
    {
        _tijdelijkeWijzigingen.WisIngevuldeVerplichteVeld(verplichtVeld);
    }


    @Dan("is het niet mogelijk de locatie op te vragen van de tijdelijke wijziging")
    public void isHetNietMogelijkDeLocatieOpTeVragenVanDeTijdelijkeWijziging()
    {
        WebElement zoekLocatieButton = driver.findElement(TijdelijkeWijzigingen.ZoekLocatie);
        assertThat(zoekLocatieButton.isEnabled()).isTrue();
    }

    //Stappen bij testgeval 'Gegenereerde data bij zoeken naar locatie'
    @Dan("wordt automatisch een naam gegenereerd voor de tijdelijke wijziging")
    public void wordtAutomatischEenNaamGegenereerdVoorDeTijdelijkeWijziging() throws Exception
    {
        String gegenereerdeNaamTijdelijkeWijziging = _selenium.GetTextFromElement(TijdelijkeWijzigingen.Naam);
        assertThat(gegenereerdeNaamTijdelijkeWijziging).matches(WegData.GeneratedTextInNaamField);
    }

    @En("is de data onder Brondata situatie vooringevuld maar niet bewerkbaar")
    public void isDeDataOnderBrondataSituatieVooringevuldMaarNietBewerkbaar() throws InterruptedException
    {
        assertThat(_selenium.ElementHasContent(TijdelijkeWijzigingen.RijstrokenBestaand)).isTrue();
        assertThat(_selenium.ElementHasContent(TijdelijkeWijzigingen.PortalenBestaand)).isTrue();

        assertThat(_selenium.ElementIsEnabled(TijdelijkeWijzigingen.RijstrokenBestaand)).isFalse();
        assertThat(_selenium.ElementIsEnabled(TijdelijkeWijzigingen.PortalenBestaand)).isFalse();
    }

    //Stappen bij testgeval 'Zoomfunctie schematische kaart'
    @En("de medewerker volledig uitzoomt op de schematische kaart")
    public void deMedewerkerVolledigUitzoomtOpDeSchematischeKaart()
    {
        for (int i = 0; i < 3; i++)
        {
            WebElement zoomUitknop = driver.findElement(TijdelijkeWijzigingen.ZoomUitKnop);
            zoomUitknop.click();
        }
    }

    @Dan("is de schematische kaart uitgezoomd")
    public void isDeSchematischeKaartUitgezoomd() throws Exception
    {
        String middelsteKilometerSchaalAanduider = _selenium.GetTextFromElement(TijdelijkeWijzigingen.MiddelsteKilometerSchaalAanduider);
        String laatsteKilometerSchaalAanduider = _selenium.GetTextFromElement(TijdelijkeWijzigingen.LaatsteKilometerSchaalAanduider);
        assertThat(middelsteKilometerSchaalAanduider).matches(
                WegData.MiddelsteKilometerSchaalaanduiderVolledigUitgezoomd);
        assertThat(laatsteKilometerSchaalAanduider).matches(
                WegData.LaatsteKilometerSchaalaanduiderVolledigUitgezoomd);
    }

    //Stappen bij testgeval 'Onjuiste rijstrook data ivullen'
    @En("de medewerker onjuiste data invoert over de rijstroken")
    public void deMedewerkerOnjuisteDataInvoertOverDeRijstroken()
    {
        _selenium.EnterDataInputField(TijdelijkeWijzigingen.RijstrokenNieuw, "N=N=S=");
    }

    @Dan("zijn de onjuiste rijstrookgegevens met rood onderstreept")
    public void zijnDeOnjuisteRijstrookgegevensMetRoodOnderstreept()
    {
      WebElement rijstroken = driver.findElement(TijdelijkeWijzigingen.RijstrokenNieuw);
      assertThat(rijstroken.getAttribute("class").contains("x-form-invalid")).isTrue();
    }

    //Stappen bij testgeval 'Bestaande tijdelijke wijziging bewerken'
    @En("de medewerker een bestaande tijdelijke wijziging selecteert om te bewerken")
    public void deMedewerkerEenBestaandeTijdelijkeWijzigingSelecteertOmTeBewerken() throws Exception
    {
        _tijdelijkeWijzigingen.OpenTijdelijkeWijzigingMenu();
        _tijdelijkeWijzigingen.BewerkEersteBestaandeTijdelijkeWijziging();

        //De naam wordt in een property gezet om te kunnen asserten dat de juiste tijdelijke wijziging getoond blijft na bewerken;
        String tijdelijkeWijzigingNaam = _selenium.GetTextFromElement(TijdelijkeWijzigingen.EersteBestaandeTijdelijkeWijzigingNaam);
        _testdata.setTijdelijkeWijzigingNaam(tijdelijkeWijzigingNaam);
    }

    @Dan("blijft de juiste tijdelijke wijziging geselecteert")
    public void blijftDeJuisteTijdelijkeWijzigingGeselecteert() throws Exception
    {
        String tijdelijkeWijzigingNaam = _selenium.GetTextFromElement(TijdelijkeWijzigingen.Naam);
        assertThat(tijdelijkeWijzigingNaam).matches(_testdata.getTijdelijkeWijzigingNaam());
    }



    @En("de medewerker de tijdelijke wijzigingsdata invult")
    public void deMedewerkerDeTijdelijkeWijzigingsdataInvult() throws AWTException
    {
        _selenium.EnterDataInputField(TijdelijkeWijzigingen.RijstrokenNieuw, WegData.NieuweRijstrookData);
        _selenium.EnterDataInputField(TijdelijkeWijzigingen.Signaalgevers, WegData.NieuweSignaalgevers);
        _selenium.EnterDataInputField(TijdelijkeWijzigingen.Beschrijving, WegData.Beschrijving);

        //Klik op de plus knop om portalen toe te voegen
        _selenium.ClickOnElementBasedOnCoordinates(1425, 575);
        driver.findElement(TijdelijkeWijzigingen.VoegPortalenToeOkKnop).click();

        driver.findElement(TijdelijkeWijzigingen.Actualiseren).click();
    }
}
