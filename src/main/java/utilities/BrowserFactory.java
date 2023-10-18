package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.HashMap;

public class BrowserFactory {

    public static WebDriver createInstance() {

        WebDriver driver = null;

        try {
            if (driver == null) {
                if(System.getProperty("browser")==null){
                    HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
                    chromePrefs.put("profile.default_content_settings.popups", 0);
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--ignore-ssl-errors=yes");
                    options.addArguments("--ignore-certificate-errors");
                    options.setExperimentalOption("prefs", chromePrefs);
                    driver = new ChromeDriver(options);
                }
                else {
                    switch (System.getProperty("browser")) {
                        case "firefox":
                            driver = new FirefoxDriver();
                            break;
                        case "edge":
                            if (System.getProperty("os.name").toLowerCase().contains("mac")) {
                                throw new WebDriverException("Your operating system does not support the requested browser");
                            }
                            driver = new EdgeDriver();
                            break;
                        default:
                            driver = new ChromeDriver();
                            break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return driver;
    }







}
