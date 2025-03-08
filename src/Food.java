/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */



/**
 *
 * @author imusn
 */
public abstract class Food extends MenuItem {
    
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
