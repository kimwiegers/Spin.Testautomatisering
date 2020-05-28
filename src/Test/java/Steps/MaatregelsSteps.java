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

import static org.assertj.core.api.Assertions.assertThat;

public class MaatregelsSteps
{
    private final WebDriver driver;
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
    }

    @En("de medewerker maakt een nieuwe maatregel aan")
    public void deMedewerkerMaaktEenNieuweMaatregelAan() throws Exception
    {
        _werkenService.WaitUntilHomepageFullyLoaded();

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
    @En("de medewerker opent een bestaande maatregel")
    public void deMedewerkerOpentEenBestaandeMaatregel() throws InterruptedException
    {
        _werkenService.WaitUntilHomepageFullyLoaded();

        _selenium.WaitUntilClickableThenClick(Hoofdpagina.KlapEersteWerkOpEerstePaginaOpen);

        WebElement fase = driver.findElement(Hoofdpagina.EersteFaseOnderEersteWerkEerstePagina);

        _maatregelenService.OpenNieuweMaatregelOnderbestaandeFase(fase);
    }

    @En("de medewerker past de route handmatig aan")
    public void deMedewerkerPastDeRouteHandmatigAan() throws Exception
    {
        _maatregelenService.VulRouteIn();
        _selenium.WaitUntilClickableThenClick(Maatregel.ToonRoute);

        //_selenium.SwitchToCurrentScreen();
        _selenium.WaitUntilClickableThenClick(Maatregel.LocatieBewerkenVanWegnummer);

        _selenium.WaitUntilClickableThenClick(Maatregel.ZoomOut);

        Thread.sleep(1000);
        _selenium.ContextClickOnElementBasedOnCoordinates(1300, 570);

        driver.findElement(Maatregel.EindPuntPlaatsen).click();
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ENTER)).perform();

        driver.findElement(Maatregel.LocatieOpslaan).click();
    }

    @Dan("worden de wijzigingen automatisch toegapast op de routedata")
    public void wordenDeWijzigingenAutomatischToegapastOpDeRoutedata() throws Exception
    {
        Boolean TextInElementMatchesExpectedText = _selenium.TextInElementMatchesExpectedText(Maatregel.TotKilometer, WegData.GewijzigdeRouteTotKilometer);

        assertThat(TextInElementMatchesExpectedText).isTrue();
    }
}
