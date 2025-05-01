import java.io.*;

import java.io.Serializable;
public class Restaurant implements Serializable {
    private int ordercount;//counter for the number of order placed
    Node headMenuItem; // Head of the linked list storing menu items
   private  Order  [] Orders ; //an array that fills orders
   private int menuSize;
   
   public  Restaurant (int menusize, int maxOrders) //constractor
   {       
       headMenuItem = null;
       this.menuSize=menusize;
       
       this.Orders=new Order[maxOrders];//set size
       this.ordercount=0;//sets counter to zero
   }
   
   public void Displaymenu()//to print all item info
   {
       System.out.println("\nMenu:");
       int i=1;
       Node current = headMenuItem; // Start from the head
       
       while (current != null) { // Traverse the linked list
        System.out.print(i++ + " - ");
        current.getData().displayItem(); // display the MenuItem inside the Node
        current = current.getNext(); // Move to the next node
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
   
   public int countMenuItems(){
       if(headMenuItem== null)
           return 0;
       int count =0;
       Node current = headMenuItem;
       while(current!= null){
           count++;
           current = current.getNext();
       }
       return count;
           
   }
   public MenuItem getMenuItemByNumber(int number) {
    Node current = headMenuItem;
    int count = 1;

    while (current != null) {
        if (count == number) {
            return current.getData();
        }
        count++;
        current = current.getNext();
    }
    return null; // Not found
    }
   
  public boolean removeMenuItem(String name) {
    if (headMenuItem == null || name == null) {
        return false; // No items or invalid name
    }

    // If the head node matches
    if (headMenuItem.getData().getName().equalsIgnoreCase(name)) {
        headMenuItem = headMenuItem.getNext(); // Remove head
        return true;
    }

    Node current = headMenuItem;
    // Traverse the list and look ahead
    while (current.getNext() != null) {
        if (current.getNext().getData().getName().equalsIgnoreCase(name)) {
            current.setNext(current.getNext().getNext()); // Skip the node
            return true;
        }
        current = current.getNext();
    }

    return false; // Not found
}


   
   
   public boolean addMenuItem(MenuItem item) throws MenuFullEx// it will add a menu item to the linked list 
   {
       
         if (countMenuItems() >= menuSize) {
          throw new MenuFullEx("Can not add any more items,Menu is full");
}
            Node newNode = new Node(item);
            newNode.setNext(headMenuItem);
            headMenuItem = newNode;
            return true;
            }
       

   public int getordercount() //setters and getters for the private attributs
   {
       return ordercount;
           }
   // Retrieves a menu item based on index
    public MenuItem getMenuItem(int index) { // if the index received is valid, it will return the item from the linked list
    if (index < 0) {
        return null; // Invalid index
    }

    Node current = headMenuItem;
    int currentIndex = 0;

    while (current != null) {
        if (currentIndex == index) {
            return current.getData(); // Found the item at the index
        }
        current = current.getNext();
        currentIndex++;
    }

    return null; // Index out of bounds
}

    public Order[] getOrders() {//getter
    return Orders;
}
    public Node getHeadMenuItem() { // getter for the linked list
    return headMenuItem;
}
    public void saveallInformation() {
        try (FileOutputStream fos = new FileOutputStream("Menu.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos)) {
           oos.writeObject(headMenuItem);
       } catch (IOException e) {
           System.out.println("Error saving menu: " + e.toString());
       }

           try (FileOutputStream fos2 = new FileOutputStream("Orders.dat");
            ObjectOutputStream oos2 = new ObjectOutputStream(fos2)) {
           oos2.writeObject(Orders);
       } catch (IOException e) {
           System.out.println("Error saving orders: " + e.toString());
       }
   }

    public void readallDATA() {
        try (FileInputStream ff = new FileInputStream("Menu.dat");
             ObjectInputStream in = new ObjectInputStream(ff)) {
            headMenuItem = (Node) in.readObject();
        } catch (ClassNotFoundException ex) {
            System.out.println("Class not found: " + ex.toString());
        } catch (IOException e) {
            System.out.println("Error reading menu: " + e.toString());
        }

        try (FileInputStream ff2 = new FileInputStream("Orders.dat");
             ObjectInputStream in2 = new ObjectInputStream(ff2)) {
            Orders = (Order[]) in2.readObject();
            System.out.println("All data in the files have been loaded");
        } catch (ClassNotFoundException ex) {
            System.out.println("Class not found: " + ex.toString());
        } catch (IOException e) {
            System.out.println("Error reading orders: " + e.toString());
        }
    }



    }