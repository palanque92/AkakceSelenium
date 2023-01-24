package Utility;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class MyFunc {

    public static double yuvarla(double gelenSayi){
        // 18.84955592153876
        // önce yuzle çarpsam  -> 1884.955592153876
        gelenSayi =gelenSayi*100;
        gelenSayi=Math.round(gelenSayi);// 1885
        //tekrar yuze bol -> 18.85
        gelenSayi =gelenSayi / 100;

        return gelenSayi;  // 18.85
    }

    // random

    // TODO : bu fonksiyona kaç hane ondalıklı
    // TODO : kısım istediğimizi ekleyelim

    public static void Bekle(int saniye){
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void Raporyukleniyor() {
        System.out.println("Muzik yukleniyor :)");
        String M = "";
        for (int i = 0; i <= 10; i++) {
            MyFunc.Bekle(1);
            System.out.print("\r" + "\033[42m" + M + "\033[0m" + " % " + (i * 10));
            M = M.concat("    ");
        }
        System.out.println();
    }
    public static void UygulamaYukleniyor() {
        System.out.println("Uygulama yukleniyor ...");
        String M = "";
        for (int i = 0; i <= 10; i++) {
            MyFunc.Bekle(1);
            System.out.print("\r" + "\033[42m" + M + "\033[0m" + " % " + (i * 10));
            M = M.concat("    ");
        }
    }
    public static void saat () {
        DateTimeFormatter f=DateTimeFormatter.ofPattern("hh:mm:ss");
        LocalTime saat = LocalTime.now();

        while (saat.getMinute() > 0 ) {
            saat = LocalTime.now();
            System.out.print("\r"+saat.format(f));
            MyFunc.Bekle(1);


        }
    }
}
