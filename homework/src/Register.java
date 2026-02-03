import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Register {
    public static void main (String [] args) {
        userMenu(createRegister());
    }

    private static void userMenu(Map<String, String> register) {
        boolean running = true;
        System.out.println("Houses 2025-2026!");

        while (running) {
            System.out.println("Menu, choose a number: \n1. Display all students \n2. Search for a student by name and display their house. \n3. Show the members of a particular house. \n4. Count the number of students in a house.\n5. Add or Update Student/House \n6. Exit.");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayAllStudents(register);
                    break;
                case 2:
                    scanner.nextLine();
                    searchStudent(scanner, register);
                    break;
                case 3:
                    scanner.nextLine();
                    displayStudentInHouse(scanner, register);
                    break;
                case 4:
                    scanner.nextLine();
                    showNumberOfStudentInHouse(scanner, register);
                    break;
                case 5:
                    scanner.nextLine();
                    addOrUpdateStudent(scanner, register);
                    break;
                case 6:
                    running = false;
                    break;

            }
        }
    }

    private static Map<String, String> createRegister() {
        Map<String, String> register = new HashMap<>();
        register.put("Avika", "Ravenclaw");
        register.put("Chloe", "Slytherin");
        register.put("Aiza", "Slytherin");
        register.put("Olivia", "Ravenclaw");
        register.put("Sophie", "Ravenclaw");
        register.put("Ellie", "Hufflepuff");
        register.put("Mr Bradley", "Ravenclaw");
        register.put("Ms Mogio", "Hufflepuff");
        return register;
    }

    // loops through all key-value pairs and showcases them
    public static void displayAllStudents(Map < String, String > register){
        for (Map.Entry<String, String > entry : register.entrySet()) {
            System.out.println(entry.getKey() + " is in: " + entry.getValue());
        }
    }

    public static void searchStudent (Scanner scanner, Map < String, String > register){
            System.out.println("Please write the name of the student.");
            String name = scanner.nextLine();
            if (register.containsKey(name)) {
                System.out.println(name + "'s house is: " + register.get(name));
            } else {
                System.out.println("Student not found.");
            }

        }

        public static void displayStudentInHouse (Scanner scanner, Map < String, String > register){
            System.out.println("Please write the name of the house you would like to see the members of.");
            String houseName = scanner.nextLine();

            // if the value of entry matches the house name, print the key and value of that person
            for (Map.Entry<String, String> entry : register.entrySet()) {
                if (entry.getValue().equals(houseName)) {
                    System.out.println(entry.getKey() +  " is in " +  entry.getValue());
                }
            }
        }

        public static void showNumberOfStudentInHouse(Scanner scanner, Map < String, String > register) {
            System.out.println("Please write the name of the house you would like to count the members of.");
            String houseName = scanner.nextLine();
            int number = 0;
            for (Map.Entry<String, String> entry : register.entrySet()) {
                if (entry.getValue().equals(houseName)) {
                    number++;
                }
            }
            System.out.println("There are " + number + " student/s in " + houseName);
        }

        public static void addOrUpdateStudent(Scanner scanner, Map < String, String > register){
            System.out.println("Please enter the name of the student you would like to add or update.");
            String name = scanner.nextLine();
            System.out.println("Please enter the house.");
            String houseName = scanner.nextLine();
            if (register.containsKey(name)) {
                System.out.println(name + " already exists!\nTheir house will now be: " + houseName);
            } else {
                System.out.println(name + " has been added to " + houseName);

            }
            register.put(name, houseName);
        }
    }

