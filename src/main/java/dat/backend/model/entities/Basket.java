package dat.backend.model.entities;
import java.text.NumberFormat;
import java.util.ArrayList;

public class Basket {

    ArrayList<Cupcake> cupcakeArrayList;
    private Cupcake[] cart;
    private String cupcake;
    private int itemCount;
    private double totalPrice;
    private int capacity;
    private Topping Chocolate;
    private Bottom Nutmeg;



    public Basket(ArrayList<Cupcake> cupcakeArrayList, Cupcake[] cart, String cupcake, int itemCount, double totalPrice, int capacity, Topping chocolate, Bottom nutmeg) {
        this.cupcakeArrayList = cupcakeArrayList;
        this.cart = cart;
        this.cupcake = cupcake;
        this.itemCount = itemCount;
        this.totalPrice = totalPrice;
        this.capacity = capacity;
        Chocolate = chocolate;
        Nutmeg = nutmeg;
    }

    public void addToCart(String cupcake, double price, int quantity)
        {

            Cupcake temp = new Cupcake(Chocolate, Nutmeg, 5, 1, 1);
            totalPrice += (price * quantity);
            itemCount += quantity;
            cart[itemCount] = temp;
            if(itemCount==capacity)
            {
                increaseSize();
            }
        }


        public String toString()
        {
            NumberFormat fmt = NumberFormat.getCurrencyInstance();

            String contents = "\nShopping Cart\n";
            contents += "\nItem\t\tUnit Price\tQuantity\tTotal\n";

            for (int i = 0; i < itemCount; i++)
                contents += cart[i].toString() + "\n";

            contents += "\nTotal Price: " + fmt.format(totalPrice);
            contents += "\n";

            return contents;
        }


        private void increaseSize()
        {
            Cupcake[] temp = new Cupcake[capacity+3];
            for(int i=0; i < capacity; i++)
            {
                temp[i] = cart[i];
            }
            cart = temp;
            temp = null;
            capacity = cart.length;
        }

    public void removeCupcake() {

    }

    public void editAmount() {

    }
}
