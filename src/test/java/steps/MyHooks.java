package steps;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class MyHooks {

    WebDriver driver = null;

    @Before
    public void setup() throws IOException {
        System.out.println("WebDriver session has started!!!+22");
        Properties prop = ConfigReader.intiliaseProperties();
        DriverFactory.initializeBrowser(prop.getProperty("browser"));
        driver = DriverFactory.getDriver();
        try {
            driver.get(prop.getProperty("url"));
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
        } catch (Exception ae) {
            System.out.println(ae);
        }
    }

    @After
    public void tearDown() {
        driver.quit();
        System.out.println("WebDriver session ended!!!");
    }
}
