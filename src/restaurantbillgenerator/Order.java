package restaurantbillgenerator;

public class Order {

    public static int counter = 1000;
    public int orderCode;
    public int numOfDish;
    public double orderPrice;
    public Dish dish;

    // 8- yemek ve adet parametreleri ile obje oluşturalım
    public Order(Dish dish,int numOfDish){
        counter++;
        this.orderCode = counter;
        this.dish = dish;
        this.numOfDish = numOfDish;
    }

    // 9- sipariş fiyatını hesapla
    public void setPrice(){
        this.orderPrice = this.dish.getPrice()*this.numOfDish;
    }

}
