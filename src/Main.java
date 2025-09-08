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
    }
}
