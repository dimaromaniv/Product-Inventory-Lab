import models.Sneaker;
import services.SneakerService;

import java.util.Date;
import java.util.Scanner;

public class App {

    private SneakerService sneakerService = new SneakerService(); // (1)

    public static void main(String... args) {
        App application = new App(); // (2)
        application.init();  // (3)
    }

    public void init() {
        // (4)
        // application logic here
        // call methods to take user input and interface with services
        Console.printWelcome();
        runMainMenu();
    }

    public void runMainMenu() {
        boolean running = true;
        Scanner scanner = new Scanner(System.in);

        while (running) {
            Console.printMainMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addNewItem();
                    // Create product
                    // Implement the logic to create a product and add it to inventory
                    break;
                case 2:
                    readExistingProducts();
                    // Read existing products
                    // Implement the logic to read and display existing products
                    break;
                case 3:
                    updateItem();
                    // Update product
                    // Implement the logic to update a product's details
                    break;
                case 4:
                    deleteItem();
                    // Delete product
                    // Implement the logic to delete a product from inventory
                    break;
                case 5:
                    getInventoryReport();
                    // Get reports about products
                    // Implement the logic to generate and display reports
                    break;
                case 6:
                    System.out.println("Do you want to quit?\n" +
                                    "if Yes - type [y]\n" +
                                    "if No - type [n]");
                    String quit = scanner.nextLine();
                    if (quit.equalsIgnoreCase("y")) {
                        running = false;
                    }if (quit.equalsIgnoreCase("n")){
                        return;
                }
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }

        System.out.println("Exiting the program. Goodbye!");
        scanner.close();
    }

    public void addNewItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please give a name of this product");
        String name = scanner.nextLine();
        System.out.println("Please give the brand of this product");
        String brand = scanner.nextLine();
        System.out.println("Please tell what sport");
        String sport = scanner.nextLine();
        System.out.println("Please give a size");
        double size = scanner.nextDouble();
        System.out.println("Please give a qty ot this items");
        int qty = scanner.nextInt();
        System.out.println("Please give a price");
        float price = scanner.nextFloat();
        sneakerService.create(name, brand, sport, size, qty, price);
        System.out.println("We add new itm to inventory");
    }

    public void updateItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("If you want to update some item press [1] , return press [2]");
        int answer1 = scanner.nextInt();
        System.out.println("What is the ID of the item that you want to update ?");
        int itemID = scanner.nextInt();
        if (answer1 == 1) {
            Sneaker temp = sneakerService.findSneaker(itemID);

            System.out.println("Set new price price press  [1] \n" +
                    "Set new Qty press [2] \n");
            int choise = scanner.nextInt();

            if (choise == 1) {
                System.out.println("What is new price?");
                float newPrice = scanner.nextFloat();
                temp.setPrice(newPrice);
            }
            if (choise == 2) {
                System.out.println("What is new Qty?");
                int newQty = scanner.nextInt();
                temp.setQty(newQty);
            } else {
                return;
            }

        }
    }

    public void getInventoryReport () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("If you want to see the list of all items press [1] , return press [2]");
        int answer = scanner.nextInt();
        if (answer == 1) {
            sneakerService.getInvetoryReport();
        } else {
            return;
        }
    }
    public void deleteItem () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What item do you want to delete ? \n" +
                "Please provide the item ID ");
        int answer = scanner.nextInt();
        for (Sneaker itemToDelete : sneakerService.findAll()) {
            if (itemToDelete.getId() == answer) {
                sneakerService.delete(itemToDelete.getId());
                System.out.println("The item was succsefully removed");
            }
            else {
                System.out.println("We dont have this ID number in our inventory list");
            }
        }
    }

    public void readExistingProducts () {
        for (Sneaker s : sneakerService.findAll()){

            System.out.println(s.getName());
        }
    }

}



