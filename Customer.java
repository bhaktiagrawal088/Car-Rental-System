public class Customer {
    private String CustomerId;
    private String CustomerName;
    private double phoneNumber;

    // Constructor to initialize the object with values
    public Customer(String CustomerId, String CustomerName, double phoneNumber) {
        this.CustomerId = CustomerId;
        this.CustomerName = CustomerName;
        this.phoneNumber = phoneNumber;
    }

    public String getCustomerId() {
        return CustomerId;
    }

    public String getName() {
        return CustomerName;
    }

    public double getPhoneNumber() {
        return phoneNumber;
    }
}