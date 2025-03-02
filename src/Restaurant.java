/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author latifah
 */
public class Restaurant {
    private int ordercount;
    private MenuItem  [] Menu; 
   private  Order  [] Orders ; 
   public  Restaurant (int menusize, int maxOrders) //constractor
   {       
       this.Menu= new MenuItem[menusize];
       this.Orders=new Order[maxOrders];
       this.ordercount=0;
   }
   public void Displaymenu()
   {
       System.out.println("\nMenu:");
       int i=1;
       for(MenuItem item : Menu ) {
           if ( item !=null) {
               System.out.print(i+++" - ");item.displayItem();
           }
           }
       }
   public Order createOrder(int size) 
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
   public boolean cancleOrder (int orderId)
   {
       for(int i=0; i<ordercount; i++)
       {
           if(Orders[i] != null && Orders[i].getOrderID() == orderId)
           {
               Orders[i]=null;
               //System.out.println("Order"+orderId+"has been canceled");
               return true;
           }
           }
           //System.out.println("Order was not found");
           return false;
   }
   public Order SearchOrder(int orderId)
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
   public boolean addMenuItem (MenuItem item, int index)
   {
       if (index >= 0 && index < Menu.length)
       {
           Menu[index]=item;
           return true;
       }
       return false;
   }
   public int getordercount() 
   {
       return ordercount;
           }
   // Retrieves a menu item based on index
public MenuItem getMenuItem(int index) {
    if (index >= 0 && index < Menu.length) {
        return Menu[index]; // Return menu item if index is valid
    }
    return null; // Return null if index is out of bounds
}
public Order[] getOrders() {
    return Orders;
}
public MenuItem [] getMenu() {
    return Menu;
}

}

       
                       
    
           
    
            

