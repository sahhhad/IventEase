package service;

import model.Product;
import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private List<Product> products = new ArrayList<>();

    // Add product
    public void addProduct(Product product) {
        products.add(product);
    }

    // Delete product
    public boolean deleteProduct(int id) {
        return products.removeIf(p -> p.getId() == id);
    }

    // Update product quantity
    public boolean updateQuantity(int id, int newQty) {
        for (Product p : products) {
            if (p.getId() == id) {
                p.setQuantity(newQty);
                return true;
            }
        }
        return false;
    }

    // View all products
    public void viewProducts() {
        for (Product p : products) {
            System.out.println(p);
        }
    }
}
