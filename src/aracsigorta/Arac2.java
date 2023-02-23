package aracsigorta;

import java.util.Scanner;

public class Arac2 {

    public String type;
    public int prim;

    public void countPrim(int term) {

        switch (this.type){
            case "otomobil":
                this.prim = term == 1 ? 2000 : 2500;
                break;
            case "kamyon":
                this.prim = term == 1 ? 3000 : 3500;
                break;
            case "otobüs":
                countBusPrim(term);
                break;
            case "motosiklet":
                this.prim = term == 1 ? 1500 : 1750;
                break;
            default:
                System.out.println("Hatalı Giriş");
                this.prim=0;
                break;
        }
    }

    public void countBusPrim(int term) {
        Scanner input= new Scanner(System.in);
        System.out.println("Lütfen otobüs tipini giriniz: ");
        System.out.println("1- (18-30 koltuk).\n2- (31 ve üzeri koltuk) ");
        int busType = input.nextInt();
        switch (busType){
            case 1:
                this.prim = term==1 ? 4000 : 4500;
                break;
            case 2:
                this.prim = term==1 ? 5000 : 5500;
                break;
            default:
                System.out.println("Hatalı Giriş");
                this.prim = 0;
                break;
        }
    }
}
