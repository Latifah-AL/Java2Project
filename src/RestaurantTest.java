/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author latifah
 */
import java.util.Scanner;
public class RestaurantTest {
    
   public static Scanner scanner = new Scanner(System.in);
   public static Restaurant myRestaurant= new Restaurant(5, 3);
   
    public static void main(String[] args) {
        
        boolean ch = true;
       
     
       
        // Create menu items
        Food burger = new MainMeal("Burger", 25.5, "Beef");
        Food fries = new SideMeal("Fries", 10.0, "Large");
        Drink cola = new Drink("Cola", 5.0, true);
        Drink tea = new Drink("Tea", 3.0, false);
        Food salad = new SideMeal("Salad", 15.0, "Medium");
       
        // Add items to the menu
        myRestaurant.addMenuItem(burger, 1);
        myRestaurant.addMenuItem(fries, 2);
        myRestaurant.addMenuItem(cola, 3);
        myRestaurant.addMenuItem(tea, 4);
        myRestaurant.addMenuItem(salad, 5);
       
        while (ch) {
            System.out.println("\n==========================================");
            System.out.println("Welcome to the Bite & Chill Ordering System");
            System.out.println("==========================================");
            System.out.println("1. View Menu");
            System.out.println("2. Create New Order");
            System.out.println("3. View Orders");
            System.out.println("4. Search for an Order");
            System.out.println("5. Cancel an Order");
            System.out.println("6. Exit");
            System.out.println("========================================");
            System.out.print("Choose an option: ");
           
            int choice = scanner.nextInt();
           
            switch (choice) {
                case 1:
                    myRestaurant.Displaymenu();
                    break;
                case 2:
                    CreateOrder();
                    break;
                case 3:
                    ViewOrder();
                    break;
                case 4:
                   SearchOrder();
                    break;
                case 5:
                    CancelOrder();
                    break;
                case 6:
                    ch = false;
                     System.out.println("Exiting the system. Thank you for using Bite & Chill Ordering System!");
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
                    break;
            }
        }
       
       
    }
    
    public static void CreateOrder(){
        System.out.println("\nCreating a new order...");
                    System.out.print("How many items do you want to order? ");
                    int orderSize = scanner.nextInt();
                    Order userOrder = myRestaurant.createOrder(orderSize);
                    
                    if (userOrder != null) {
                        
                        myRestaurant.Displaymenu(); // displaying menu for the user
                        for (int i = 0; i < orderSize; i++) {
                            System.out.print("\nEnter an item from the menu (by number): "); 
                            int itemIndex = scanner.nextInt();
                            MenuItem[] menu = myRestaurant.getMenu(); // Use getter
                            if (itemIndex >= 0 && itemIndex < menu.length && menu[itemIndex] != null) {
                                userOrder.addItem(menu[itemIndex]);
                            } else {
                                System.out.println("Invalid number, try again.");
                                i--;
                            }
                        }
                        System.out.println("\nOrder Created Successfully!");
                        userOrder.DisplayOrder();
                    }
    }
    
    public static void ViewOrder(){
        Order[] orders = myRestaurant.getOrders(); // Use getter
                    for (int i = 0; i < myRestaurant.getordercount(); i++) {
                        if (orders[i] != null) {
                            orders[i].DisplayOrder();
                        }
                    }
    }
    
    public static void SearchOrder(){
         System.out.print("Enter the order ID to search for: ");
                    int searchId = scanner.nextInt();
                    Order foundOrder = myRestaurant.SearchOrder(searchId);
                    if (foundOrder != null) {
                        foundOrder.DisplayOrder();
                    } else {
                        System.out.println("Order not found.");
                    }
    }
    
    public static void CancelOrder(){
        System.out.print("Enter the order ID to cancel: ");
                    int cancelId = scanner.nextInt();
                    if (myRestaurant.cancleOrder(cancelId)) {
                        System.out.println("Order successfully canceled.");
                    } else {
                        System.out.println("Failed to cancel order. Check the entered ID.");
                    }
    }
}