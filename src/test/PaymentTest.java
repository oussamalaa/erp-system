package test;

import model.Invoice;
import model.Payment;
import model.Customer;
import model.PaymentMethod;
import model.PaymentStatus;

public class PaymentTest {
    public static void main(String[] args) {
        // Assuming you already have an invoice object
        Customer c = new Customer("ouss", "ouss@mail.com", "514-999-9898");
        Invoice invoice = new Invoice(c); // Fill with valid constructor args

        Payment payment = new Payment(invoice, 100.0, PaymentMethod.CASH, PaymentStatus.PAID);

        System.out.println("Invoice ID: " + payment.getInvoice().getInvoiceId());
        System.out.println("Payment Method: " + payment.getMethod());
        System.out.println("Status: " + payment.getStatus());
    }
}
