import java.util.UUID;

public class Invoice {
    private String invoiceId;
    private Customer customer;
    private Product[] products;
    private int[] quantities;
    private double totalAmount;

    public Invoice(Customer customer, Product[] products, int[] quantities) {
        if (products.length != quantities.length) {
            throw new IllegalArgumentException("Missmatched Items & quantities");

        }
        this.invoiceId = UUID.randomUUID().toString();
        this.customer = customer;
        this.products = products;
        this.quantities = quantities;
        calculteTotalAmount();

    }

    private void calculteTotalAmount() {
        double sum = 0.0;
        for (int i = 0; i < products.length; i++) {
            sum += products[i].getPrice() * quantities[i];

        }
        this.totalAmount = sum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("InvoiceID : [").append(invoiceId).append("]\n").append("Customer :")
                .append(customer.getCustomerFullName()).append("\n")
                .append("Items").append("\n");
        for (int i = 0; i < products.length; i++) {
            sb.append("---------------------------------------").append("\n")
                    .append(products[i].getName()).append("x").append(quantities[i]).append("=")
                    .append(products[i].getPrice() * quantities[i]).append("\n")
                    .append("---------------------------------------");
        }
        sb.append("Ttotal amount :").append(totalAmount).append("$");
        return sb.toString();

    }

}
