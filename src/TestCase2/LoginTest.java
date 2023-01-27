package TestCase2;

import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class LoginTest extends BaseDriver {

    @Test
    public void loginTest() {
        driver.get("https://www.akakce.com/");
        WebElement girisYap = driver.findElement(By.linkText("Giriş Yap"));
        girisYap.click();

        WebElement email = driver.findElement(By.id("life"));
        email.sendKeys("john@gmail.com");

        WebElement password = driver.findElement(By.name("lifp"));
        password.sendKeys("John12341234");

        WebElement loginBtn = driver.findElement(By.id("lfb"));
        loginBtn.click();

        WebElement loginValidate = driver.findElement(By.linkText("John"));
        Assert.assertTrue("login basarisiz", loginValidate.getText().contains("John"));

        driverBekleKapat();
    }



}
