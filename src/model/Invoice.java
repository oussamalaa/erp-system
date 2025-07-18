/**
 * 
 */
package model;

import java.util.UUID;
import java.time.LocalDate;
import java.util.ArrayList;
import model.Payment;

public class Invoice {
    private String invoiceId;
    private Customer customer;
    private ArrayList<InvoiceItem> items;
    private LocalDate invoiceDate;
    private LocalDate dueDate; // optional for future payment deadline feature
    private double taxRate;
    private double totalAmount;
    private boolean isPaid;
    private ArrayList<Payment> payments;

    public Invoice(Customer customer) {
        this.invoiceId = UUID.randomUUID().toString();
        this.customer = customer;
        this.items = new ArrayList<>();
        this.totalAmount = 0.0;
        this.taxRate = 0.15;
        this.invoiceDate = LocalDate.now();
    }

    public void addProduct(Product product, int quantity) {
        if (product == null || quantity <= 0) {
            throw new IllegalArgumentException("Invalid product or quantity.");
        }
        this.items.add(new InvoiceItem(product, quantity));
        calculateTotalAmount(); // "Always update total for product "
    }

    private void calculateTotalAmount() {
        double sum = 0.0;
        for (InvoiceItem item : items) {
            sum += item.getTotal();
        }
        this.totalAmount = sum + (sum * taxRate);
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public ArrayList<InvoiceItem> getItems() {
        return items;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("InvoiceID: [").append(invoiceId).append("]\n")
                .append("Customer: ").append(customer.getCustomerFullName()).append("\n")
                .append("Items:\n")
                .append("---------------------------------------\n");

        for (InvoiceItem item : items) {
            Product p = item.getProduct();
            int qty = item.getQuantity();
            double lineTotal = item.getTotal();
            double tax = lineTotal * taxRate;

            sb.append(p.getName()).append(" [")
                    .append(p.getPrice()).append(" per unit] x ")
                    .append(qty).append(" = ")
                    .append(lineTotal).append(" + tax 15% [")
                    .append(tax).append(" $]\n");
        }

        sb.append("---------------------------------------\n")
                .append("Total amount: ").append(totalAmount).append(" $\n")
                .append("Issued on: ").append(invoiceDate);

        return sb.toString();
    }
}
