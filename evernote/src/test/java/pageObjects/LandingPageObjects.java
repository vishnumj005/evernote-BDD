package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClasses.Init;
import baseClasses.JSWaiter;

/*
 * 
 * The class is to verify the Login has been successful
 * In this class Verify the home page element to make sure the Login is success
 *
 */

public class LandingPageObjects extends Init {

    public LandingPageObjects() {
        PageFactory.initElements(driver, this);
    }
    JSWaiter jswait = new JSWaiter();

    @FindBy(xpath = "//button[@aria-label='New Note']")
    private WebElement newNote;

    public boolean createNote() throws InterruptedException {

        if (jswait.checkClickable(newNote)) {
            return true;
        } else {
            return false;
        }
    }

}