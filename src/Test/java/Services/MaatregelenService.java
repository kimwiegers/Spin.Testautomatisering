package Services;

import PageObjects.Hoofdpagina;
import PageObjects.Maatregel;
import TestData.DriverSetup;
import TestData.TestData;
import TestData.WegData;
import cucumber.api.java.vi.Cho;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MaatregelenService
{

    private final SeleniumService _selenium;
    private final WebDriver driver;

    public MaatregelenService(SeleniumService selenium, DriverSetup driverSetup)
    {
        driver = driverSetup.getDriver();
        _selenium = selenium;
    }


    public void OpenNieuweMaatregel(WebElement fase) throws InterruptedException
    {
        Actions actions = new Actions(driver);
        actions.moveByOffset(Hoofdpagina.FaseX, Hoofdpagina.FaseY).perform();
        actions.contextClick().perform();

        actions.sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN,
                Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_RIGHT,
                Keys.ENTER)).perform();

        _selenium.SwitchToCurrentScreen();
    }

    public void OpenNieuweMaatregelOnderbestaandeFase(WebElement fase) throws InterruptedException
    {
        Actions actions = new Actions(driver);
        actions.contextClick(fase).perform();

        actions.sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN,
                Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_RIGHT,
                Keys.ENTER)).perform();

        _selenium.SwitchToCurrentScreen();
    }

    public void MaakNieuweMaatregelAan() throws Exception
    {
        _selenium.SwitchToCurrentScreen();
        WaitUntilMaatregelPageLoaded();

        _selenium.WaitUntilClickableThenClick(Maatregel.Startdatum);
        _selenium.WaitUntilClickableThenClick(Maatregel.VandaagInVanKalender);

        String datum = new DatesAndTimesService().GetDatumInToekomstFormatInvoerveld(7);
        _selenium.EnterDataInputField(Maatregel.EinddatumInputfield, datum);

        Actions actions = new Actions(driver);

        _selenium.WaitUntilClickableThenClick(Maatregel.WegwerktypeDropdown);
        actions.sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ENTER)).perform();

        _selenium.WaitUntilClickableThenClick(Maatregel.WegbeheerderDropdown);
        actions.sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ENTER)).perform();

        _selenium.WaitUntilClickableThenClick(Maatregel.BesteknummerDropdown);
        actions.sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ENTER)).perform();

        _selenium.EnterDataInputField(Maatregel.VanKilometer, WegData.VanKilometer);
        _selenium.EnterDataInputField(Maatregel.TotKilometer, WegData.TotKilometer);

        _selenium.WaitUntilClickableThenClick(Maatregel.VerkeershinderklasseDropdown);
        actions.sendKeys(Keys.chord(Keys.ENTER)).perform();

        driver.findElement(Maatregel.FilegevoeligNee).click();
        driver.findElement(Maatregel.WeergevoeligNee).click();
        driver.findElement(Maatregel.SnelheidslimietNee).click();

        _selenium.WaitUntilClickableThenClick(Maatregel.Afzetsysteem);
        actions.sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ENTER)).perform();
        _selenium.WaitUntilClickableThenClick(Maatregel.CompleteWegafsluitingNee);

        _selenium.WaitUntilClickableThenClick(Maatregel.Dwarsprofiel1);
        _selenium.WaitUntilClickableThenClick(Maatregel.Dwarsprofiel1PijlOmhoog);

        _selenium.EnterDataInputField(Maatregel.Breedte, WegData.Breedte);
        _selenium.WaitUntilClickableThenClick(Maatregel.HoogteNee);
        _selenium.WaitUntilClickableThenClick(Maatregel.LengteNee);

        _selenium.WaitUntilClickableThenClick(Maatregel.VerkeersloketDropdown);
        actions.sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ENTER)).perform();

        _selenium.WaitUntilClickableThenClick(Maatregel.OpmerkingToevoegen);
        _selenium.EnterDataInputField(Maatregel.OpmerkingInput, TestData.Testomschrijving);
        _selenium.WaitUntilClickableThenClick(Maatregel.OpmerkingToevoegenOk);

        Thread.sleep(3000);
        _selenium.WaitUntilElementIsEnabled(Maatregel.Bewaren);
        _selenium.WaitUntilClickableThenClick(Maatregel.Bewaren);
        Thread.sleep(5000);
        _selenium.WaitUntilElementIsEnabled(Maatregel.Sluiten);
        _selenium.WaitUntilClickableThenClick(Maatregel.Sluiten);
    }

    private void WaitUntilMaatregelPageLoaded() throws Exception
    {
        assertThat(_selenium.VeldIsRoodOnderstreept(Maatregel.EinddatumInputfield)).isTrue();
    }

    public void VulRouteIn() throws Exception
    {
        WaitUntilMaatregelPageLoaded();

        Actions actions = new Actions(driver);

        //De enige manier om de A12 goed te selecteren voor zowel Van als Tot wegnummer
        driver.findElement(Maatregel.VanWegnummer).clear();
        _selenium.WaitUntilClickableThenClick(Maatregel.VanWegnummerDropdown);
        actions.sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN,
                Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER)).perform();

        driver.findElement(Maatregel.TotWegnummer).clear();
        _selenium.WaitUntilClickableThenClick(Maatregel.TotWegnummerDropdown);
        actions.sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN,
                Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER)).perform();

        Thread.sleep(500);
        driver.findElement(Maatregel.VanWegzijde).clear();
        _selenium.WaitUntilClickableThenClick(Maatregel.VanWegzijdeDropdown);
        actions.sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER)).perform();

        driver.findElement(Maatregel.TotWegzijde).clear();
        _selenium.WaitUntilClickableThenClick(Maatregel.TotWegzijdeDropdown);
        actions.sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER)).perform();

        _selenium.EnterDataInputField(Maatregel.VanKilometer, WegData.VanKilometer);
        _selenium.EnterDataInputField(Maatregel.TotKilometer, WegData.TotKilometer);
    }
}
