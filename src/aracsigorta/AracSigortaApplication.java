package aracsigorta;

import java.util.InputMismatchException;
import java.util.Scanner;
/*
Proje: Araç Sigorta Prim Hesaplama
       Araç tipleri:otomobil, kamyon, otobüs, motosiklet
                    -otobüs: 18-30 koltuk veya 31 ve üstü koltuk
       Tarife dönemi:Aralık 2022,Haziran 2022
       1.dönemi: Haziran 2022               2.dönem: Aralık 2022
          otomobil: 2000                       otomobil: 2500
          kamyon:   3000                       kamyon:   3500
          otobüs: tip1: 4000 tip2: 5000        otobüs: tip1: 4500 tip2: 5500
          motosiklet: 1500                     motosiklet: 1750
        Hatalı girişte hesaplama başarısız uyarsı verip tekrar menü gösterilsin.
 */
public class AracSigortaApplication {
    public static void main(String[] args) {

        start();
    }

    public static void start() {
        Scanner input = new Scanner(System.in);
        boolean isFail;
        do {
            isFail = false;
            // menü ve tarife dönemi seçimi
            System.out.println("---Zorunlu Araç Sigorta Primi Hesaplama ---");
            System.out.println("Tarife dönemi seçiniz: ");
            System.out.println("1. Haziran 2022");
            System.out.println("2. Aralık 2022");

            // exception handle etme
            int term = 0;
                try{
                    term = input.nextInt();
                }catch (InputMismatchException e){
                    System.out.println("Geçersiz giriş!.. Lütfen bir sayı giriniz.");
                }
                input.nextLine();

            // tarife dönemi doğru ise devam yanlışsa uyarı ver ve başa dön
            if (term == 1 || term == 2) {
                // araç oluştur
                Arac arac = new Arac();
                System.out.println("Araç tipini giriniz: ");
                System.out.println("otomobil-kamyon-otobüs-motosiklet");
                arac.type = input.next().toLowerCase();
                arac.prim = arac.countPrim(term);

                String tarife = term == 1 ? "Haziran 2022" : "Aralık 2022";
                if (arac.prim != 0) {
                    System.out.println("Hesaplama başarıyla tamamlandı.");
                    System.out.println("Araç Tipi : " + arac.type);
                    System.out.println("Tarife Dönemi: " + tarife);
                    System.out.println("Aracınızın ilgili dönem sigorta primi: " + arac.prim);
                    isFail = isAgain(input);


                } else {
                    System.out.println("Hesaplama başarısız. Tekrar deneyiniz.");
                    isFail = isAgain(input);
                }

            } else {
                System.out.println("Hatalı giriş!");
                isFail = isAgain(input);
            }

        } while (isFail);
        System.out.println("İyi günler dileriz");

    }

    private static boolean isAgain(Scanner input) {
        int select;
        boolean isFail;
        System.out.println("Yeni işlem için - 1 \nÇıkış için - 0");
        select = input.nextInt();
        isFail = select == 1;
        return isFail;
    }
}
