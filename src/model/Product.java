package model;

public class Product {
    private int id;
    private String name;
    private String description;
    private int quantity;
    private double buyPrice;
    private double sellPrice;

    // Constructor
    public Product(int id, String name, String description, int quantity, double buyPrice, double sellPrice) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
    }

    // Getters and Setters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public int getQuantity() { return quantity; }
    public double getBuyPrice() { return buyPrice; }
    public double getSellPrice() { return sellPrice; }

    public void setQuantity(int quantity) { this.quantity = quantity; }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", quantity=" + quantity +
               ", buyPrice=" + buyPrice + ", sellPrice=" + sellPrice + "]";
    }
}
