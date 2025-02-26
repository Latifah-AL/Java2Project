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
       System.out.println("Menu:");
       for(MenuItem item : Menu ) {
           if ( item !=null) {
               item.displayItem();
           }
           }
       }
   public Order createOrder(int size) 
   {
       if(ordercount >= Orders.length) 
       {
            System.out.println("can not add more orders,\n you have reached the limt");
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
               System.out.println("Order"+orderId+"has been canceled");
               return true;
           }
           }
           System.out.println("Order was not found");
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
       }
                       
    
           
    
            

