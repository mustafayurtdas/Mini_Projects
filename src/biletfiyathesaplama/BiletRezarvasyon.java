package biletfiyathesaplama;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
Project: mesafeye ve şartlara göre otobüs bileti fiyatı hesaplayan uygulama
         Kullanıcıdan Mesafe (KM), yaşı ve yolculuk tipi (Tek Yön, Gidiş-Dönüş)
         koltuk no  bilgilerini alın.
         Mesafe başına ücret 1 Lira / km olarak alın.(Gidiş-Dönüş için *2)
         Tekli Koltuk ücreti:Koltuk numarası 3 veya 3 ün katı ise bilet fiyatı %20 daha fazladır(1.2 Lira).
         İlk olarak uçuşun toplam fiyatını hesaplayın ve sonrasında ki koşullara göre müşteriye aşağıdaki kuralları uygulayın ;

        Kullanıcıdan alınan değerler geçerli (mesafe ve yaş değerleri pozitif sayı, yolculuk tipi ise 1 veya 2) olmalıdır.
        Aksi takdirde kullanıcıya "Hatalı Veri Girdiniz !" şeklinde bir uyarı verilmelidir.

       1- Kişi "Yolculuk Tipini" gidiş dönüş seçmiş ise son bilet fiyatı üzerinden %20 indirim uygulanır.
       2-Yaş indirimi:
        Kişi 12 yaşından küçükse son bilet fiyatı üzerinden %50 indirim uygulanır.
        Kişi 12-24 yaşları arasında ise son bilet fiyatı üzerinden %10 indirim uygulanır.
        Kişi 65 yaşından büyük ise son bilet fiyatı üzerinden %30 indirim uygulanır.

 */
public class BiletRezarvasyon {
    public static void main(String[] args) {

        Bilet bilet = new Bilet();
        Bus bus = new Bus("34 MAY 06");
        start(bilet, bus);

    }
    public static void start(Bilet bilet, Bus bus) {
        Scanner input = new Scanner(System.in);
        int select;

        do {
            select = -1;
            System.out.println("Bilet Rezervasyon Sistemine Hoş Geldiniz.");
            System.out.print("Lütfen gidilecek mesafeyi km olarak giriniz: ");
            bilet.distance = input.nextInt();
            System.out.println("Yolculuk tipini seçiniz: \n1- Tek yön\n2- Gidiş-Dönüş");
            bilet.typeNo = input.nextInt();
            System.out.println("Lütfen Yaşınızı giriniz:");
            int age = input.nextInt();
            System.out.println("Koltuk no seçiniz: ");
            System.out.println("Tekli koltuk fiyatı %20 daha fazladır.");
            System.out.println(bus.saets);
            bilet.seatNo = input.nextInt();
            bus.saets.remove(String.valueOf(bilet.seatNo));  // kullanıcının seçtiği koltuğu listeden kaldırdık. obje olarak, koltuk numaraları list te String olduğu için int i stringe çevirdik

            boolean check = bilet.typeNo == 1 || bilet.typeNo == 2 && bilet.distance>0 && age >0 ;

            if(check){
                bilet.price = getTotal(bilet,age);
                bilet.printBilet(bus);
            }else {
                System.out.println("Hatalı Giriş Yaptınız!");
            }
            System.out.println("Yeni İşlem için : 1\nÇıkış için : 0");
            select = input.nextInt();

        } while (select != 0);

        System.out.println("İyi günler dileriz..");

    }

    public static double getTotal(Bilet bilet, int age){

        int dist = bilet.distance;
        int type = bilet.typeNo;
        int seatNo = bilet.seatNo;
        double total = 0;

        switch (type){
            case 1 :
                if (seatNo%3==0){
                    total=dist*1.2;
                }else {
                    total=dist;
                }
                System.out.println("Tutar : "+total);
                break;
            case 2:
                if (seatNo%3==0){
                    total=dist*2.4;
                }else {
                    total=dist*2;
                }
                System.out.println("Tutar : "+total);
                total *=0.8;
                System.out.println("Çift yön indirimli Tutar : "+total);
                break;
        }
        if (age<=12){
            total /=2;
            System.out.println("Yaş indirimli Tutar : "+total);
        }else if(age<24){
            total *=0.9;
            System.out.println("Yaş indirimli Tutar : "+total);
        }else if(age>65){
            total *= 0.7;
            System.out.println("Yaş indirimli Tutar : "+total);
        }

        return total;
    }




}
