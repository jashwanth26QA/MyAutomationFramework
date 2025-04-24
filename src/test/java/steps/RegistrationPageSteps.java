package steps;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.RegistrationFormPage;

import java.io.IOException;

public class RegistrationPageSteps {
    WebDriver driver;
    RegistrationFormPage rf;

    @Then("^user fills the details in the resgistration page$")
    public void userFillsDetailsOfNewUser() throws IOException {
        driver= DriverFactory.getDriver();//driver
        rf=new RegistrationFormPage(driver);
        rf.userFillsData();
    }
}
