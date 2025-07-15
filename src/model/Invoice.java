package model;

import java.util.UUID;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Invoice {
    private String invoiceId;
    private Customer customer;
    private ArrayList<Product> products;
    private ArrayList<Integer> quantities;
    private LocalDate invoiceDate;
    private LocalDate dueDate; // optional for later use dueedate payment
    private double taxRate;
    private double totalAmount;

    public Invoice(Customer customer) {
        this.invoiceId = UUID.randomUUID().toString();
        this.customer = customer;
        this.products = new ArrayList<>();
        this.quantities = new ArrayList<>();
        this.totalAmount = 0.0;
        this.taxRate = 0.15;
        this.invoiceDate = LocalDate.now();

    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void addProduct(Product product, int quantity) {
        if (product == null || quantity <= 0)
            return;
        this.products.add(product);
        quantities.add(quantity);
        calculateTotalAmount();
    }

    private void calculateTotalAmount() {
        double sum = 0.0;
        for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            int qty = quantities.get(i);
            sum += p.getPrice() * qty;
        }

        this.totalAmount = sum + (sum * taxRate);
    }

    @Override
    public String toString() {
        Date currentDate = new Date();
        StringBuilder sb = new StringBuilder();
        sb.append("InvoiceID: [").append(invoiceId).append("]\n")
                .append("Customer: ").append(customer.getCustomerFullName()).append("\n")
                .append("Items:\n");
        sb.append("---------------------------------------\n");
        for (int i = 0; i < products.size(); i++) {

            sb.append(products.get(i).getName()).append("[").append(products.get(i).getPrice())
                    .append(" per unit ]").append(" X ")
                    .append(quantities.get(i)).append(" = ")
                    .append(products.get(i).getPrice() * quantities.get(i)).append(" + tax 15% [")
                    .append(products.get(i).getPrice() * quantities.get(i) * taxRate).append(" $ ]")
                    .append("\n");
        }

        sb.append("---------------------------------------\n")
                .append("Total amount: ").append(totalAmount).append(" $\n").append("paid by date : ")
                .append(invoiceDate);

        return sb.toString();
    }

}
