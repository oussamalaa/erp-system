package model;

public class InvoiceItem {
    private Product product;
    private int quantity;

    public InvoiceItem(Product product, int quantity) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotal() {
        return product.getPrice() * quantity;
    }

    @Override
    public String toString() {
        return product.getName() + " x " + quantity + " = " + getTotal() + " $";
    }
}
