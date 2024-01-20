public class Rental {
    private int days;
    private Car car;
    private Customer customer;

    // Constructor
    public Rental(int days, Car car, Customer customer) {
        this.days = days;
        this.car = car;
        this.customer = customer;
    }

    public int getDays() {
        return days;
    }

    public Car getCar() {
        return car;
    }

    public Customer getCustomer() {
        return customer;
    }
}