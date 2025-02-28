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
    
    public Drink(String name, double price, boolean isCold ){
       super(name,price);
        this.isCold=isCold;
    }

    public boolean getIsCold() {
        return isCold;
    }
    
    
    @Override
    public void displayItem(){
        String coldORhot =isCold?"Cold":"Hot";
        System.out.println(name+" -"+coldORhot+" Drink - "+price+"SAR");
    }
    

           
}
