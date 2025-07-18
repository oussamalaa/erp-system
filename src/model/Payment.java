package model;

import java.time.LocalDate;
import java.util.UUID;

public class Payment {

    private String paymentId;
    private Invoice invoice;
    private LocalDate paymentDate;
    private double amountPaid;
    private PaymentMethod method;
    private PaymentStatus status;

    public Payment(Invoice invoice, double amountPaid, PaymentMethod method, PaymentStatus status) {
        this.paymentId = UUID.randomUUID().toString();
        this.invoice = invoice;
        this.amountPaid = amountPaid;
        this.paymentDate = LocalDate.now();
        this.method = method;
        this.status = status;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public PaymentMethod getMethod() {
        return method;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PaymentID: " + paymentId + "\n" +
                "InvoiceID: " + invoice.getInvoiceId() + "\n" +
                "Amount Paid: $" + amountPaid + "\n" +
                "Date: " + paymentDate + "\n" +
                "Method: " + method + "\n" +
                "Status: " + status;
    }
}
