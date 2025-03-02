/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author latifah
 */
//import java.util.Scanner;
//public class main {
//    
//    private static int nextOrderId = 1; // Auto-incrementing order ID
//    private static Restaurant restaurant; // Restaurant instance
//    private static Scanner scanner = new Scanner(System.in);
//    
//    public static void main(String[]args){
//        //objects here
//        
//
//        // Initialize restaurant with a menu size of 10 and max 5 orders
//        restaurant = new Restaurant(10, 5);
//        initializeMenu();
//
//        while (true) {
//            System.out.println("\n==========================================");
//            System.out.println(" Welcome to the Restaurant Ordering System");
//            System.out.println("==========================================");
//            System.out.println("1. Show Menu");
//            System.out.println("2. Create New Order");
//            System.out.println("3. Search for an Order");
//            System.out.println("4. Cancel an Order");
//            System.out.println("5. Exit");
//            System.out.println("------------------------------------------");
//            System.out.print("Enter your choice: ");
//            
//            int choice = scanner.nextInt();
//            scanner.nextLine(); // Consume newline
//
//            switch (choice) {
//                case 1:
//                    restaurant.Displaymenu(); 
//                    break;
//                case 2:
//                    createOrder();
//                    break;
//                case 3:
//                    searchOrder();
//                    break;
//                case 4:
//                    cancelOrder();
//                    break;
//                case 5:
//                    System.out.println("Exiting the system. Thank you for using the Restaurant Ordering System!");
//                    
//                    return;
//                default:
//                    System.out.println("Invalid choice! Please try again.");
//            }
//        }
//    }
//
//    
//    
//    
//    // Initialize the menu with sample items
//    private static void initializeMenu() {
//        restaurant.addMenuItem(new MainMeal("Burger", 25.00, "Grilled"), 0);
//        restaurant.addMenuItem(new MainMeal("Pasta", 30.00, "Baked"), 1);
//        restaurant.addMenuItem(new SideMeal("French Fries", 10.00, "Medium"), 2);
//        restaurant.addMenuItem(new SideMeal("Salad", 12.00, "Large"), 3);
//        restaurant.addMenuItem(new Drink("Cola", 5.00, true), 4);
//        restaurant.addMenuItem(new Drink("Orange Juice", 7.00, true), 5);
//        restaurant.addMenuItem(new Drink("Coffe", 12.00, false), 3);
//    }
//
//    // Handles creating a new order
//    private static void createOrder() {
//        System.out.println("\nCreating a new order...");
//        if (restaurant.getordercount() >= 5) { 
//            System.out.println("Cannot create more orders. Maximum limit reached.");
//            return;
//        }
//
//        System.out.println("Your Order ID: " + nextOrderId);
//        System.out.print("Enter the number of items in your order: ");
//        int size = scanner.nextInt();
//        scanner.nextLine(); // Consume newline
//
//        Order order = restaurant.createOrder(size);
//        if (order == null) {
//            return; // Order limit reached
//        }
//
//        restaurant.Displaymenu();
//        for (int i = 0; i < size; i++) {
//            System.out.print("Select an item by number: ");
//            int itemIndex = scanner.nextInt();
//            scanner.nextLine(); // Consume newline
//
//          
//         MenuItem selectedItem = restaurant.getMenuItem(itemIndex - 1); 
//
//            if (selectedItem != null) {
//                order.addItem(selectedItem);
//            } else {
//                System.out.println("Invalid selection. Try again.");
//                i--; // Retry the selection
//            }
//        }
//
//        System.out.println("\nOrder Created Successfully!");
//        order.DisplayOrder();
//        nextOrderId++; // Increment order ID for next order
//    }
//
//    // Handles searching for an order
//    private static void searchOrder() {
//        System.out.print("\nEnter order ID to search: ");
//        int orderId = scanner.nextInt();
//        scanner.nextLine(); // Consume newline
//
//        Order foundOrder = restaurant.SearchOrder(orderId); 
//        if (foundOrder != null) {
//            foundOrder.DisplayOrder();
//        } else {
//            System.out.println("Order not found.");
//        }
//    }
//
//    // Handles canceling an order
//    private static void cancelOrder() {
//        System.out.print("\nEnter order ID to cancel: ");
//        int orderId = scanner.nextInt();
//        scanner.nextLine(); // Consume newline
//
//         restaurant.cancleOrder(orderId); // Calls your method name
//        
//    }
//}
