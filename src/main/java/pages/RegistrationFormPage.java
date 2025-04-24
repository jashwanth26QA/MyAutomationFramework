package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonUtils;

import java.io.IOException;
import java.util.HashMap;

public class RegistrationFormPage {

    WebDriver driver;
    CommonUtils commUtil;

    public RegistrationFormPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
        commUtil=new CommonUtils(driver);
    }

    @FindBy(xpath="//input[@id='id_gender1']")
    private WebElement genderBtn;

    @FindBy(xpath="//input[@id='password']")
    private WebElement password;

    @FindBy(xpath="//input[@id='optin']")
    private WebElement receiveAlertsCheckBox;

    @FindBy(xpath="//input[@id='last_name']")
    private WebElement lastName;

    @FindBy(xpath="//input[@id='company']")
    private WebElement company;

    @FindBy(xpath="//input[@id='address1']")
    private WebElement address;

    @FindBy(xpath="//input[@id='address2']")
    private WebElement address2;

    @FindBy(xpath="//input[@id='state']")
    private WebElement state;

    @FindBy(xpath="//input[@id='city']")
    private WebElement city;

    @FindBy(xpath="//input[@id='zipcode']")
    private WebElement zipCode;

    @FindBy(xpath="//input[@id='mobile_number']")
    private WebElement mobileNumber;

    public static By selectDropDownOption(String dropDowntype) {

        return By.xpath("//select[@id='"+dropDowntype+"']");
    }
    public static HashMap<String, String> dataFillCrisisUpdate = new HashMap<>();

    public void userPreparesNewData() throws IOException {
        dataFillCrisisUpdate.put("Password",commUtil.readDataFromJsonFile("RegistrationForm","Password"));
        dataFillCrisisUpdate.put("Last Name",commUtil.readDataFromJsonFile("RegistrationForm","LastName"));
        dataFillCrisisUpdate.put("Company",commUtil.readDataFromJsonFile("RegistrationForm","Company"));
        dataFillCrisisUpdate.put("Address",commUtil.readDataFromJsonFile("RegistrationForm","Address"));
        dataFillCrisisUpdate.put("Address_2",commUtil.readDataFromJsonFile("RegistrationForm","Address2"));
        dataFillCrisisUpdate.put("State",commUtil.readDataFromJsonFile("RegistrationForm","State"));
        dataFillCrisisUpdate.put("City",commUtil.readDataFromJsonFile("RegistrationForm","City"));
        dataFillCrisisUpdate.put("ZipCode",commUtil.readDataFromJsonFile("RegistrationForm","ZipCode"));
        dataFillCrisisUpdate.put("MobileNumber",commUtil.readDataFromJsonFile("RegistrationForm","MobileNumber"));
    }

    public void userFillsData() throws IOException {
        userPreparesNewData();
        commUtil.click(genderBtn,"Title Choose Option");
        commUtil.type(password,dataFillCrisisUpdate.get("Password"),"Password");
        commUtil.type(lastName,dataFillCrisisUpdate.get("Last Name"),"LastName");
        commUtil.type(company,dataFillCrisisUpdate.get("Company"),"company");
        commUtil.type(address,dataFillCrisisUpdate.get("Address"),"Address");
        commUtil.type(address2,dataFillCrisisUpdate.get("Address_2"),"Address_2");
        commUtil.type(state,dataFillCrisisUpdate.get("State"),"States");
        commUtil.type(city,dataFillCrisisUpdate.get("City"),"City");
        commUtil.type(zipCode,dataFillCrisisUpdate.get("ZipCode"),"Zip Code");
        commUtil.type(mobileNumber,dataFillCrisisUpdate.get("MobileNumber"),"mobileNumber");
        System.out.println("");
    }
}
