package testCase2;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CategoriesFeatreTest  extends BaseDriver {
    //Click on category section, click on clothes section
    // sun glasses in electronicks and click on Ray-Ban RB3025 L2823 58 Erkek Güneş Gözlüğü and add to cart




    @Test
    public void Test1()
    {
        driver.get("https://www.akakce.com/");


        WebElement signIn = driver.findElement(By.linkText("Giriş Yap"));
       waitAndClick(signIn);

        WebElement mail = driver.findElement(By.cssSelector("[id='life'][type='email']"));
        waitAndSendkeys(mail,"john@gmail.com");


        WebElement password = driver.findElement(By.cssSelector("[id='lifp'][type='password']"));
        waitAndSendkeys(password,"John12341234");

        WebElement login = driver.findElement(By.cssSelector("[id='lfb'][type='submit']"));
        waitAndClick(login);

        WebElement signInControl=driver.findElement(By.cssSelector("[id='HM_v8']"));
        Assert.assertTrue("False",signInControl.getText().toLowerCase().contains("john"));




        Actions actions = new Actions(driver);
        WebElement Categories=driver.findElement(By.linkText("Kategoriler"));
         actions.moveToElement(Categories).build().perform();

waitUntilVisible(driver.findElement(By.linkText("Saat, Giyim, Aksesuar")));
        WebElement Clothes=driver.findElement(By.linkText("Saat, Giyim, Aksesuar"));
       actions.moveToElement(Clothes).build().perform();

        waitUntilVisible(driver.findElement(By.linkText("Güneş Gözlüğü")));
        WebElement glasses=driver.findElement(By.linkText("Güneş Gözlüğü"));
       waitAndClick(glasses);

       WebElement rayBan=driver.findElement(By.cssSelector("[alt='Ray-Ban Güneş Gözlüğü']"));

       waitAndClick(rayBan);


       WebElement rayBanGlass=driver.findElement(By.xpath("(//*[text()='Ray-Ban RB3025 L2823 58 Erkek Güneş Gözlüğü'])[1]"));
       waitAndClick(rayBanGlass);

WebElement saticiyaGit=driver.findElement((By.xpath("(//*[@class='iC xt_v8'])[1]")));
waitAndClick(saticiyaGit);

        List<String> windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(1));

        WebElement sepeteEkle=driver.findElement(By.xpath("(//*[@class='flex flex-row w-full md:w-auto']/button)[1]"));
        waitAndClick(sepeteEkle);

        WebElement message=driver.findElement(By.id("main"));

        System.out.println(message.getText());
        Assert.assertTrue("Test failed", message.getText().toLowerCase().contains("işlem başarılı"));





        driverBekleKapat();}

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

