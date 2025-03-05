/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author latifah
 */
public class Order {
    
    private int orderID;
    private MenuItem[] items;
    private int itemCount;
    private double totalAmount;
    
    public Order(int orderID, int size){
        this.orderID=orderID;
        this.items=new MenuItem[size];
        this.itemCount=0;
        this.totalAmount=0.0;
    }
    
    // add item to the order
    public boolean addItem(MenuItem item){
        if(itemCount<items.length){
            items[itemCount++]=item;
        
            return true;
        }
        else {  
            System.out.println("Order is Full! Cannot add more items.");
            return false;
        }    
    }
    // calculate the total amount of the order
    public double CalculateTotal(){
        
        totalAmount=0.0;
        for(int i=0;i<itemCount;i++){
            totalAmount+=items[i].getPrice();
        }
        return totalAmount;
    }
    // Display the order details
    public void DisplayOrder(){
 
            System.out.println("-------------------------------");
            System.out.println("Order ID : "+this.getOrderID());
            System.out.println("Items: ");
            
            // Display info of each item
            for(int i=0;i<itemCount;i++){
                System.out.println(""+(i+1)+"- "+items[i].getName()+"    Price "+items[i].getPrice()+"SAR\n");
            }
            // Display the total amount
            System.out.println("\nTotal Amount: "+this.CalculateTotal()+"SAR\n");
            System.out.println("\n------------------------------------------------");
        
        
    }

    public int getOrderID() {
        return orderID;
    }
    
}