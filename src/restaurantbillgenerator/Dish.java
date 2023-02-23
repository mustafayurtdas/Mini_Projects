package restaurantbillgenerator;

public class Dish {
    //yiyeceklerin field ları sadece okunsun.
    private int code;
    private String name;
    private double price;

    //yiyecek oluşturulurken özellikleri de set edilsin


    public Dish(int code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    // yadırmak için

    @Override
    public String toString() {
        return "code=" + code +
                ", name='" + name + '\'' +
                ", price=" + price ;
    }
}
