/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author latifah
 */
public class SideMeal extends Food {
    private String portionSize;
    public SideMeal(String name, double price, String Cataegory, String portionSize)
    {
        super(name,price,Cataegory);
        this.portionSize=portionSize;
    }
    public String getportionSize()
    {
        return portionSize;
    }
    public void displayItem() 
    {
        System.out.println("Side Meal:"+ getName()+ " Price:"+ getPrice()+" Category "+ getCategory()+"Portion Size:"+portionSize);
    }
    }

