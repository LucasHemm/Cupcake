package dat.backend.model.entities;

public class Cupcake {

    Topping topping;
    Bottom bottom;
    int price;
    int orderid;
    int amount;


    public Cupcake(Topping topping, Bottom bottom, int price, int orderid, int amount) {
        this.topping = topping;
        this.bottom = bottom;
        this.price = price;
        this.orderid = orderid;
        this.amount = amount;
    }


    public Topping getTopping() {
        return topping;
    }

    public void setTopping(Topping topping) {
        this.topping = topping;
    }

    public Bottom getBottom() {
        return bottom;
    }

    public void setBottom(Bottom bottom) {
        this.bottom = bottom;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}


