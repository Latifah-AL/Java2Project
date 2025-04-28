/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author latifah
 */
import java.io.Serializable;
public abstract class MenuItem implements Serializable{
    
    protected String name;
    protected double price;
   
    public MenuItem(String name, double price){
        this.name=name;
        this.price=price;
    }
    
    public abstract void displayItem();

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
    
    
}
