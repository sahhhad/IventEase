package com.ims.model;

public class Sale {
    private int id;
    private int productId;
    private int quantity;
    private double total;

    public Sale(int id, int productId, int quantity, double total) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
        this.total = total;
    }

    public int getId() { return id; }
    public int getProductId() { return productId; }
    public int getQuantity() { return quantity; }
    public double getTotal() { return total; }
}
