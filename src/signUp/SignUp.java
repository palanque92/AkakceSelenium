package signUp;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SignUp extends BaseDriver{
    public static void main(String[] args) {

        driver.get("https://www.akakce.com/");

        WebElement hesapAc = driver.findElement(By.linkText("Hesap Aç"));
        hesapAc.click();

        WebElement ad = driver.findElement(By.xpath("(//span[1]/input)[3]"));
        Actions actions = new Actions(driver);
        actions.click(ad).perform();
        actions.sendKeys("John").perform();
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys("patriot").perform();
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys("john@gmail.com").perform();
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys("john@gmail.com").perform();
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys("John12341234").perform();
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys("John12341234").perform();
        actions.sendKeys(Keys.TAB).perform();

        WebElement radioButton = driver.findElement(By.xpath("(//input[@onclick='changeGenderChoice()'])[2]"));
        radioButton.click();

        WebElement il = driver.findElement(By.xpath("//span[8]/select"));
        Select select = new Select(il);
        select.selectByValue("35");

        WebElement ilce = driver.findElement(By.xpath("//span[9]/select"));
        Select select1 = new Select(ilce);
        select1.selectByValue("469");

        WebElement gun = driver.findElement(By.xpath("//span[1]/select"));
        Select select2 = new Select(gun);
        select2.selectByValue("2");

        WebElement ay = driver.findElement(By.xpath("//span[2]/select"));
        Select select3 = new Select(ay);
        select3.selectByValue("3");

        WebElement yil = driver.findElement(By.xpath("//span[3]/select"));
        Select select4 = new Select(yil);
        select4.selectByValue("1992");

        WebElement klnmSzlsmsi = driver.findElement(By.xpath("(//label/input)[3]"));
        klnmSzlsmsi.click();

        WebElement submit = driver.findElement(By.cssSelector("input[type='submit'][value='Hesap aç']"));
        submit.click();

        driverBekleKapat();
    }
}
