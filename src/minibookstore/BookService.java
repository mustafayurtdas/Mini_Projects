package minibookstore;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//2-a: bookla ilgili işlemler
public class BookService implements ProductService{

    Scanner input = new Scanner(System.in);
    // 3- bookları saklamak için list oluştur
    List<Book> books = new ArrayList<>();
    // 4- başlangıçta sistemde mevcut kitaplar olsun.
    public BookService(){
        Book book1 = new Book("Fareler ve İnsanlar","120 TL",15,"J.Steinbeck","Penguin","A111");
        Book book2=new Book("Sefiller","150 TL",5,"V.Hugo","Penguin","A222");
        Book book3=new Book("Suç ve Ceza","120 TL",15,"Dostoyevski","Dream","A333");
        this.books.add(book1);
        this.books.add(book2);
        this.books.add(book3);   }

    @Override
    public void processMenu() {
        int choice;
        do {
            System.out.println("----------------");
            System.out.println("1-Kitapları Listele");
            System.out.println("2-Kitap Ekleme");
            System.out.println("3-Kitap Sil");
            System.out.println("4-Yayınevine Göre Filtrele");
            System.out.println("0-Geri Dön");
            System.out.println("Seçiminiz: ");
            choice= input.nextInt();
            input.nextLine();
            switch (choice){
                case 1:
                    listProduct();
                    break;
                case 2:
                    addProduct();
                    break;
                case 3:
                    deleteProduct();
                    break;
                case 4:
                    System.out.println("Yayınevi : ");
                    filterProducts(input.nextLine());
                    break;
                case 0:
                    System.out.println("Ana menüye yönlendiriliyorsunuz...");
                    break;
                default:
                    System.out.println("Hatalı giriş");
                    break;
            }

        }while (choice!=0);

    }
// 6: kitapları formatla yazdıralım
    @Override
    public void listProduct() {
        System.out.println("------------------------------------------------------");
        System.out.printf("%-2s | %-20s | %-15s | %-10s | %-4s | %-12s | %-3s\n",
                "ID","Kitap Adı","Yazar Adı","Yayınevi","ISBN","Birim Fiyatı","Stok");
        System.out.println("------------------------------------------------------");
        this.books.
                forEach(book ->System.out.printf("%-2s | %-20s | %-15s | %-10s | %-4s | %12s | %3s\n",
                book.getId(),book.getName(),book.getAuthorName(),book.getPublisher(),
                        book.getIsbn(),book.getPrice(),book.getStock()));
        System.out.println("------------------------------------------------------");

    }
// 7: yeni kitap ekle
    @Override
    public void addProduct() {
        System.out.println("ISBN: ");
        String isbn = input.nextLine();
        boolean isExists=false;
        for (Book book : this.books) {
            if (book.getIsbn().equals(isbn)){
                System.out.println("Bu kitap sistemde zaten kayıtlı, " +
                        "lütfen ürün güncelleme yapınız.");
                isExists = true;
                break;
            }
        }
        if (!isExists){
            System.out.println("Kitap Adı: ");
            String name = input.nextLine();
            System.out.println("Yazar Adı: ");
            String author = input.nextLine();
            System.out.println("YAyınevi: ");
            String publisher = input.nextLine();
            System.out.println("Birim Fiyatı: ");
            String price = input.nextLine();
            System.out.println("Stok: ");
            int stock = input.nextInt();
            input.nextLine();
            Book newBook = new Book(name,price,stock,author,publisher,isbn);
            this.books.add(newBook);
        }
        listProduct();

    }

    // updateProduct: stok artırma/azaltma,birim fiyatı
// 8: kullanıcıdan alınan id ile ürünü bulalım ve listeden silelim
    @Override
    public void deleteProduct() {

        boolean isExists = true;
        System.out.println("Kitap id: ");
        int id = input.nextInt();

        for (Book book : this.books) {
            if (book.getId()==id){
                isExists = true;
                this.books.remove(book);
                System.out.println("Ürün silindi.");
                break;
            }else {
                isExists =false;
            }
        }
        if (!isExists){
            System.out.println("Ürün bulunamadı!..");
        }



    }
// 9: kitapları yayınevine göre filtrele
    @Override
    public void filterProducts(String filter) {
/*
        this.books.
                stream().
                filter(book -> book.getPublisher().equalsIgnoreCase(filter)).
                forEach(book -> System.out.printf("%-2s | %-20s | %-15s | %-10s | %-4s | %12s | %3s\n",
                        book.getId(),book.getName(),book.getAuthorName(),book.getPublisher(),
                        book.getIsbn(),book.getPrice(),book.getStock()));
*/
int counter = 0;
        for (Book book : this.books) {
            if (book.getPublisher().equalsIgnoreCase(filter)){
                System.out.printf("%-2s | %-20s | %-15s | %-10s | %-4s | %12s | %3s\n",
                        book.getId(),book.getName(),book.getAuthorName(),book.getPublisher(),
                        book.getIsbn(),book.getPrice(),book.getStock());
                counter++;
            }
        }
        if (counter==0){
            System.out.println("Ürün bulunamadı!..");
        }

    }


}
