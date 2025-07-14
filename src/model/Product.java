public class Product {
    private String ProductName;
    private String ProductModel;
    private double ProductPrice;
    private int ProductQuantity;

    public Product(String name, String model, double price, int quantity) {
        this.ProductName = name;
        this.ProductModel = model;
        this.ProductPrice = price;
        this.ProductQuantity = quantity;

    }

    public String toString() {
        return ProductName + "[ " + ProductModel + " ] -> " + ProductPrice + " $ -  (" + ProductQuantity + ")";

    }

    public String getName() {
        return ProductName;
    }

    public String getModel() {
        return ProductModel;
    }

    public double getPrice() {
        return ProductPrice;
    }

    public int getQuantity() {
        return ProductQuantity;
    }

}
