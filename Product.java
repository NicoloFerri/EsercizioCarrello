package javabasics.Online_shopping_cart;

public class Product {
    String name;
    double price;
    int quantity;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }



    public Product(String name , double price , int quantity){
        this.name=name;
        this.price=price;
        this.quantity=quantity;
    }

    double getTotalPrice(){
        return price*quantity;
    }


}
