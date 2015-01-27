import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GoogleTheDoodleTest {

    private WebDriver driver;
    private ScreenShooter shooter;

    @Before
    public void openBrowser() {
        String baseUrl = "http://www.google.com";
        driver = new FirefoxDriver();
        driver.get(baseUrl);
        shooter = new ScreenShooter();
    }

    @After
    public void closeBrowser() throws IOException {
        shooter.shoot( System.getProperty("user.dir") + "/screenshot.png");
        driver.quit();
    }

    @Test
    public void searchTheDoodle() {
        assertEquals("The page title should equal Google at the start of the test.", "Google", driver.getTitle());
        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys("The Doodle");
        searchField.submit();
        assertTrue((new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                return webDriver.getTitle().toLowerCase().startsWith("the doodle");
            }
        }));
    }

    private class ScreenShooter {

        void shoot(String fileName) throws IOException {
            File shot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(shot, new File(fileName));
        }
    }

}
