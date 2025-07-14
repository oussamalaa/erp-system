public class InvoiceTest {
    public static void main(String[] args) {
        Customer c1 = new Customer("ouss", "ouss@email.com", "514-999-8787");

        Product[] items = {
                new Product("LAP_TOP", "XP_125", 100, 1500),
                new Product("LAP_TOP", "TR_111", 100, 1500)

        };
        int[] qyt = { 2, 2 };
        Invoice inv = new Invoice(c1, items, qyt);
        System.out.println(inv);
    }

}
