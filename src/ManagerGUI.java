import javax.swing.*;// import the swing components for GUI
import java.awt.*;//import the AWT layout for the manger
import java.awt.event.*;//import event handeling

public class ManagerGUI extends JFrame {//this will create a GUI window
   private Restaurant restaurant;//creates a resturant object

    public ManagerGUI(Restaurant restaurant) {
        this.restaurant = restaurant;

        setTitle("Manager Menu");//we thought it would be diffrient to use the customer GUI form design
        // and the manger GUI from sourse
        setSize(400, 300);//this will determain the overall view of the title squere
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 1, 10, 10));

        JButton addButton = new JButton("Add Menu Item");//jbuttons are added 
        JButton removeButton = new JButton("Remove Menu Item");
        JButton searchButton = new JButton("Search Menu Item");
        JButton exitButton = new JButton("Exit");

        add(addButton);
        add(removeButton);//this will add the buttons to the jframe
        add(searchButton);
        add(exitButton);

        // Action for adding item
        addButton.addActionListener(e -> {// the e stands for event that is happing
            //so that we needed e--> to give java the command to start an event
            String[] options = {"Main Meal", "Side Meal", "Drink"};
            String type = (String) JOptionPane.showInputDialog(this, "Select item type:",
                    "Type", JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
//this will promet the user to enter his own menu item
            if (type == null) return;//if thr user cancels the system exits

            String name = JOptionPane.showInputDialog(this, "Enter item name:");//this a GUI command for displaying for users
            String priceStr = JOptionPane.showInputDialog(this, "Enter item price:");

            try {//an exciption that is user defined for if the menu was full
                double price = Double.parseDouble(priceStr);
                MenuItem item = null;

                if (type.equals("Main Meal")) {//same code as the first phase
                    String mealType = JOptionPane.showInputDialog(this, "Enter meal type (Grilled/Baked/Fried):");
                    item = new MainMeal(name, price, mealType);
                } else if (type.equals("Side Meal")) {
                    String portionSize = JOptionPane.showInputDialog(this, "Enter portion size (Small/Medium/Large):");
                    item = new SideMeal(name, price, portionSize);
                } else if (type.equals("Drink")) {
                    String coldStr = JOptionPane.showInputDialog(this, "Is it cold? (true/false):");
                    boolean isCold = Boolean.parseBoolean(coldStr);
                    item = new Drink(name, price, isCold);
                }

                if (restaurant.addMenuItem(item)) {
                    JOptionPane.showMessageDialog(this, "Item added successfully.");
                } else {
                    JOptionPane.showMessageDialog(this, "Menu is full.");
                }

            } catch (Exception ex) {//catches the exception
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        });

        // Action for removing item
        removeButton.addActionListener(e -> {//this method removes an added item
            String name = JOptionPane.showInputDialog(this, "Enter item name to remove:");
            if (restaurant.removeMenuItem(name)) {
                JOptionPane.showMessageDialog(this, "Item removed.");
            } else {
                JOptionPane.showMessageDialog(this, "Item not found.");
            }
        });

        // Action for searching item
        searchButton.addActionListener(e -> {//this method searches for an item
            String name = JOptionPane.showInputDialog(this, "Enter item name to search:");
            Node current = restaurant.getHeadMenuItem();
            boolean found = false;

            while (current != null) {
                if (current.getData().getName().equalsIgnoreCase(name)) {
                    JOptionPane.showMessageDialog(this, "Item Found:\n" + current.getData().toString());
                    found = true;
                    break;
                }
                current = current.getNext();//this will run over the list and find it 
            }

            if (!found) {
                JOptionPane.showMessageDialog(this, "Item not found.");
            }
        });

        // Exit button
        exitButton.addActionListener(e -> {
            restaurant.saveallInformation();
            dispose();//a gui method that is the same as exit() but for frames
        });

        setVisible(true);//this will allow the frame to be visable when u run the code
    }
}