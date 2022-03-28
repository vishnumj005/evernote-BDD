package common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClasses.Init;
import baseClasses.JSWaiter;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import pageObjects.LoginPageObjects;

public class CommonSteps extends Init {
    JSWaiter jswait = new JSWaiter();
    LoginPageObjects loginPage = new LoginPageObjects();

    public CommonSteps() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span/span/div[@role='presentation']")
    private WebElement pofile;
    @FindBy(id = "qa-ACCOUNT_DROPDOWN_LOGOUT")
    private WebElement logout;
    @FindBy(id = "qa-LOGOUT_CONFIRM_DIALOG_HEADER")
    private WebElement logoutmodal;
    @FindBy(id = "qa-LOGOUT_CONFIRM_DIALOG_CANCEL")
    private WebElement cancelModal;
    @FindBy(id = "qa-NAV_HOME")
    private WebElement home;

    @Given("^login to the application$")
    public void loginuser() throws Exception {

        driver.get(p.getValue("env"));
        loginPage.login(p.getValue("username"), p.getValue("password"));
    }

    @Then("^logout from the application$")
    public void LogoutFromApplication() throws InterruptedException {
        jswait.loadClick(pofile);
        jswait.loadClick(logout);

        if (jswait.checkVisibility(logoutmodal)) {
            jswait.loadClick(cancelModal);
            Thread.sleep(3000);
            jswait.loadClick(home);
            jswait.loadClick(pofile);
            jswait.loadClick(logout);
        }

    }

}