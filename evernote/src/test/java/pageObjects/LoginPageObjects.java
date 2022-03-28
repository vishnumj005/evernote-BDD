package pageObjects;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClasses.Init;
import baseClasses.JSWaiter;

public class LoginPageObjects extends Init {
    LandingPageObjects landingPage = new LandingPageObjects();

    public LoginPageObjects() {
        PageFactory.initElements(driver, this);
    }
    JSWaiter jswait = new JSWaiter();

    @FindBy(id = "username")
    private WebElement emailFiled;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(id = "loginButton")
    private WebElement loginButton;
    @FindBy(xpath = "//input[@value='Sign in']")
    private WebElement signup;

    String warningMsg = "//div[@id='responseMessage']";

    public void enterEmail(String username) throws InterruptedException {
        jswait.loadSendKeys(emailFiled, username);
    }
    public void enterPassword(String password) throws InterruptedException {
        jswait.waitUntil(signup);
        jswait.loadSendKeys(passwordField, password);
    }
    public void clickLoginButton() throws InterruptedException {
        jswait.loadClick(loginButton);
    }

    public boolean checkLogin() throws InterruptedException {
        Thread.sleep(3000);
        try {
            landingPage.createNote();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    /*
     * To verify the validation message for login
     */
    public boolean getWarningMsg() throws InterruptedException, UnsupportedFlavorException, IOException {
        String msg = jswait.getTextFromElement(warningMsg);
        if (msg.contains("There is no account for the username")) {
            return true;
        } else {
            return false;
        }
    }
    
    public void login(String email, String password) throws InterruptedException {
        enterEmail(email);
        clickLoginButton();
        enterPassword(password);
        clickLoginButton();
    }

    public void login(String email) throws InterruptedException {
        enterEmail(email);
        clickLoginButton();
    }
}