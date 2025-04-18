package steps;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import io.cucumber.plugin.event.Node;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginPageSteps  {
    WebDriver driver;
    LoginPage lp;

    @Given("user launches the browser")
    public void userLaunchApplication() {
        try {
            driver=DriverFactory.getDriver();//driver
        } catch (Exception ae) {
            System.out.println(ae);
        }
    }

    @When("^user enters \"([^\"]*)\" and \"([^\"]*)\" with the valid credentials$")
    public void user_enters_with_the_valid_credentials(String username, String password) {
        lp=new LoginPage(driver);
        lp.userEntersCredentials(username,password);
    }

    @When("^clicks on Login button$")
    public void clicks_on_login_button() throws InterruptedException {
        lp.userClicksOnloginButton();
    }

    @Then("^user enters \"([^\"]*)\" and \"([^\"]*)\" to signUp to register as new user$")
    public void userEntersAndToSignUpToRegisterAsNewUser(String userNam, String emailAdd) {
        lp.userEntersNewUserName(userNam,emailAdd);
    }

    @And("user clicks on SignUp button")
    public void clicksOnSignUpButton() {
        lp.userClicksOnSignupBtn();
    }
}
