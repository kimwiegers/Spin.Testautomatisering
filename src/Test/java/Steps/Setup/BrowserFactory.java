package Steps.Setup;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public class BrowserFactory {

    public static WebDriver GetBrowser(String browserName) throws Exception {
        browserName = browserName.toLowerCase();

        if(browserName.equals("chrome"))
            return getChromeInstance();
        if(browserName.equals("firefox"))
            return getFFInstance();
        else{
            throw new Exception("Browser {browsername} not supported");
        }
    }

    private static FirefoxDriver getFFInstance() {

//        FirefoxDriverManager.getInstance().setup();
        System.setProperty("webdriver.gecko.driver", "C:\\Drivers\\geckodriver.exe");
        FirefoxDriver driver=new FirefoxDriver();
        return driver;
    }

    private static ChromeDriver getChromeInstance() {

        ChromeDriverManager.getInstance().setup();

        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        prefs.put("credentials_enable_service", false);
        prefs.put("password_manager_enabled", false);

        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files (x86)\\Google\\Chrome Beta\\Application\\chrome.exe");
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        //options.addArguments("--headless");

        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(
                30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        return driver;
    }
}
