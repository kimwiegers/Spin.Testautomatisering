package Services;

import PageObjects.Hoofdpagina;
import PageObjects.TijdelijkeWijzigingen;
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
import java.awt.event.InputEvent;

public class TijdelijkeWijzigingenService
{
    private final SeleniumService _enterData;
    private final WebDriver driver;
    private final SeleniumService _selenium;

    public TijdelijkeWijzigingenService(SeleniumService enterdata, DriverSetup driverSetup, SeleniumService selenium)
    {
        _enterData = enterdata;
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

    public void VulVerplichteVeldenInVoorEenTijdelijkeWijziging() throws InterruptedException, AWTException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(TijdelijkeWijzigingen.Nieuw));
        driver.findElement(TijdelijkeWijzigingen.Nieuw).click();

        driver.findElement(TijdelijkeWijzigingen.DatumVanKalender).click();
        driver.findElement(TijdelijkeWijzigingen.VandaagInVanKalender).click();

        driver.findElement(TijdelijkeWijzigingen.WegnummerDropdown).click();
        //Selecteer het wegnummer uit de dropdown met coordinates
        _selenium.ClickOnElementBasedOnCoordinates(831, 500);

        driver.findElement(TijdelijkeWijzigingen.WegzijdeDropdown).click();
        //Selecteer de wegzijde uit de dropdown met coordinates
        _selenium.ClickOnElementBasedOnCoordinates(831, 350);

        _enterData.EnterDataInputField(TijdelijkeWijzigingen.VanKilometer, WegData.VanKilometer);
        Thread.sleep(1000);
        _enterData.EnterDataInputField(TijdelijkeWijzigingen.TotKilometer, WegData.TotKilometer);

        driver.findElement(TijdelijkeWijzigingen.ZoekLocatie).click();
    }

    public void WisIngevuldeVerplichteVeld(String verplichtVeld) throws Exception {
        By elementNaam;
        switch (verplichtVeld.toLowerCase())
        {
            case "datum van":
                elementNaam = TijdelijkeWijzigingen.DatumVan;
                break;
            case "wegnummer":
                elementNaam = TijdelijkeWijzigingen.Wegnummer;
                break;
            case "wegzijde":
                elementNaam = TijdelijkeWijzigingen.Wegzijde;
                break;
            case "van kilometer":
            case "van km":
                elementNaam = TijdelijkeWijzigingen.VanKilometer;
                break;
            case "tot kilometer":
            case "tot km":
                elementNaam = TijdelijkeWijzigingen.TotKilometer;
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
        driver.findElement(TijdelijkeWijzigingen.EersteBestaandeTijdelijkeWijziging).click();

        driver.findElement(TijdelijkeWijzigingen.Bewerken).click();
    }
}
