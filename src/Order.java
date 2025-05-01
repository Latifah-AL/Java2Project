


    

/**
 *
 * @author latifah
 */
import java.io.Serializable;
import java.io.*;
public class Order implements Serializable {

    private int orderID; // id of the order 
    private MenuItem[] items; // array to save the items of the order 
    private int itemCount; // count how many item in the order
    private double totalAmount; // calculate total amount for the order
    
    public Order(int orderID, int size){
        
        this.orderID=orderID;
        this.items=new MenuItem[size];
        this.itemCount=0;
        this.totalAmount=0.0;
    }
    
    // add item to the order
    public boolean addItem(MenuItem item){
        if(itemCount<items.length){ // check if the array is full 
            items[itemCount++]=item;
        
            return true;
        }
        else {  
            System.out.println("Order is Full! Cannot add more items."); // wil display a message only if the array is full
            return false;
        }    
    }
    // calculate the total amount of the order
    public double CalculateTotal(){
        
        totalAmount=0.0;
        for(int i=0;i<itemCount;i++){
            totalAmount+=items[i].getPrice(); // calculate price for each item and add it to the total 
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