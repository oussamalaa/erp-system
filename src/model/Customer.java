import java.util.UUID;

public class Customer {
    private String CustomerId;
    private String CustomerFullName;
    private String CustomerEmail;
    private String CustomerPhone;

    public Customer(String CustomerFullName, String CustomerEmail, String CustomerPhone) {
        this.CustomerId = UUID.randomUUID().toString(); // Generating large random ID to make sure no repeat in ID /
                                                        // taking 36 bit
                                                        // char (32 hexa + 4 -)
        this.CustomerFullName = CustomerFullName;
        this.CustomerEmail = CustomerEmail;
        this.CustomerPhone = CustomerPhone;
    }

    public String getCustomerId() {
        return CustomerId;
    }

    public String getCustomerFullName() {
        return CustomerFullName;
    }

    public String getCustomerEmail() {

        return CustomerEmail;
    }

    public String getCustomerPhone() {
        return CustomerPhone;
    }

    @Override
    public String toString() {
        return "[" + CustomerId + " ] -> Name : [ " + CustomerFullName + " ]-> email : " + CustomerEmail + " -> phone :"
                + CustomerPhone;

    }

}
