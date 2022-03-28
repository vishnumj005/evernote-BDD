package pageObjects;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClasses.Init;
import baseClasses.JSWaiter;

public class CreateNoteObjects extends Init {
    public CreateNoteObjects() {
        PageFactory.initElements(driver, this);
    }
    JSWaiter jswait = new JSWaiter();

    @FindBy(xpath = "//button[@aria-label='New Note']")
    private WebElement createNote;
    @FindBy(xpath = "//textarea[@placeholder='Title']")
    private WebElement txtTitle;
    @FindBy(xpath = "//div[@class='para']")
    private WebElement noteContent;
    @FindBy(xpath = "//div[@role='tabpanel']/div/article[1]")
    private WebElement viewNote;

    String titleText = "//article[1]/div/div/div[1]/span";
    String txtContent = "//article[1]/div/div/div[2]/span";

    public void clickCreateNote() throws InterruptedException {
        jswait.clickElement(createNote);
    }

    public void addTitle(String title) throws InterruptedException {
        jswait.loadSendKeys(txtTitle, title);
    }

    public void addContent(String desc) throws InterruptedException {
        jswait.loadSendKeys(noteContent, desc);

    }
    
    /*
     *Add Note Title and Content
     */
    public void addNoteDetails(String title, String desc) throws InterruptedException {
        WebElement ele = (new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(By.id("qa-COMMON_EDITOR_IFRAME")));
        driver.switchTo().frame("qa-COMMON_EDITOR_IFRAME");

        addTitle(title);
        addContent(desc);
        Thread.sleep(5000);
        driver.switchTo().defaultContent();

    }

    public void viewNote() throws InterruptedException {
        jswait.clickElement(viewNote);
    }

    /*
     *Verify the Note Title
     */
    public boolean verifyTitle(String title) throws InterruptedException, UnsupportedFlavorException, IOException {
        String txt = jswait.getTextFromElement(titleText);

        if (txt.contains(title)) {
            return true;
        } else {
            return false;
        }
    }
}