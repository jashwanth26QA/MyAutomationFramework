package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public static WebDriver driver = null;

    public static void initializeBrowser(String browserName) {
        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equals("firefox")) {
            driver = new FirefoxDriver();
        } else if (browserName.equals("edge")) {
            driver = new EdgeDriver();
        }

    }

    public static WebDriver getDriver() {
        return driver;
    }
}
