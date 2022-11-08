package dat.backend.model.entities;
import java.text.NumberFormat;
import java.util.ArrayList;

public class Basket {

    private ArrayList<Cupcake> cupcakeArrayList = new ArrayList<>();
    private int sum;


    public ArrayList<Cupcake> getCupcakeArrayList() {
        return cupcakeArrayList;
    }

    public void setCupcakeArrayList(ArrayList<Cupcake> cupcakeArrayList) {
        this.cupcakeArrayList = cupcakeArrayList;
    }

    public void addToBasket(Cupcake cupcake){
        cupcakeArrayList.add(cupcake);
    }


    public int calcTotalprice() {
        sum = 0;

        for (Cupcake c : cupcakeArrayList) {
            sum += c.calcPrice();
        }
        return sum;
    }





    public ArrayList removeCupcake() {
        if (cupcakeArrayList != null) {
            cupcakeArrayList.remove(1);
        }
        return cupcakeArrayList;
    }

    public void editAmount() {


    }
}
