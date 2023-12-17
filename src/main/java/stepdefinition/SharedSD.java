package stepdefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.time.Duration;

import static util.ConfigReader.getUrl;

public class SharedSD {

    static WebDriver driver;
    @Before
    public void openUrl() throws IOException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(getUrl());
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

    @After
    public void closeBrowser()
    {
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
       // driver.close();
    }

    public static WebDriver getDriver()
    {
        return driver;
    }
}
