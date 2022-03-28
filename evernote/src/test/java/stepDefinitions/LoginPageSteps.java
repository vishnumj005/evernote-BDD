package stepDefinitions;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.PageFactory;

import baseClasses.Init;
import baseClasses.JSWaiter;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pageObjects.LoginPageObjects;

public class LoginPageSteps extends Init {

    JSWaiter jswait = new JSWaiter();
    LoginPageObjects loginPage = new LoginPageObjects();

    public LoginPageSteps() {
        PageFactory.initElements(driver, this);
    }

    @Given("^url is loaded$")
    public void evernote_is_loaded() throws Throwable {
        driver.get(p.getValue("env"));
    }
    @Then("^login with valid credentails$")
    public void loginWithValidData() throws Exception {
        loginPage.login(p.getValue("username"), p.getValue("password"));
    }
    @Then("^login with wrong username$")
    public void loginWithWrongUsername() throws Exception {
        loginPage.login("automation@automation.trt");
    }
    @Then("^verify login success$")
    public void verify_login_success() throws Throwable {
        assertTrue(loginPage.checkLogin(), "Login successful");
    }
    @Then("^verify login failure$")
    public void verify_login_failure() throws Throwable {
        assertTrue(loginPage.getWarningMsg(), "Login UnSuccessful");

    }
}