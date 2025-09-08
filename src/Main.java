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
    }
}
