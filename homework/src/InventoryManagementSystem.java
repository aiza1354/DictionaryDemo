import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

/* Challenge 2: Inventory Management System
Difficulty: Low-Intermediate
Concept: Updating values, checking existence
Create a shop inventory system where product names are keys and stock quantities are values.
Requirements:
Start with 5 products and their quantities
Implement a "sell" function that reduces stock (check it exists first!)
Implement a "restock" function that adds to existing stock
Alert when stock falls below 5 units
Display all products with zero stock
Extension: Track prices as well (use a HashMap of HashMap's, or create a Product class)
*/
public class InventoryManagementSystem {
    public static void main(String[] args) {
        employeeMenu(createInventory());
    }

    public static Map<String, Product> createInventory() {
        Map<String, Product> inventory = new HashMap<>();
        inventory.put("Giraffe", new Product(1, 6.80));
        inventory.put("Cat", new Product(6, 7.80));
        inventory.put("Penguin", new Product(11, 6.85));
        inventory.put("Armadillo", new Product(7, 9.50));
        inventory.put("Monkey", new Product(9, 11.20));
        return inventory;
    }

    public static void employeeMenu(Map<String, Product> inventory) {
        boolean running = true;
        while (running) {
            System.out.println("Welcome to The Stuffed Animal Store! \nPlease choose a number: ");
            System.out.println("Menu:\n1. Display all items and their stock. \n2. Sell an Item.\n3. Restock an Item.\n4. Display all items whose stock is 0.\n5. Exit");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    displayAllStock(inventory);
                    break;
                case 2:
                    scanner.nextLine();
                    sellItem(scanner, inventory);
                    break;
                case 3:
                    scanner.nextLine();
                    restockItem(scanner, inventory);
                    break;
                case 4:
                    displayOutOfStockAnimals(inventory);
                    break;
                case 5:
                    running = false;
                    break;

            }
        }

    }

    public static void displayAllStock(Map<String, Product> inventory) {
        for (Map.Entry<String, Product> entry : inventory.entrySet()) {
            System.out.println("There are: " + entry.getKey() + "'s " + entry.getValue().quantity + " in stock. They cost: £" + entry.getValue().price);
        }
    }

    public static void sellItem(Scanner scanner, Map<String, Product> inventory) {
        System.out.println("Please tell us the animal you would like to sell.");
        String nameOfAnimal = scanner.nextLine();
        if (inventory.containsKey(nameOfAnimal)) {
            if (inventory.get(nameOfAnimal).quantity > 0) {
                int stockCounter = inventory.get(nameOfAnimal).quantity;
                System.out.println("The stock of " + nameOfAnimal + " was: " + stockCounter);
                stockCounter--;
                inventory.put(nameOfAnimal, new Product(stockCounter, inventory.get(nameOfAnimal).price));
                System.out.println("The stock of " + nameOfAnimal + " is now: " + stockCounter);
                if (stockCounter == 0) {
                    System.out.println("Please restock " + nameOfAnimal);
                } else if (stockCounter > 0 &&  stockCounter < 5) {
                    System.out.println("The stock of " + nameOfAnimal + " is below 5! Please restock, if possible.");
                }
            } else {
                System.out.println("Stock has run out for: " + nameOfAnimal);
            }
        } else {
            System.out.println("Stuffed Animal doesn't exist.");
        }
    }

    public static void restockItem(Scanner scanner, Map<String, Product> inventory) {
        System.out.println("Please tell us the animal you would like to restock.");
        String nameOfAnimal = scanner.nextLine();
        if (inventory.containsKey(nameOfAnimal)) {
            int stockCounter = inventory.get(nameOfAnimal).quantity;
            System.out.println("The stock of " + nameOfAnimal + " was: " + stockCounter);
            stockCounter++;
            inventory.put(nameOfAnimal, new Product(stockCounter, inventory.get(nameOfAnimal).price));
            System.out.println("The stock of " + nameOfAnimal + " is now: " + stockCounter);
            if (stockCounter < 5) {
                System.out.println("The stock of " + nameOfAnimal + " is still less then 5! Please add more stocks.");
            }
        } else {
            System.out.println("Stuffed Animal doesn't exist.");
        }
    }

    public static void displayOutOfStockAnimals(Map <String, Product> inventory){
        for (Map.Entry<String, Product> entry : inventory.entrySet()) {
            if (entry.getValue().quantity == 0) {
                System.out.println(entry.getKey() + "'s stock is 0.");
            }
        }
    }
}


