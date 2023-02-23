package restaurantbillgenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 10- order işlemleri
public class OrderService {

    Scanner input = new Scanner(System.in);
    List<Order> orderList = new ArrayList<>();

    // 11- sipariş oluşturma

    public void createOrder(DishService dishService) {

        int dishCode;
        do {

            System.out.println("Ürün kodunu giriniz: (Çıkış için 0 giriniz.)");
            dishCode = input.nextInt();  // code ile ürünü bulmamız gerekiyor.-->12
            if (dishService.findByDishCode(dishCode) != null) {
                // ürün bulundu
                Dish dish = dishService.findByDishCode(dishCode);
                System.out.println("Adet giriniz: ");
                int number = input.nextInt();
                // bu yemek daha önce sipariş edilmiş mi?-->13
                Order order;
                if (findByOrderByDish(dish) != null) {
                    order = findByOrderByDish(dish);
                    order.numOfDish+=number;
                    order.setPrice();
                }else {
                    order = new Order(dish,number); // orderCode otomatik
                    order.setPrice();
                }

            }  // sipariş eklendikce altta listeyi görelim

            listOrders();


        } while (dishCode != 0);

    }
// Siparişleri listele
    private void listOrders() {
        this.orderList.
                forEach(order-> System.out.printf("Sipariş kodu:%-5s  Lezzet kodu:%-4s Lezzet adı:%-15s Adet:%-2s\n",
                        order.orderCode,order.dish.getCode(),order.dish.getName(),order.numOfDish));
    }

    // 13- dish bilgisi ile sipariş bulma
    private Order findByOrderByDish(Dish dish) {
        for (Order order : this.orderList) {
            if (order.dish.equals(dish)) {
                return order;
            }
        }
        return null;
    }

    // 15- Siparişleri iptal etme
    public void deleteOrder(){
        System.out.println("Sipariş kodunu giriniz");
        int code = input.nextInt();
        boolean isValid = true;
        for (Order order : orderList) {
            if (order.orderCode == code){
                System.out.println("İptal etmek istediğiniz miktar: ");
                int num = input.nextInt();
                if (order.numOfDish>num){
                    order.numOfDish -= num;
                    order.setPrice();
                    System.out.println("Sipariş iptal edildi.");

                } else if (order.numOfDish==num) {
                    this.orderList.remove(order);
                    System.out.println("Sipariş iptal edildi: "+order.dish.getName());
                }else{
                    System.out.println("Hatalı giriş!");
                }
                isValid = true;
                break;
            }else {
                isValid = false;
            }
        }
        if (!isValid){
            System.out.println("Sipariş kodu geçersiz");
        }
        System.out.println("");

    }

// 16- hesabı oluşturma
    public void printBill(){
        double total = 0;
        System.out.println("                       Lezzet Fişiniz           ");
        for (Order order : this.orderList) {
            System.out.printf("\"Sipariş kodu:%-5s  Lezzet kodu:%-4s Lezzet adı:%-15s Adet:%-2s Tutar:%-6s TL\n",
                    order.orderCode,order.dish.getCode(),order.dish.getName(),order.numOfDish,order.orderPrice);
            total+=order.orderPrice;
        }
        System.out.println("Toplam Tutar: "+total);
        System.out.println("Afiyet olsun...");

        this.orderList.clear();

    }


}
