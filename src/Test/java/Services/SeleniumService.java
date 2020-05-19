package Services;

import TestData.DriverSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.event.InputEvent;

public class SeleniumService
{
    private final WebDriver driver;

    public SeleniumService(DriverSetup driverSetup)
    {
        driver = driverSetup.getDriver();
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

    public void ClickOnElementBasedOnCoordinates(int xCoordinate, int yCoordinate) throws AWTException
    {
        Robot robot = new Robot();
        robot.mouseMove(xCoordinate, yCoordinate);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }
}
