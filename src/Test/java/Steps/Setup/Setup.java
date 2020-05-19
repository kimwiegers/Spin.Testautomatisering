package Steps.Setup;

import Services.*;
import TestData.DriverSetup;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;


public class Setup {

    public DriverSetup _driverSetup;
    protected WebDriver driver;

    public Setup(DriverSetup driverSetup)
    {
        _driverSetup = driverSetup;
    }

    @Before
    public void OpenBrowser() throws Exception {
        driver = BrowserFactory.GetBrowser("chrome");
        driver.manage().deleteAllCookies();
        driver.manage().window().setPosition(new Point(0 , -5));
        driver.manage().window().setSize(new Dimension(1920, 1080));
        _driverSetup.setDriver(driver);
    }


    @After
    public void CloseBrowser() {
        {
            driver = _driverSetup.getDriver();
            driver.quit();
        }
    }
}
