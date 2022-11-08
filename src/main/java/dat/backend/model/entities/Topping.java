package dat.backend.model.entities;

public class Topping {

    private int toppingid;
    private String type;
    private int price;


    public Topping(int toppingid, String type, int price) {
        this.toppingid = toppingid;
        this.type = type;
        this.price = price;
    }

    public int getToppingid() {
        return toppingid;
    }

    public void setToppingid(int toppingid) {
        this.toppingid = toppingid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}



