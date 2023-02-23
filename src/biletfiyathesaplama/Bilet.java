package biletfiyathesaplama;

public class Bilet {

    public int distance;
    public int typeNo;
    public int seatNo;
    public double price;


    public void printBilet(Bus bus){
        System.out.println("Toplam tutar: "+price);
        System.out.println("--------------- Bilet Detay ---------------");
        System.out.println("Otobüs Plaka  : "+bus.numberPlate);
        System.out.println("Mesafe        : "+distance);
        System.out.println("Yolculuk Tipi : "+(typeNo==1 ? "Tek Yön":"Gidiş-Dönüş"));
        System.out.println("Koltuk No     : " +seatNo);
        System.out.println("-------------------------------------------");
        System.out.println("Keyifli Yolculuklar Dileriz...");

    }
}
