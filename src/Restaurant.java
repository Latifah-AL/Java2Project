/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author latifah
 */
public class Restaurant {
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

       
                       
    
           
    
            

