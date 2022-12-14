package dat.backend.model.entities;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Order {

    int orderid;
    int userid;
    int totalprice;
    Timestamp time;
    List<Cupcake> cupcakeList = new ArrayList<>();


    public Order(int orderid, int userid, int totalprice, Timestamp time) {
        this.orderid = orderid;
        this.userid = userid;
        this.totalprice = totalprice;
        this.time = time;
    }

    public Order() {

    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public List<Cupcake> getCupcakeList() {
        return cupcakeList;
    }

    public void setCupcakeList(List<Cupcake> cupcakeList) {
        this.cupcakeList = cupcakeList;
    }

    public int calcTotalprice() {
        totalprice = 0;

        for (Cupcake c : cupcakeList) {
            totalprice += c.calcPrice();
        }
        return totalprice;
    }
}
