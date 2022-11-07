package dat.backend.model.entities;

public class Bottom {

    int bottomid;
    String type;
    int price;


    public Bottom(int bottomid, String type, int price) {
        this.bottomid = bottomid;
        this.type = type;
        this.price = price;
    }

    public int getBottomid() {
        return bottomid;
    }

    public void setBottomid(int bottomid) {
        this.bottomid = bottomid;
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
