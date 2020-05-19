package TestData;

import org.openqa.selenium.WebDriver;

public class DriverSetup {

    public WebDriver driver;

    public void setDriver(WebDriver driver){
        this.driver = driver;
    }

    public WebDriver getDriver(){
        return this.driver;
    }
}
