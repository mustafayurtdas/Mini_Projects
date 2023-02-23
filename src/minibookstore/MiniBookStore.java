package minibookstore;

import java.util.Scanner;

/*
    Proje: Mini Book Store
    Online bir kitap market için ürün yönetim uygulaması yapınız.
    Kitap markette kitap ve defter satışı olacak, ancak ileride yeni ürün çeşidi eklenebilir olmalı.

    Kitap özellikleri: id, isim, birim fiyat, stok, yazar adı, yayınevi,isbn no
    Defter özellikleri: id, isim, birim fiyat, stok, marka, yaprak sayısı,ürün kodu

    Kullanıcı ilgili kategorideki ürünleri listeleyebilmeli
    Kullanıcı kategoriye göre ürün ekleyebilmeli,ürün mevcutsa uyarı verilmeli
    Kullanıcı ürünleri benzersiz numaralarına göre silebilmeli.
    Kullanıcı ürünleri marka(kitap) veya yayınevine göre filtreleyip listeleyebilmeli.
            */
public class MiniBookStore {

    public static void main(String[] args) {
        enter();

    }

    // 1-  product, book, notebook
    public static void enter() {
        Scanner input = new Scanner(System.in);
        int select;
        System.out.println("---  Mini Book Store ---");
        do {
            System.out.println("Ürün Yönetim Paneli");
            System.out.println("1- Kitaplar\n" +
                    "2- Defterler\n" +
                    "0- Çıkış\n" +
                    "Seçiminiz: ");
            select = input.nextInt();
            input.nextLine();
            ProductService service;

            switch (select){
                case 1:
                    service= new BookService();
                    service.processMenu();
                    break;
                case 2:
                    service = new NotebookService();
                    service.processMenu();
                    break;
                case 0:
                    System.out.println("İyi Günler Dileriz...");
                    break;
                default:
                    System.out.println("Hatalı giriş yaptınız!.");
            }
        }while(select != 0);


    }
}
