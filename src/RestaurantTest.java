import java.util.*;
import java.io.*;
public class RestaurantTest {
    
   public static Scanner scanner = new Scanner(System.in);
   public static Restaurant myRestaurant= new Restaurant(5, 3); // create Restaurant that can have up to 5 items and 3 orders
   
public static void main(String[] args) {
    // Load existing data when starting
    myRestaurant.readallDATA();

    boolean outer = true;
    while (outer) {
        // main menu
        System.out.println("\n==========================================");
        System.out.println("Welcome to the Bite & Chill Ordering System");
        System.out.println("==========================================");
        System.out.println("1. Customer menu");
        System.out.println("2. Manager menu");
        System.out.println("3. Exit");
        System.out.println("========================================");
        System.out.print("Choose an option: ");

        try{

        int choice0 = scanner.nextInt();
        
        switch (choice0) {
            case 1:
                Coustmer(); // displaying Customer menu
                break;

            case 2:
                Manager(); // displaying Manager menu
                break;

            case 3:
                // Save data before exiting
                myRestaurant.saveallInformation();
                outer = false; // Exiting the system
                System.out.println("Exiting the system. Thank you for using Bite & Chill Ordering System!");
                break;

            default:
                System.out.println("Invalid option, please try again.");
                break;
        }


        } catch (InputMismatchException e) {
        System.out.println("Invalid input. Please enter a number.");
        scanner.nextLine(); // clear the invalid input
        }

    }
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
                     menuDisplay();
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
        
        public static boolean menuDisplay(){
            
            boolean menuIsEmpty = true;

                     // Check if the menu has at least one item by traversing the linked list
                    Node current = myRestaurant.getHeadMenuItem();// Get the head of the menu list
                     while (current != null) {
                         if (current.getData() != null) {
                             menuIsEmpty = false;
                             break; // Exit the loop if we find a non-null item
                                }
                            current = current.getNext(); // Move to the next node
                             }

                        if (menuIsEmpty) {
                        System.out.println("\nThe menu is empty! Please ask the manager to add items before creating an order.");
                        return false;
                       
                        } else {
                         myRestaurant.Displaymenu(); // Display the menu if it has items
                         return true;
                      
                        }
            
        }
        // method to craete order for the coustmer 
        public static void CreateOrder() {
            
        if (menuDisplay()) { // Check if the menu has items
        System.out.println("\nCreating a new order...");

        System.out.print("How many items do you want to order? ");
        int orderSize = scanner.nextInt();
        scanner.nextLine(); // Clear the garbage 

        Order userOrder = myRestaurant.createOrder(orderSize); // create the order

        if (userOrder != null) {
            for (int i = 0; i < orderSize; i++) {
                System.out.print("\nEnter an item from the menu (by number): ");
                int itemNumber = scanner.nextInt();
                scanner.nextLine(); // Clear the garbage 

                // Find the item by number from the linked list
                MenuItem selectedItem = myRestaurant.getMenuItemByNumber(itemNumber);

                if (selectedItem != null) {
                    userOrder.addItem(selectedItem);
                } else {
                    System.out.println("Invalid number, try again.");
                    i--; // Retry the same item
                }
            }
            System.out.println("\nOrder Created Successfully!");
            userOrder.DisplayOrder();
        }
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
    System.out.print("Enter item type (1. Main Meal, 2. Side Meal, 3. Drink): ");
    int type = scanner.nextInt();
    scanner.nextLine();

    System.out.print("Enter item name: ");
    String name = scanner.nextLine();

    System.out.print("Enter item price: ");
    double price = scanner.nextDouble();
    scanner.nextLine();

    MenuItem newItem = null;

    switch (type) {
        case 1:
            System.out.print("Enter meal type ( Grilled, Baked, Fried ): ");
            String mealType = scanner.nextLine();
            newItem = new MainMeal(name, price, mealType);
            break;
        case 2:
            System.out.print("Enter portion size (Small, Medium, Large): ");
            String portionSize = scanner.nextLine();
            newItem = new SideMeal(name, price, portionSize);
            break;
        case 3:
            System.out.print("Is the drink cold? (true/false): ");
            boolean isCold = scanner.nextBoolean();
            scanner.nextLine();
            newItem = new Drink(name, price, isCold);
            break;
        default:
            System.out.println("Invalid item type.");
            return;
    }

    try {
        if (myRestaurant.addMenuItem(newItem)) {
            System.out.println("Item added successfully.");
            myRestaurant.saveallInformation();
        } else {
            System.out.println("Failed to add item for unknown reasons.");
        }
    } catch (MenuFullEx e) {
        System.out.println("Exception caught: " + e.getMessage());
    }
}
    // Remove an item from the menu by name
    public static void removeMenuItem() {
      
    System.out.print("Enter the item name to remove: ");
    String name = scanner.next();

    if (myRestaurant.removeMenuItem(name)) {
        System.out.println("Item has been removed from the menu.");
        myRestaurant.saveallInformation(); // Save changes after removing an item
    } else {
        System.out.println("Invalid item name or menu is empty.");
    }
}

    // Search for an item by name
    public static void searchMenuItem() {
    System.out.print("Enter the name of the item to search: ");
    String name = scanner.nextLine();

    Node current = myRestaurant.getHeadMenuItem(); // Assuming `getHeadMenuItem()` gives the head of the linked list
    boolean found = false;
   
    // walk throgh the linked list to find the item
    while (current != null) {
        if (current.getData().getName().equalsIgnoreCase(name)) {
            System.out.println("Found:");
            current.getData().displayItem(); // Display the item
            found = true;
            break; // Exit loop once item is found
        }
        current = current.getNext(); // Move to the next node
        
    }

    if (!found) {
        System.out.println("Item not found.");
    }
}



  

    }