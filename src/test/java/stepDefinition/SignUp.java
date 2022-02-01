package stepDefinition;

import base.BaseDemoBlaze;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pom.DemoBlazeIndexPOM;
import pom.SignUpPOM;

public class SignUp extends BaseDemoBlaze {

    DemoBlazeIndexPOM indexPOM;
    SignUpPOM signUpPOM;

    @Before()
    public void init(){
        initSetUp();
    }

    @Given("user on homepage of demoblaze {string}")
    public void userOnHomepageOfDemoblaze(String url) {
        driver.get(url);
    }

    @When("user clicks on signup tab")
    public void userClicksOnSignupTab() {
        indexPOM = new DemoBlazeIndexPOM();
        indexPOM.clickSignUp();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("enter username {string} and password {string}")
    public void enterUsernameAndPassword(String username, String password) {
        signUpPOM = new SignUpPOM();
        signUpPOM.typeUserName(username);
        signUpPOM.typePassword(password);
    }

    @And("click on signup button")
    public void clickOnSignupButton() {
        signUpPOM.clickBtnSignup();
    }

    @Then("handle alert")
    public void handleAlert() {
        WebDriverWait wait = new WebDriverWait(driver, 5000);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    @After()
    public void close(){
        closeBrowser();
    }
}
