package Steps;

import PageObjects.Rapportage;
import Services.FileService;
import Services.SeleniumService;
import TestData.DriverSetup;
import TestData.TestData;
import cucumber.api.java.nl.Dan;
import cucumber.api.java.nl.En;
import org.openqa.selenium.WebDriver;

import java.io.File;

import static PageObjects.Hoofdpagina.Extra;
import static PageObjects.Rapportage.*;
import static org.assertj.core.api.Assertions.assertThat;

public class RapportageSteps
{
    private final SeleniumService _selenium;
    private final WebDriver driver;
    private final TestData _testData;

    public RapportageSteps(DriverSetup driverSetup, SeleniumService selenium, TestData testData)
    {
        driver = driverSetup.getDriver();
        _selenium = selenium;
        _testData = testData;
    }

    @En("de medewerker navigeert naar het Rapportage menu")
    public void deMedewerkerNavigeertNaarHetRapportageMenu()
    {
        _selenium.SelectFromDropdown(Extra, 5);
    }

    @En("de medewerker genereert een rapportage van de verkeersstops van de regio {string}")
    public void deMedewerkerGenereertEenRapportageVanDeVerkeersstopsVanDeRegioMiddenNederland(String regio) throws Exception
    {
        _selenium.WaitUntilClickableThenClick(VerkeersstopsDetails);
        _selenium.WaitUntilClickableThenClick(AlleVerkeersstops);

        switch (regio.toLowerCase())
        {
            case "midden-nederland":
                _selenium.WaitUntilClickableThenClick(MNDistrictNoord);
                _selenium.WaitUntilClickableThenClick(RegioToevoegenAanRapportage);
                _selenium.WaitUntilClickableThenClick(MNDistrictZuid);
                _selenium.WaitUntilClickableThenClick(RegioToevoegenAanRapportage);
                break;
            default:
                throw new Exception(String.format("%s niet geimplemnteerd als regio", regio));
        }

        _testData.setRegio(regio.toLowerCase());

        _selenium.WaitUntilClickableThenClick(StatusGoedgekeurd);
        _selenium.WaitUntilClickableThenClick(StatusToevoegenAanRapportage);

        _selenium.WaitUntilClickableThenClick(BegindatumVerkeersstop);
        _selenium.WaitUntilClickableThenClick(VandaagInKalender);
        _selenium.WaitUntilClickableThenClick(EinddatumVerkeersstop);
        _selenium.ClickOnElementBasedOnCoordinates(LaatstmogelijkeEinddatumX, LaatstMogelijkeEinddatumY);

        _selenium.WaitUntilClickableThenClick(VerzendRapportage);
    }

    @Dan("wordt een csv bestand gegenereert met alle data van de bestaande verkeersstops")
    public void wordtEenCsvBestandGegenereertMetAlleDataVanDeBestaandeVerkeersstops() throws Exception
    {
        File export = new FileService().GetExportedFile("spinTrafficStop");
        String filename = export.getName();
        assertThat(filename).contains("spinTrafficStop.csv");
    }
}
