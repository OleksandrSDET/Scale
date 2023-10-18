package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import pages.GoldBarPage;
import utilities.*;

public class FakeGoldBarFinderSteps {

    public static final Logger oLog = LogManager.getLogger(FakeGoldBarFinderSteps.class);
    public GoldBarPage goldBarPage = new GoldBarPage();
    public AlertHelper alertHelper = new AlertHelper();




    @Given("I open the website")
    public void i_open_the_website() {
        Driver.getInstance().getDriver().get(ConfigurationReader.getProperty("config.properties","scale.url"));
        oLog.info("Navigated to balance scale website");
    }

    @When("I find the fake gold bar")
    public void i_find_the_fake_gold_bar() throws InterruptedException {
        goldBarPage.findFakeGoldBar().click();
    }

    @Then("I should see the alert message")
    public void i_should_see_the_alert_message() {
        String message = alertHelper.getAlertText();
        alertHelper.AcceptAlert();
        Assert.assertEquals("Yay! You find it!",message);
    }

    @Then("I should see the  list of Weighings")
    public void i_should_see_the_list_of_Weighings() {
        oLog.info("The list of weighings:");
        goldBarPage.printWeighingResult();
    }

}
