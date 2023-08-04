package services;

public class WhiskeyService {
    private int id;
    private String name;
    private String brand;
    private int qty;
    private float price;

    public WhiskeyService(){
        this(0,null,null,0,0);
    }
    public WhiskeyService (int id,String name,String brand, int qty,float price) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.qty = qty;
        this.price = price;
    }
}
