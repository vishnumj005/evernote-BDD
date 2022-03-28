package baseClasses;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Init {
    public static WebDriver driver;
    public static PropHandler p = new PropHandler();

    public static void init() throws InterruptedException, FileNotFoundException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    public static void initPropFile() {
        p.setPropertyFile("config.properties");
    }

}