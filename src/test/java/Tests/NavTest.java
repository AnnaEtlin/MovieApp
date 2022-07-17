package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NavTest {
    private WebDriver driver;
    @BeforeMethod
    public void startUp(){
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        driver = new ChromeDriver();
    }
    @AfterMethod
    public void tearDown()throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
    }
    @Test
    public void favoritesScreen () throws InterruptedException {
        driver.get("https://example.com");
        WebElement favoritesButton = driver.findElement(By.cssSelector("#favorites"));
        favoritesButton.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        WebElement pageTitle = driver.findElement(By.cssSelector("#title"));
        String title = pageTitle.getText();
        Assert.assertEquals(title, "Favorites");
    }
    @Test
    public void newScreen () throws InterruptedException {
        driver.get("https://example.com");
        WebElement newButton = driver.findElement(By.cssSelector("#new"));
        newButton.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        WebElement pageTitle = driver.findElement(By.cssSelector("#title"));
        String title = pageTitle.getText();
        Assert.assertEquals(title, "New");
    }
}
