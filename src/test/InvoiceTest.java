package test;

import model.Customer;
import model.Product;
import model.Invoice;

public class InvoiceTest {
    public static void main(String[] args) {
        Customer c1 = new Customer("ouss", "ouss@email.com", "514-999-8787");

        Invoice inv = new Invoice(c1);
        inv.addProduct(new Product("LAP_TOP", "XP_125", 100, 1500), 2);
        inv.addProduct(new Product("GPU_CRD", "TR_111", 500, 1500), 1);

        System.out.println(inv);
    }
}
