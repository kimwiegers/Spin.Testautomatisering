package Steps;

import Services.DatesAndTimesService;
import Services.SeleniumService;
import TestData.DriverSetup;
import TestData.TestData;
import cucumber.api.java.nl.Dan;
import cucumber.api.java.nl.En;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;

import static PageObjects.Hoofdpagina.*;
import static org.assertj.core.api.Assertions.assertThat;

public class AlgemeneFunctionaliteitenSteps
{
    private final SeleniumService _selenium;
    private final DatesAndTimesService _datesAndTimesService;
    private final TestData _testData;
    private final WebDriver driver;

    public AlgemeneFunctionaliteitenSteps(SeleniumService selenium, DatesAndTimesService datesAndTimesService, DriverSetup driverSetup,
                                          TestData testData)
    {
        driver = driverSetup.getDriver();
        _selenium = selenium;
        _datesAndTimesService = datesAndTimesService;
        _testData = testData;
    }

    //Stappen onder testgeval 'Filteren in overicht'
    @En("de medewerker in het overzicht filtert op momenteel actieve werken in regio {string}")
    public void deMedewerkerInHetOverzichtFiltertOpMomenteelActieveWerkenInRegioMiddenNederland(String regio) throws Exception
    {
        switch (regio.toLowerCase())
        {
            case "midden-nederland":
                _selenium.SelectFromDropdown(RegioDropdown, 4);
                break;
            default:
                throw new Exception(String.format("%s niet geimplementeerd als regio", regio));

        }

        _testData.setRegio(regio.toLowerCase());

        _selenium.WaitUntilClickableThenClick(ActiefVanDropdown);
        _selenium.WaitUntilClickableThenClick(VandaagInKalender);

        _selenium.WaitUntilClickableThenClick(ActiefTotDropdown);
        _selenium.WaitUntilClickableThenClick(VandaagInKalender);

        _selenium.WaitUntilClickableThenClick(FilterToepassen);
    }

    @Dan("zijn alleen de werken, fasen en maatregelen van dat tijdsbestek en die regio getoond")
    public void zijnAlleenDeWerkenFasenEnMaatregelenVanDatTijdsbestekEnDieRegioGetoond() throws Exception
    {
        LocalDate huidigeDatum = LocalDate.now();
        _selenium.WaitUntilHomepageFullyLoaded();

        //Check eerste item
        String begindatumEersteWerkString = _selenium.GetTextFromElement(BegindatumEersteWerk);
        LocalDate begindatumEersteWerk = _datesAndTimesService.TransformStringIntoDate(begindatumEersteWerkString);
        assertThat(begindatumEersteWerk).isBeforeOrEqualTo(huidigeDatum);

        String einddatumEersteWerkString = _selenium.GetTextFromElement(EinddatumEersteWerk);
        LocalDate einddatumEersteWerk = _datesAndTimesService.TransformStringIntoDate(einddatumEersteWerkString);
        assertThat(einddatumEersteWerk).isAfterOrEqualTo(huidigeDatum);

        String aanvragendeDienstRegioEersteWerk = _selenium.GetTextFromElement(AanvragendeDienstEersteWerk).toLowerCase();
        assertThat(aanvragendeDienstRegioEersteWerk).matches(_testData.getRegio());

        //Check tweede item
        String begindatumTweedeWerkString = _selenium.GetTextFromElement(BegindatumTweedeWerk);
        LocalDate begindatumTweedeWerk = _datesAndTimesService.TransformStringIntoDate(begindatumTweedeWerkString);
        assertThat(begindatumTweedeWerk).isBeforeOrEqualTo(huidigeDatum);

        String einddatumTweedeWerkString = _selenium.GetTextFromElement(EinddatumTweedeWerk);
        LocalDate einddatumTweedeWerk = _datesAndTimesService.TransformStringIntoDate(einddatumTweedeWerkString);
        assertThat(einddatumTweedeWerk).isAfterOrEqualTo(huidigeDatum);

        String aanvragendeDienstRegiotweedeWerk = _selenium.GetTextFromElement(AanvragendeDienstTweedewerk).toLowerCase();
        assertThat(aanvragendeDienstRegiotweedeWerk).matches(_testData.getRegio());

        //Check derde item
        String begindatumDerdeWerkString = _selenium.GetTextFromElement(BegindatumDerdeWerk);
        LocalDate begindatumDerdeWerk = _datesAndTimesService.TransformStringIntoDate(begindatumDerdeWerkString);
        assertThat(begindatumDerdeWerk).isBeforeOrEqualTo(huidigeDatum);

        String einddatumDerdeWerkString = _selenium.GetTextFromElement(EinddatumDerdeWerk);
        LocalDate einddatumDerdeWerk = _datesAndTimesService.TransformStringIntoDate(einddatumDerdeWerkString);
        assertThat(einddatumDerdeWerk).isAfterOrEqualTo(huidigeDatum);

        String aanvragendeDienstRegioDerdeWerk = _selenium.GetTextFromElement(AanvragendeDienstDerdeWerk).toLowerCase();
        assertThat(aanvragendeDienstRegioDerdeWerk).matches(_testData.getRegio());
    }
}
