package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriver {
     public static WebDriver driver;

     public static WebDriverWait wait;

     static
     {
         KalanOncekileriKapat();



         // ilk adimda calisan kod kismi
         Logger logger = Logger.getLogger(""); // butun loglara ulastim
         logger.setLevel(Level.SEVERE); // sadece errorlari goster

         System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");  // ChromeServici sessiz modda çalıştır
         System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
         driver = new ChromeDriver(); // web sayfasini kontrol eden gorevli

         driver.manage().window().maximize(); // ekrani max yapiyor
         driver.manage().deleteAllCookies(); // sitenin senin bilgisayarinda yaptigi ayarlar siliniyor

         Duration dr = Duration.ofSeconds(30);
         driver.manage().timeouts().pageLoadTimeout(dr); // sadece tum sayfanin kodlarinin bilgisayariniza inmesi suresiyle ilgili
         // bu eklenmezse Selenium sayfa yuklenene kadar (sonsuza) bekler. : 30 sn suresince sayfanin yuklenmesini bekle yuklenmezse hata verir
         // eger 2 sn yuklerse 30sn. beklemez.

         driver.manage().timeouts().implicitlyWait(dr); // Butun webelementlerin elemnt bazinda , elemente ozel islem yapilmadan once
         // hazir hale gelmesi verilem muhlet yani sure.

         wait=new WebDriverWait(driver,Duration.ofSeconds(10));



     }
     public static void driverBekleKapat ()
     {
         MyFunc.Bekle(3);
         driver.quit();
     }
    public static void KalanOncekileriKapat() {

        try {
            Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
        } catch (Exception ignored) {

        }
    }
}
