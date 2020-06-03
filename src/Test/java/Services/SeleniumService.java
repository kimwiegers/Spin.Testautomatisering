package Services;

import PageObjects.Hoofdpagina;
import TestData.DriverSetup;
import TestData.TestData;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.concurrent.TimeUnit;

import static PageObjects.StandaardOmleidingen.FilterOmleidingWegnummerDropdown;

public class SeleniumService
{
    private final WebDriver driver;
    private final Actions actions;

    public SeleniumService(DriverSetup driverSetup)
    {
        driver = driverSetup.getDriver();
        actions =  new Actions(driver);
    }

    public void EnterDataInputField(By elementName, String input)
    {
        Actions actions = new Actions(driver);
        WebElement webElement = driver.findElement(elementName);
        webElement.click();
        webElement.clear();
        webElement.sendKeys(input);
        actions.sendKeys(Keys.ENTER).perform();
        webElement.sendKeys(Keys.TAB);
    }

    public boolean ElementIsEnabled(By elementName)
    {
        WebElement element = driver.findElement(elementName);
        return element.isEnabled();
    }

    public boolean ElementHasContent(By elementName) throws InterruptedException
    {
        for (int i = 0; i < 6; i++)
        {
            WebElement element = driver.findElement(elementName);
            String elementContent = element.getAttribute("value");

            if (elementContent != null && !elementContent.isEmpty())
            {
                return true;
            }

            Thread.sleep(500);
        }
        return false;
    }

    public String GetTextFromElement(By elementName) throws Exception
    {
        for (int i = 0; i < 5; i++)
        {
            WebElement element = driver.findElement(elementName);
            String textInElement = element.getAttribute("value");
            if (textInElement != null)
            {
                return textInElement;
            }
            else
            {
                textInElement = element.getText();
                if (textInElement != null)
                {
                    return textInElement;
                }

                Thread.sleep(500);
            }
        }
        throw new Exception(String.format("Text in element %s not found", elementName));
    }

    public void WaitUntilElementIsEnabled(By elementName) throws Exception
    {
        for (int i = 0; i < 10; i++)
        {
            WebElement element = driver.findElement(elementName);
            String elementDisabled = element.getAttribute("aria-disabled");

            if (elementDisabled.equals("false"))
            {
                return;
            }

            Thread.sleep(1000);
        }

        throw new Exception("Het element is na 15 seconden nog steeds disabled");
    }

    public boolean isAttributePresent(WebElement element, String attribute)
    {
        try {
            String value = element.getAttribute(attribute);
            if (value != null){
               return true;
            }
        } catch (Exception e) {}

        return false;
    }

    public void ClickOnElementBasedOnCoordinates(int xCoordinate, int yCoordinate) throws AWTException
    {
        Robot robot = new Robot();
        robot.mouseMove(xCoordinate, yCoordinate);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }

    public void ContextClickOnElementBasedOnCoordinates(int xCoordinate, int yCoordinate) throws AWTException
    {
        Robot robot = new Robot();
        robot.mouseMove(xCoordinate, yCoordinate);
        robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
    }

    public void WaitUntilClickableThenClick(By element)
    {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void SetNewImplicitWaitTime(int time)
    {
        driver.manage().timeouts().implicitlyWait(
                time, TimeUnit.SECONDS);
    }

    public boolean VeldIsRoodOnderstreept(By elementname) throws Exception
    {
        Thread.sleep(3000);
        for (int i = 0; i < 15; i++)
        {
            WebElement element = driver.findElement(elementname);
            boolean invalidElement = element.getAttribute("class").contains("x-form-invalid");

            if (invalidElement)
            {
                return true;
            }

            Thread.sleep(1000);
        }

        throw new Exception("Element a 15 seconden nog niet met rood omlijnd");
    }

    public void SwitchToCurrentScreen()
    {
        for (String currentWindow : driver.getWindowHandles())
            driver.switchTo().window(currentWindow);
        driver.manage().window().setPosition(new org.openqa.selenium.Point(0, -5));
        driver.manage().window().setSize(new Dimension(1920, 1080));
    }

    public boolean TextInElementContainsExpectedText(By element, String ExpectedText) throws Exception
    {
        for (int i = 0; i < 5; i++)
        {
            String faseNaam = GetTextFromElement(element);
            if (faseNaam.contains(ExpectedText))
            {
                return true;
            }

            Thread.sleep(1000);
        }

        return false;
    }

    public void WaitUntilHomepageFullyLoaded()
    {
        driver.manage().timeouts().implicitlyWait(
                90, TimeUnit.SECONDS);
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/div[1]"));

    }

    public void SelectFromDropdown(By element, int arrowDownNumberOfTimes)
    {
        WaitUntilClickableThenClick(element);

        for (int i = 0; i < arrowDownNumberOfTimes; i++)
        {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }

        actions.sendKeys(Keys.ENTER).perform();
        actions.sendKeys(Keys.TAB).perform();
    }
}
