package stepDefinition;

import base.BaseDemoBlaze;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pom.*;

public class AddLaptopToCart extends BaseDemoBlaze {

    DemoBlazeIndexPOM indexPOM;
    LoginPOM loginPOM;
    LaptopsPOM laptopsPOM;
    SelectedLaptopPOM selectedLaptopPOM;
    CartPOM cartPOM;


    @Before(order = 3)
    public void init(){
        initSetUp();
    }

    @Given("homepage of demoblaze {string}")
    public void homepageOfDemoblaze(String url) {
        driver.get(url);
    }

    @When("clicks on login tab")
    public void clicksOnLoginTab() {
        indexPOM = new DemoBlazeIndexPOM();
        indexPOM.clickLogin();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("Enter username {string} and Password {string}")
    public void enterUsernameAndPassword(String username, String password) {
        loginPOM = new LoginPOM();
        loginPOM.typeUserName(username);
        loginPOM.typePassword(password);
    }

    @And("clicks on login button")
    public void clicksOnLoginButton() {
        loginPOM.clickBtnLogIn();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("verify user name is displaying i.e successful login")
    public void verifyUserNameIsDisplayingIESuccessfulLogin() {
        indexPOM.isNameOfUserVisible();
    }

    @Given("after successful login user on homepage")
    public void afterSuccessfulLoginUserOnHomepage() {
        indexPOM = new DemoBlazeIndexPOM();
        indexPOM.isNameOfUserVisible();
    }

    @When("user clicks on laptops link")
    public void userClicksOnLaptopsLink() {
        indexPOM.clickLaptops();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @And("select laptop sony_viao_i_five")
    public void selectLaptopSony_viao_i_five() {
        laptopsPOM = new LaptopsPOM();
        laptopsPOM.clickSonyViaoI5();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("navigated to selected laptop page, where user clicks on add_to_cart button")
    public void navigatedToSelectedLaptopPageWhereUserClicksOnAdd_to_cartButton() {
        selectedLaptopPOM = new SelectedLaptopPOM();
        selectedLaptopPOM.clickBtnAddToCart();
    }

    @And("handles the alert")
    public void handlesTheAlert() {
        WebDriverWait wait = new WebDriverWait(driver, 5000);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }


    @And("navigates to cart page {string}")
    public void navigatesToCartPage(String url) {
        driver.navigate().to(url);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Then("verify if the laptop is in cart or not.")
    public void verifyIfTheLaptopIsInCartOrNot() {
      cartPOM = new CartPOM();
      cartPOM.isPriceVisible();
    }

    @After(order = 4)
    public void close(){
        closeBrowser();
    }
}
