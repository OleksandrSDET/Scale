package utilities;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;

public class AlertHelper {

    private static final Logger oLog = LogManager.getLogger(AlertHelper.class);

    public AlertHelper() {
        oLog.debug("AlertHelper : " + Driver.getInstance().getDriver().hashCode());
    }

    public Alert getAlert() {
        return Driver.getInstance().getDriver().switchTo().alert();
    }

    public void AcceptAlert() {
        getAlert().accept();
    }

    public String getAlertText() {
        String text = getAlert().getText();
        oLog.info("Alert message is: "+text);
        return text;
    }

}
