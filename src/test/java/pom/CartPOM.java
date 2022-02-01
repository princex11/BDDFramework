package pom;

import base.BaseDemoBlaze;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPOM extends BaseDemoBlaze {

    @FindBy(xpath = "//*[@id=\"totalp\"]")
    public WebElement price;

    public CartPOM() {
        PageFactory.initElements(driver, this);
    }

    public void isPriceVisible(){
        Assert.assertTrue(price.isDisplayed());
    }
}
