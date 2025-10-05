<<<<<<< HEAD
import model.Product;
import service.ProductService;

public class Main {
    public static void main(String[] args) {
        ProductService ps = new ProductService();

        // Add products
        ps.addProduct(new Product(1, "Laptop", "Gaming laptop", 10, 50000, 60000));
        ps.addProduct(new Product(2, "Mouse", "Wireless mouse", 50, 500, 800));

        // View products
        System.out.println("---- Product List ----");
        ps.viewProducts();

        // Update quantity
        ps.updateQuantity(1, 8);
        System.out.println("\nAfter update:");
        ps.viewProducts();

        // Delete product
        ps.deleteProduct(2);
        System.out.println("\nAfter deleting Mouse:");
        ps.viewProducts();
=======
import java.util.Scanner;
import model.User;
import model.AuthService;

public class Main {
    public static void main(String[] args) {
        // Create AuthService
        AuthService authService = new AuthService();

        // Register default users
        authService.register(new User(1, "admin", "admin123", "Admin"));
        authService.register(new User(2, "manager", "manager123", "Manager"));
        authService.register(new User(3, "staff", "staff123", "Staff"));

        // Use Scanner for interactive login
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = sc.nextLine();

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        // Validate login
        User user = authService.login(username, password);

        if (user != null) {
            System.out.println("Login Successful! Welcome, " + user.getRole());
        } else {
            System.out.println("Login Failed! Invalid credentials.");
        }

        sc.close();
>>>>>>> 9e6064a8e9def5c136d2bc24502ea74ff12e8150
    }
}
