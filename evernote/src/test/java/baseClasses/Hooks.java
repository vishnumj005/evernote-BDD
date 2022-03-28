package baseClasses;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

/*
 * This class is to Run pre and post conditions (login and logout)
 */
public class Hooks extends Init {
    @Before("@initBrowser")
    public static void beforeSuite() throws InterruptedException, MalformedURLException, FileNotFoundException {
        Init.init();
    }

    @After("@closeBrowser")
    public void afterClass(Scenario scenario) throws InterruptedException {
        driver.quit();

    }
}