package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonUtils;


public class LoginPage  {

    WebDriver driver;
    CommonUtils commUtil;

    public LoginPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
        commUtil=new CommonUtils(driver);
    }

    CommonUtils commUtils;
    @FindBy(xpath="(//h2)[1]/../form/input[2]")
    public WebElement userNames;

    @FindBy(xpath="(//h2)[1]/../form/input[3]")
    public WebElement passWord;

    @FindBy(xpath="//h2[text()='New User Signup!']/../form/input[2]")
    public WebElement newName;

    @FindBy(xpath="//h2[text()='New User Signup!']/../form/input[3]")
    public WebElement emailAddres;

    @FindBy(xpath="(//h2)[1]/../form/button")
    public WebElement loginBtn;

    @FindBy(xpath="//h2[text()='New User Signup!']/../form/button")
    public WebElement SignUpBtn;

    @FindBy(xpath="//img[contains(@src,'girl1.jpg')]")
    public WebElement imageIcon;

    public void userEntersCredentials(String userName,String password){
        commUtil.type(userNames,userName,"UserName Entry");
        commUtil.type(passWord,password,"Password Entry");
    }

    public void userEntersNewUserName(String newUserName,String emailAddress){
        commUtil.type(newName,newUserName,"New UserName Entry");
        commUtil.type(emailAddres,emailAddress,"Email Entry");
    }

    public void userClicksOnloginButton() throws InterruptedException {
        loginBtn.click();
        commUtil.localWait(2800);
    }

    public void userClicksOnSignupBtn(){
        SignUpBtn.click();
        commUtil.waitForVisibilityOfElement(imageIcon);
        commUtil.localWait(800);
    }
}
