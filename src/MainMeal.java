/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author latifah
 */
public class MainMeal extends Food {

    private String type; //type of meal griild , fried , baked
    
    public MainMeal(String name, double price, String type){
        super(name,price,"Main Meal");
        this.type=type;
    }
     public String getType() {
        return type;
    }
    @Override
      public void displayItem() {
        System.out.println(name + " -" + price + " SAR (" + type + " Main Meal)");
    }
    
}
