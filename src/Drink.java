/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author latifah
 */
public class Drink extends MenuItem {
    
    //indcates wether the drink is cold or hot
    private boolean isCold;
    
    //constractor for the Drink 
    public Drink(String name, double price, boolean isCold ){
       super(name,price);
        this.isCold=isCold;
    }
    //if the drink is cold return true , if its hot return false
    public boolean getIsCold() {
        return isCold;
    }
    
    
    @Override
    public void displayItem(){
        String coldORhot =isCold?"Cold":"Hot";
        System.out.println(name+"      "+price+" SAR"+" ("+coldORhot+" Drink) ");
    }
    

           
}
