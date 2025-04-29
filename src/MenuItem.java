
/**
 *
 * @author latifah
 */
import java.io.Serializable;
public abstract class MenuItem implements Serializable{

  
    
    protected String name; // name of the items
    protected double price; // price of the item
   
    public MenuItem(String name, double price){
        this.name=name;
        this.price=price;
    }
    
    public abstract void displayItem(); // abstract method

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
    
    
}
