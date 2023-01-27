package testCase1;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class LoginAndSelectGraphicCard extends BaseDriver{

    @Test
    public void Test1()
    {
        driver.get("https://www.akakce.com/");


        WebElement signIn = driver.findElement(By.linkText("Giriş Yap"));
        signIn.click();

        WebElement ePosta = driver.findElement(By.cssSelector("input[id='life'][name='life']"));
        ePosta.sendKeys("john@gmail.com");

        WebElement sifre = driver.findElement(By.cssSelector("input[id='lifp'][type='password']"));
        sifre.sendKeys("John12341234");

        WebElement login = driver.findElement(By.cssSelector("input[type='submit'][value='Giriş yap']"));
        login.click();
        // did login

        // Ekran karti sepete ekle
        WebElement katgori = driver.findElement(By.xpath("//*[contains(@title, 'Kategoriler')]"));
        Actions actions = new Actions(driver);
        Action action = actions.moveToElement(katgori).click().build();
        MyFunc.Bekle(2);


        WebElement elektronik = driver.findElement(By.linkText("Elektronik"));
        actions.moveToElement(elektronik).click().build();
        MyFunc.Bekle(2);


        WebElement ekranKarti = driver.findElement(By.xpath("//*[contains(@alt, 'Ekran Kartı')]"));
        actions.click(ekranKarti).perform();

        driverBekleKapat();
    }


}
