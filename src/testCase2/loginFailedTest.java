package testCase2;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
//Email valid password invalid User should be login failed
public class loginFailedTest extends BaseDriver {
    @Test
    public void Test1() {
        driver.get("https://www.akakce.com/");


        WebElement signIn = driver.findElement(By.linkText("Giriş Yap"));
        waitAndClick(signIn);

        WebElement mail = driver.findElement(By.cssSelector("[id='life'][type='email']"));
        waitAndSendkeys(mail, "john@gmail.com");


        WebElement password = driver.findElement(By.cssSelector("[id='lifp'][type='password']"));
        waitAndSendkeys(password, "John12378");

        WebElement login = driver.findElement(By.cssSelector("[id='lfb'][type='submit']"));
        waitAndClick(login);

        WebElement signInControl = driver.findElement(By.cssSelector("[class='alertX t2']>p"));
        wait.until(ExpectedConditions.textToBePresentInElement(signInControl, "Şifre doğru değil"));
        System.out.println(signInControl.getText());
        Assert.assertTrue("Test failed", signInControl.getText().toLowerCase().contains("Şifre doğru değil"));


    }




    public static void waitAndClick(WebElement element){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();

    }

    public  static  void waitAndSendkeys(WebElement element,String value){

        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(value);

    }
    public void waitUntilVisible(WebElement element)
    {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    }
