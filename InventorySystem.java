import java.util.*;

public class InventorySystem {
    static Scanner sc = new Scanner(System.in);
    static List<User> users = new ArrayList<>();
    static List<Product> products = new ArrayList<>();
    static List<Supplier> suppliers = new ArrayList<>();

    public static void main(String[] args) {
        // Sample data
        users.add(new User("admin", "admin123"));
        products.add(new Product(1, "Laptop", 10, 50000));
        products.add(new Product(2, "Mouse", 50, 500));
        suppliers.add(new Supplier(1, "Tech Supplier", "1234567890"));

        System.out.println("Welcome to Inventory Management System");
        if (login()) {
            showMenu();
        } else {
            System.out.println("Invalid credentials! Exiting...");
        }
    }

    static boolean login() {
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();

        for (User user : users) {
            if (user.username.equals(username) && user.password.equals(password)) {
                System.out.println("Login successful!\n");
                return true;
            }
        }
        return false;
    }

    static void showMenu() {
        int choice;
        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. View Products");
            System.out.println("2. View Suppliers");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    viewProducts();
                    break;
                case 2:
                    viewSuppliers();
                    break;
                case 3:
                    System.out.println("Exiting system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 3);
    }

    static void viewProducts() {
        System.out.println("\n--- Products ---");
        for (Product p : products) {
            System.out.println("ID: " + p.id + ", Name: " + p.name + ", Quantity: " + p.quantity + ", Price: " + p.price);
        }
    }

    static void viewSuppliers() {
        System.out.println("\n--- Suppliers ---");
        for (Supplier s : suppliers) {
            System.out.println("ID: " + s.id + ", Name: " + s.name + ", Contact: " + s.contact);
        }
    }
}