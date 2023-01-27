package testCase5;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;


public class ItemAddToCart extends BaseDriver {


    @Test
    public void itemAddTocart() {
        driver.get("https://www.akakce.com/");
        WebElement girisYap = driver.findElement(By.linkText("Giriş Yap"));
        girisYap.click();

        WebElement email = driver.findElement(By.id("life"));
        email.sendKeys("john@gmail.com");

        WebElement password = driver.findElement(By.name("lifp"));
        password.sendKeys("John12341234");

        WebElement loginBtn = driver.findElement(By.id("lfb"));
        loginBtn.click();
        WebElement kategoriler = driver.findElement(By.linkText("Kategoriler"));
        new Actions(driver).moveToElement(kategoriler).build().perform();
        WebElement elektronik = driver.findElement(By.linkText("Elektronik"));
        new Actions(driver).moveToElement(elektronik).build().perform();
        WebElement cepTelefonu = driver.findElement(By.linkText("Cep Telefonu"));
        cepTelefonu.click();
        WebElement  xiomiredminot= driver.findElement(By.xpath("//h3[text()=\"Xiaomi Redmi Note 11 Pro 128 GB 8 GB\"]"));
        xiomiredminot.click();

        WebElement saticiyagit = driver.findElement(By.xpath("(//b[text()=\"Satıcıya Git\"])[1]"));
        saticiyagit.click();
        MyFunc.Bekle(5);
       List<String> windows = new ArrayList<>(driver.getWindowHandles());
    driver.switchTo().window(windows.get(1));



       wait.until(ExpectedConditions.urlContains("pazarama"));



        WebElement sepeteEkle=driver.findElement(By.xpath("//div[@class=\"flex mb-5\"]/button"));
        wait.until(ExpectedConditions.elementToBeClickable(sepeteEkle));
        sepeteEkle.click();
         MyFunc.Bekle(3);
        WebElement sepetim = driver.findElement(By.xpath("(//span[@class=\"ml-2.5\"])[3]"));
        sepetim.click();

        WebElement sepeteGit=driver.findElement(By.cssSelector("a[href='/sepetim']"));
        sepeteGit.click();



        WebElement sepetValidate=driver.findElement(By.xpath("//a[@class='text-gray-600 text-sm font-bold block']"));
        Assert.assertTrue("sepetete aradiginiz urun yoktur",sepetValidate.getText().contains("Redmi Note"));
    }


}
