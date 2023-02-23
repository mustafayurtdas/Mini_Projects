package aracsigorta;

import java.util.Scanner;

public class Arac {

    public String type;
    public int prim;

    public int countPrim(int term){
        if (term==1){
            switch (type){
                case "otomobil":
                    prim = 2000;
                    break;
                case "kamyon":
                    prim = 3000;
                    break;
                case "otobüs":
                    prim = countBusPrim(term);
                    break;
                case "motosiklet":
                    prim = 1500;
                    break;
                default:
                    System.out.println("Hatalı Giriş!");
                    prim = 0;
                    break;
            }

        }else if (term==2){

            switch (type){
                case "otomobil":
                    prim = 2500;
                    break;
                case "kamyon":
                    prim = 3500;
                    break;
                case "otobüs":
                    prim = countBusPrim(term);
                    break;
                case "motosiklet":
                    prim = 1750;
                    break;
                default:
                    System.out.println("Hatalı Giriş!");
                    prim = 0;
                    break;
            }

        }else {
            System.out.println("Hatalı giriş!");
        }
        return prim;
    }

    public int countBusPrim(int term){
        Scanner input= new Scanner(System.in);
        System.out.println("Lütfen otobüs tipini giriniz: ");
        System.out.println("1- (18-30 koltuk).\n2- (31 ve üzeri koltuk) ");
        int busType = input.nextInt();
        switch (busType){
            case 1:
                if (term==1){
                    prim = 4000;
                }else {
                    prim = 4500;
                }
                break;
            case 2:
                if (term==1){
                    prim = 5000;
                }else {
                    prim = 5500;
                }
                break;
        }
        return prim;
    }

}
