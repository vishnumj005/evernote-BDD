package baseClasses;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JSWaiter extends Init {

    public void loadSendKeys(WebElement element, String key) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 20);

        try {
            wait.until(ExpectedConditions.visibilityOf(element)).clear();
            wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(key);
        } catch (Exception secondTry) {
            System.out.println("messsage5:" + secondTry.getMessage());
            Thread.sleep(2000);
            wait.until(ExpectedConditions.visibilityOf(element)).clear();
            wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(key);
        }
    }
    public void loadClick(WebElement element) throws InterruptedException {
        clickElement(element);
    }
    public void clickElement(WebElement element) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        } catch (Exception secondTry) {
            TimeUnit.SECONDS.sleep(2);
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        }
    }
    public void waitUntil(WebElement element) throws InterruptedException {
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, 8);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public boolean checkClickable(WebElement element) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (Exception e1) {
            return false;
        }

    }
    public boolean checkVisibility(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getTextFromElement(String xpath) throws InterruptedException, UnsupportedFlavorException, IOException {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        String text = "";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        text = driver.findElement(By.xpath(xpath)).getText();
        return text;
    }
}