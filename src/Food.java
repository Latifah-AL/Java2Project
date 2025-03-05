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
    
    public Food(String name, double price, String category)
    {
        super(name,price);
        this.Cataegory=category;
    }
    public String getCategory()
    {
        return Cataegory;
    }
    
}
