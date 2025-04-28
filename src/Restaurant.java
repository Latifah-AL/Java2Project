/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author latifah
 */
import java.io.Serializable;
import java.util.*;
import java.io.*;
public class Restaurant implements Serializable {
    private int ordercount;//counter for the number of order placed
    private MenuItem  [] Menu; //an array with menuitem
   private  Order  [] Orders ; //an array that fills orders
   public  Restaurant (int menusize, int maxOrders) //constractor
   {       
       this.Menu= new MenuItem[menusize];//set size
       this.Orders=new Order[maxOrders];//set size
       this.ordercount=0;//sets counter to zero
   }
   public void Displaymenu()//to print all item info
   {
       System.out.println("\nMenu:");
       int i=1;
       for(MenuItem item : Menu ) {
           if ( item !=null) {//if there is an item it will print it if it is null then it wont
               System.out.print(i+++" - ");item.displayItem();
           }
           }
       }
   public Order createOrder(int size) //creats an order if there is space
   {
       if(ordercount >= Orders.length) 
       {
            System.out.println("Cannot create more orders. Maximum limit reached.");
            return null;
       }
       Order newOrder= new Order(ordercount +1, size);
               Orders[ordercount]=newOrder;
               ordercount++;
               return newOrder;
   }
   public boolean cancleOrder (int orderId)//cancles an order that was already placed
   {
       for(int i=0; i<ordercount; i++)
       {
           if(Orders[i] != null && Orders[i].getOrderID() == orderId)
           {
               Orders[i]=null;
               return true;
           }
           }
          
           return false;
   }
   public Order SearchOrder(int orderId)//looks up an order that was already placed else it will print a message
   {
       for (Order order : Orders)
       {
           if(order !=null && order.getOrderID() ==orderId)
           {
               return order;
           }
       }
       return null;
   }
   public boolean addMenuItem (MenuItem item, int index)//it will add a menu item to the array
   {
       if (index >= 0 && index < Menu.length)
       {
           Menu[index]=item;
           return true;
       }
       return false;
   }
   public int getordercount() //setters and getters for the private attributs
   {
       return ordercount;
           }
   // Retrieves a menu item based on index
public MenuItem getMenuItem(int index) {//if the index recived was not 0 and less than the length it will return it
    if (index >= 0 && index < Menu.length) {
        return Menu[index]; // Return menu item if index is valid
    }
    return null; // Return null if index is out of bounds
}
public Order[] getOrders() {//getter
    return Orders;
}
public MenuItem [] getMenu() {//getter
    return Menu;
}
}
/*public void saveallInformation()
{
    try{
        File out=new File("Menu.dat");
        FileOutputStream fos=new FileOutputStream(out);
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        oos.writeObject(headMenuItem);
        oos.close();
        File out2-new File(" Orders.dat");

        FileOutputStream fos2=new FileOutputStream (out2);
        ObjectOutputStream oos2=new ObjectOutputStream(fos2);
        oos2.writeObject(  Orders );
        oos.close();
        
    }
    catch(IOException e){
        System.out.println(e.toString());
}
}
public void readallDATA()
{
    try
    {
        File f=new File("Menu.dat");
        FileInputStream ff=new FileInputStream(f);
        ObjectInputStream in=new ObjectInputStream(ff);
        headMenuItem=(Node) in.readObject();
        in.close();
        File f2=new File("Orders.dat");
         FileInputStream ff2=new FileInputStream(f2);
        ObjectInputStream in2=new ObjectInputStream(ff2);
        Orders=(Orders[]) in2.readObject();
        in2.close();
        System.out.println("all data in the files have been loaded");
   
    }
    catch(ClassNotFoundException ex)
    {
        System.out.println(ex.toString());
    }
    catch(IOException e)
    {
        System.out.println(e.toString());
    }
}*/




       
                       
    
           
    
            

