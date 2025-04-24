package utils;

import library.AccessVariablesRepo;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
import java.time.Duration;
import static library.AccessVariablesRepo.getContentJsonData;

public class CommonUtils {
    JSONObject contentDataJson = AccessVariablesRepo.getContentJsonData();
    WebDriver driver;
    public CommonUtils(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void type(WebElement element, String testData, String locatorName) {
        element.clear();
        System.out.println("Cleared the existing Locator data : ");
        element.sendKeys(testData);
        System.out.println("Typed the Locator data :: " + testData);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }

    public void click(WebElement locator, String locatorName) {
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Method : click  ::  Locator : " + locatorName);
        locator.click();
        System.out.println("clicked the element :: " + locator);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }

   public void localWait(long value) {
        try {
            Thread.sleep(value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean waitForVisibilityOfElement(WebElement element) {
        System.out.println("checking for visibility of  :: " + element);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(element));
        return true;
    }

    public JSONObject getDataFromJson(String requiredData) {
         contentDataJson = getContentJsonData();
        for (String dataField : contentDataJson.keySet()) {
            if (requiredData.equalsIgnoreCase(dataField)) {
                return contentDataJson.getJSONObject(dataField);
            }
        }
        System.out.println("End of JSON Reading");
        return null;
    }

    public String readDataFromJsonFile(String dataTag, String fieldName) throws IOException {
        String fieldValue = null;
        JSONObject jObjData = getDataFromJson(dataTag);
        for (String dataValue : jObjData.keySet()) {
            if (dataValue.equalsIgnoreCase(fieldName)) {
                fieldValue = jObjData.get(dataValue).toString();
                break;
            }
        }
        return fieldValue;
    }
}
