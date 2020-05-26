package Services;

import PageObjects.Hoofdpagina;
import TestData.DriverSetup;
import TestData.WegData;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;

import static PageObjects.TijdelijkeWijzigingen.*;

public class TijdelijkeWijzigingenService
{
    private final WebDriver driver;
    private final SeleniumService _selenium;

    public TijdelijkeWijzigingenService(DriverSetup driverSetup, SeleniumService selenium)
    {
        driver = driverSetup.getDriver();
        _selenium = selenium;
    }

    public void OpenTijdelijkeWijzigingMenu()
    {
        Actions actions = new Actions(driver);
        WebElement configuratie = driver.findElement(Hoofdpagina.Configuratie);
        configuratie.click();

        //Dit is de enige manier om te navigeren in het menu
        actions.sendKeys((Keys.chord(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN,
                Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_RIGHT, Keys.ARROW_DOWN, Keys.ENTER)))
                .perform();
    }

    public void OpenNieuweTijdelijkeWijziging()
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(Nieuw));
        driver.findElement(Nieuw).click();
    }

    public void VulVerplichteVeldenInVoorEenTijdelijkeWijziging() throws InterruptedException, AWTException
    {
        VulDetailsIn();
        driver.findElement(ZoekLocatie).click();

        _selenium.EnterDataInputField(RijstrokenNieuw, WegData.NieuweRijstrookData);
        _selenium.EnterDataInputField(Signaalgevers, WegData.NieuweSignaalgevers);
        _selenium.EnterDataInputField(Beschrijving, WegData.Beschrijving);

        //Klik op de plus knop om portalen toe te voegen
        _selenium.ClickOnElementBasedOnCoordinates(PortalenPlusKnopX, PortalenPlusKnopY);

        //Klik op 'Ok' om het automatisch aangeboden portaal toe te voegen
        _selenium.ClickOnElementBasedOnCoordinates(PortalenOkKnopX, PortalenOkKnopY);

        driver.findElement(Actualiseren).click();
    }

    public void VulDetailsIn() throws AWTException, InterruptedException
    {
        Thread.sleep(1500);
        driver.findElement(DatumVanKalender).click();
        driver.findElement(VandaagInVanKalender).click();

        driver.findElement(WegnummerDropdown).click();
        //Selecteer het wegnummer uit de dropdown met coordinates
        _selenium.ClickOnElementBasedOnCoordinates(WegnummerX, WegnummerY);

        //Selecteer de wegzijde dropdown met coordinates
        Thread.sleep(500);
        _selenium.ClickOnElementBasedOnCoordinates(WegzijdeDropdownX, WegzijdeDropdownY);
        Thread.sleep(500);
        //Selecteer de wegzijde met coordinates
        _selenium.ClickOnElementBasedOnCoordinates(WegzijdeRechtsX, WegzijdeRechtsY);

        Thread.sleep(500);
        _selenium.EnterDataInputField(VanKilometer, WegData.VanKilometer);
        _selenium.EnterDataInputField(TotKilometer, WegData.TotKilometer);
    }

    public void WisIngevuldeVerplichteVeld(String verplichtVeld) throws Exception {
        By elementNaam;
        switch (verplichtVeld.toLowerCase())
        {
            case "datum van":
                elementNaam = DatumVan;
                break;
            case "wegnummer":
                elementNaam = Wegnummer;
                break;
            case "wegzijde":
                elementNaam = Wegzijde;
                break;
            case "van kilometer":
            case "van km":
                elementNaam = VanKilometer;
                break;
            case "tot kilometer":
            case "tot km":
                elementNaam = TotKilometer;
                break;
            default:
                throw new Exception("{verplichtVeld} is niet geimplementeerd");
        }

        driver.findElement(elementNaam).click();
        driver.findElement(elementNaam).clear();
        driver.findElement(elementNaam).sendKeys(Keys.TAB);
    }

    public void BewerkEersteBestaandeTijdelijkeWijziging()
    {
        driver.findElement(EersteBestaandeTijdelijkeWijziging).click();

        driver.findElement(Bewerken).click();
    }

    //ToDo dit in beforescenario dmv database delete
    public void VerwijderBestaandeTestWijzigingen() throws Exception
    {
        //Indien er een testwijziging aanwezig is moet deze weggehaald worden

        //Klik op dropdown voor 'Datum van' d.m.v. coordinaten
        _selenium.ClickOnElementBasedOnCoordinates(DatumVanDropdownX, DatumVanDropdownY);

        //Selecteer 'Datum aflopend' in de dropdown d.m.v. coordinaten
        Thread.sleep(1000);
        _selenium.ClickOnElementBasedOnCoordinates(DatumVanAflopendSorterenX, DatumVanAflopendSorterenY);

        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(EersteBestaandeTijdelijkeWijziging)));
        WebElement tijdelijkeWijziging = driver.findElement(EersteBestaandeTijdelijkeWijzigingNaam);
        String tijdelijkeWijzigingNaam = _selenium.GetTextFromElement(EersteBestaandeTijdelijkeWijzigingNaam);
        if (tijdelijkeWijzigingNaam.equals(WegData.TijdelijkeWijzigingNaam))
        {
            tijdelijkeWijziging.click();
            Thread.sleep(500);
            driver.findElement(Verwijderen).click();
            Thread.sleep(500);
            _selenium.ClickOnElementBasedOnCoordinates(MaatregelVerwijderenX, MaatregelVerwijderenY);

            //Klik op OK om de maatregelen te accepteren
            Thread.sleep(1500);
            _selenium.ClickOnElementBasedOnCoordinates(BetrokkenMaatregelenAccepterenX, BetrokkenMaatregelenAccepterenY);
        }
    }

    public boolean VeldIsRoodOnderstreept(By elementname)
    {
        WebElement element = driver.findElement(elementname);
        return element.getAttribute("class").contains("x-form-invalid");
    }

    public void FilterTijdelijkeWijzigingen(String wegnummer, String wegzijde) throws Exception
    {
        int wegnummerXcoordinaat;
        int wegnummerYCoordinaat;
        int wegzijdeXCoordinaat;
        int wegzijdeYCoordinaat;

        switch (wegnummer)
        {
            case "A12":
                wegnummerXcoordinaat = FilterA12X;
                wegnummerYCoordinaat = FilterA12Y;
                break;
            default:
                throw new Exception(String.format("voor wegnummer %s is nog geen case geimplementeerd. Maak deze aub zelf aan.", wegnummer));
        }

        switch (wegzijde.toLowerCase())
        {
            case "re":
                wegzijdeXCoordinaat = FilterRechtsX;
                wegzijdeYCoordinaat = FilterRechtsY;
                break;
            default:
                throw new Exception(String.format("voor wegzijde %s is nog geen case geimplementeerd. Maak deze aub zelf aan.", wegzijde));
        }

        driver.findElement(FilterWegnummerDropdown).click();

        _selenium.ClickOnElementBasedOnCoordinates(wegnummerXcoordinaat, wegnummerYCoordinaat);

        driver.findElement(FilterWegzijdeDropdown).click();

        _selenium.ClickOnElementBasedOnCoordinates(wegzijdeXCoordinaat, wegzijdeYCoordinaat);

        driver.findElement(FilterZoeken).click();
    }

    public void ExporteerTijdelijkeWijzigingen(String format) throws Exception
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.findElement(Exporteren).click();
        wait.until(ExpectedConditions.elementToBeClickable(BestandsformaatDropdown));
        driver.findElement(BestandsformaatDropdown).click();

        switch (format.toLowerCase())
        {
            case "xls":
                _selenium.ClickOnElementBasedOnCoordinates(XlsX, XlsY);
                break;
            case "csv":
                _selenium.ClickOnElementBasedOnCoordinates(CsvX, CsvY);
                break;
            default:
                throw new Exception(String.format("%s niet geimplementeerd", format));
        }

        driver.findElement(ExporterenOk).click();
    }
}
