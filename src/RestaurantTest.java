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
   public static Restaurant myRestaurant= new Restaurant(5, 3); // create Restaurant that can have up to 5 items and 3 orders
   
    public static void main(String[] args) {
        
        
        boolean outer=true;
        while(outer){
            // main menu
            System.out.println("\n==========================================");
            System.out.println("Welcome to the Bite & Chill Ordering System");
            System.out.println("==========================================");
            System.out.println("1. Coustmer menu");
            System.out.println("2. Manger menu");
            System.out.println("3. Exit");
            System.out.println("========================================");
            System.out.print("Choose an option: ");
            int choice0 = scanner.nextInt();
            
            switch(choice0){
                case 1 :
                    Coustmer(); // displaying Coustmer menu
                     break;
                     
                case 2 :
                    Manager(); // displaying Manager menu
                     break;
                     
                case 3 :
                    outer = false; // Exiting the system
                     System.out.println("Exiting the system. Thank you for using Bite & Chill Ordering System!");
                    break;
                    
                default:
                    System.out.println("Invalid option, please try again.");
                    break;
                
            }
        }//lana test يطلع لكم؟
       
  
      
       
    }
    ///////////////////////  Coustmer Menu and its methods :-
    
    public static void Coustmer()
    {
        boolean ch = true;
        
          while (ch) {
            System.out.println("\n==========================================");
            System.out.println("Welcome to the Bite & Chill Ordering System");
            System.out.println("==========================================");
            System.out.println("1. View Menu");
            System.out.println("2. Create New Order");
            System.out.println("3. Search for an Order");
            System.out.println("4. Cancel an Order");
            System.out.println("5. Exit Coustmer Menu");
            System.out.println("========================================");
            System.out.print("Choose an option: ");
           
            int choice = scanner.nextInt();
           
            switch (choice) {
                case 1:
                    MenuItem[] menu = myRestaurant.getMenu(); // get the menu
        
                    boolean menuIsEmpty = true;

                     // Check if the menu has at least one item
                    for (MenuItem item : menu) {
                     if (item != null) {
                     menuIsEmpty = false;
                    break;
                    }
                    }

                    if (menuIsEmpty) {
                    System.out.println("\n The menu is empty! Please ask the manager to add items before creating an order.");
                    break; // if the menu has no items
                     }
                    myRestaurant.Displaymenu(); // displaying the menu of the food
                    break;
                    
                case 2:
                    CreateOrder(); // calling method to create the order
                    break;
                    
                case 3:
                    SearchOrder(); // caling method to search for the order
                    break;
                    
                case 4:
                   CancelOrder(); // caling method to cancel order
                    break;
                    
                case 5: 
                   ch = false; //Exiting Coustmer menu
                      System.out.println("Exiting Coustmer menu.");
                    break;
                    
                default:
                    System.out.println("Invalid option, please try again.");
                    break;
            }
          }
    }
        
        // method to craete order for the coustmer 
        public static void CreateOrder() {
            
        MenuItem[] menu = myRestaurant.getMenu(); // get the menu
        
        boolean menuIsEmpty = true;

        // Check if the menu has at least one item
        for (MenuItem item : menu) {
            if (item != null) {
                menuIsEmpty = false;
                break;
            }
        }

        if (menuIsEmpty) {
            System.out.println("\n The menu is empty! Please ask the manager to add items before creating an order.");
            return; // Exit the method if the menu has no items
        }

        System.out.println("\nCreating a new order..."); // create order if the menu has items
        
        System.out.print("How many items do you want to order? "); // to set the order size 
        int orderSize = scanner.nextInt();
        
        Order userOrder = myRestaurant.createOrder(orderSize); // creating order from the size entered by the coustmer

        if (userOrder != null) 
        {
            myRestaurant.Displaymenu(); // Display the menu for the user again
            
            for (int i = 0; i < orderSize; i++) {
                
                System.out.print("\nEnter an item from the menu (by number): ");
                int itemIndex = scanner.nextInt() - 1; // Fixing index 

                if (itemIndex >= 0 && itemIndex < menu.length && menu[itemIndex] != null) { // checks if the item index is true and is in the menu
                    userOrder.addItem(menu[itemIndex]);
                } else {
                    System.out.println("Invalid number, try again.");
                    i--; // Retry
                }
            }
            System.out.println("\nOrder Created Successfully!");
            userOrder.DisplayOrder(); // displaying info of the order with the total amount and all 
        }
    }

    
    // method to search for the order by the order number
    public static void SearchOrder(){
         System.out.print("Enter the order ID to search for: ");
                    int searchId = scanner.nextInt();
                    Order foundOrder = myRestaurant.SearchOrder(searchId); // calling searchOrder from class myRestaurant
                    if (foundOrder != null) {
                        foundOrder.DisplayOrder();
                    } else {
                        System.out.println("Order not found.");
                    }
    }
    // method to cancel the order by the order number
    public static void CancelOrder(){
        System.out.print("Enter the order ID to cancel: ");
                    int cancelId = scanner.nextInt();
                    if (myRestaurant.cancleOrder(cancelId)) { //calling cancleOrder from class myRestaurant
                        System.out.println("Order successfully canceled.");
                    } else {
                        System.out.println("Failed to cancel order. Check the entered ID.");
                    }
    }
    
    
    
    ///////////////////////  Manger Menu and its methods :-
    
    public static void Manager() {
    boolean manage = true;
    while (manage) {
        System.out.println("\n==========================================");
        System.out.println("Manager Menu");
        System.out.println("==========================================");
        System.out.println("1. Add Menu Item");
        System.out.println("2. Remove Menu Item");
        System.out.println("3. Search for Menu Item");
        System.out.println("4. Exit Manager Menu");
        System.out.println("==========================================");
        System.out.print("Choose an option: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // garbage

        switch (choice) {
            case 1:
                addMenuItem(); // caling addMenuItem method to add new items 
                break;
            case 2:
                removeMenuItem(); // calling removeMenuItem to remove item from the menu
                break;
            case 3:
                searchMenuItem(); // calling searchMenuItem to search for item in the menu
                break;
            case 4:
                manage = false; //Exiting manager menu.
                System.out.println("Exiting manager menu.");
                break;
            default:
                System.out.println("Invalid option, please try again.");
         }
        }
    }
    
    
    

       // Add a new item to the menu
    public static void addMenuItem() {
        
        System.out.print("Enter item type (1. Main Meal, 2. Side Meal, 3. Drink): "); // ask for type of item
        int type = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter item name: ");
        String name = scanner.nextLine();

        System.out.print("Enter item price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        MenuItem newItem = null;

        switch (type) {
            case 1: // if the item choosen is main meal
                System.out.print("Enter meal type ( Grilled, Baked, Fried ): ");
                String mealType = scanner.nextLine();
                newItem = new MainMeal(name, price, mealType);
                break;
            case 2: // if the item choosen is Side meal
                System.out.print("Enter portion size (Small, Mediam, Large): ");
                String portionSize = scanner.nextLine();
                newItem = new SideMeal(name, price, portionSize);
                break;
            case 3: // if the item choosen is Drink
                System.out.print("Is the drink cold? (true/false): ");
                boolean isCold = scanner.nextBoolean();
                scanner.nextLine();
                newItem = new Drink(name, price, isCold);
                break;
            default:
                System.out.println("Invalid item type.");
                return;
        }

        // find the first empty index to add the item
        MenuItem[] menu = myRestaurant.getMenu();
        for (int i = 0; i < menu.length; i++) {
            if (menu[i] == null) {
                myRestaurant.addMenuItem(newItem, i);
                System.out.println("Item added successfully at position " + (i + 1));
                return; // if it add the item will exit the method
            }
        }
        System.out.println("Menu is full, cannot add more items."); // if the item was not added will display
    }
    

    // Remove an item from the menu by index
    public static void removeMenuItem() {
        System.out.print("Enter the item number to remove: ");
        int index = scanner.nextInt() - 1; // Fixing index 

        MenuItem[] menu = myRestaurant.getMenu();
        if (index >= 0 && index < menu.length && menu[index] != null) {
            System.out.println(menu[index].getName() + " has been removed from the menu.");
            menu[index] = null;
        } else {
            System.out.println("Invalid item number.");
        }
    }

    // Search for an item by name
    public static void searchMenuItem() {
        System.out.print("Enter the name of the item to search: ");
        String name = scanner.nextLine();

        MenuItem[] menu = myRestaurant.getMenu();
        boolean found = false;
        for (int i = 0; i < menu.length; i++) {
            if (menu[i] != null && menu[i].getName().equalsIgnoreCase(name)) {
                System.out.println("Found: " + (i + 1) + ". ");
                menu[i].displayItem();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Item not found.");
        }
    }

   
    
   

    }