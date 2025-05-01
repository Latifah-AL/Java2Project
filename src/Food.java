

import java.io.Serializable;

public abstract class Food extends MenuItem implements Serializable {
    
    protected String Cataegory; // if the food is main meal or side meal
    
    public Food(String name, double price, String category)//consrtucter
    {
        super(name,price);//calls the super constructer
        this.Cataegory=category;//sets the category of the item
    }
    public String getCategory()//getter
    {
        return Cataegory;
    }
    
}




