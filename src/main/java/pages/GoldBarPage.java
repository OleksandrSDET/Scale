package pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.WaitHelper;

import java.util.List;

public class GoldBarPage {
    public static final Logger oLog = LogManager.getLogger(GoldBarPage.class);
    public GoldBarPage(){
        PageFactory.initElements(Driver.getInstance().getDriver(), this);
    }

    @FindBy(xpath = "//button[@class='square']")
    public List<WebElement> barList;

    @FindBy(id = "left_0")
    public WebElement leftBowlInput;

    @FindBy(id = "right_0")
    public WebElement rightBowlInput;

    @FindBy(xpath = "//button[text()='Reset']")
    public WebElement resetBotton;

    @FindBy(id = "weigh")
    public WebElement weighBotton;

    @FindBy(xpath = "//div[@class='game-info']/ol/li")
    public List<WebElement> weighingsResult;

    public void printWeighingResult(){
        for(WebElement weighing: weighingsResult){
            oLog.info(weighing.getText());
        }
    }

    public void fillLeftBowl(int low, int mid){
        oLog.info("Starting fill left bowl with bars from: "+low+" to "+(mid-1));
        leftBowlInput.sendKeys(String.valueOf(low)+Keys.TAB);

        for(int i=low+1; i<mid; i++) {
            WebElement activeElement = Driver.getInstance().getDriver().switchTo().activeElement();
            activeElement.sendKeys(String.valueOf(i)+Keys.TAB);
        }
    }

    public void fillRightBowl(int mid, int high){
        oLog.info("Starting fill right bowl with bars from: "+mid+" to "+(high-1));
        rightBowlInput.sendKeys(String.valueOf(mid)+Keys.TAB);

        for(int i=mid+1; i<high; i++) {
            WebElement activeElement = Driver.getInstance().getDriver().switchTo().activeElement();
            activeElement.sendKeys(String.valueOf(i)+Keys.TAB);
        }
    }

    public void weigh() {
        weighBotton.click();
    }

    public String getWeighResult() {
        return weighingsResult.get(weighingsResult.size()-1).getText();
    }

    public WebElement findFakeGoldBar()  {
        int low = 0;
        int high = barList.size()-1;

        while (high-low !=1) {
            int mid = (low + high) / 2;
            fillLeftBowl(low, mid);
            fillRightBowl(mid, high);
            weigh();
            WaitHelper.wait(3);
            resetBotton.click();

            if(getWeighResult().contains(">")) {
                oLog.info("The fake bar is on the right side");
                low = mid;
            } else if (getWeighResult().contains("<")) {
                oLog.info(" The fake bar is on the left side");
                high = mid;
            } else {
                oLog.info("The two sides balance; the fake bar is not among the weighed bars");
                oLog.info("Found the fake gold bar is number: "+barList.get(barList.size()-1));
                return barList.get(barList.size()-1);
            }

        }
        oLog.info("Found the fake gold bar is number: "+barList.get(low).getText());
        return barList.get(low);

    }


}
