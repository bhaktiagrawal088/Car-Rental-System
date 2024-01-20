import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarRentalSystem {
    private List<Car> cars;
    private List<Customer> customers;
    private List<Rental> rentals;

    public CarRentalSystem() {
        cars = new ArrayList<>();
        customers = new ArrayList<>();
        rentals = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void rentCar(int days, Car car, Customer customer) {
        if (car.isAvaiable()) {
            car.rent();
            rentals.add(new Rental(days, car, customer));
        } else {
            System.out.println("The " + car + " is not available.");
        }
    }

    public void returnCar(Car car) {
        car.returnCar();
        Rental rentalToRemove = null;
        for (Rental r : rentals) {
            if (r.getCar() == car) {
                rentalToRemove = r;
                break;
            }
        }
        if (rentalToRemove != null) {
            rentals.remove(rentalToRemove);
        } else {
            System.out.println("Car was not returned");
        }
    }

    public void menu() {
        Scanner sr = new Scanner(System.in);

        while (true) {
            System.out.print("\n*****Welcome to the Car Rental System*****\n");
            System.out.println("1. Rent a Car");
            System.out.println("2. Return a Car");
            System.out.println("0. Exit");

            System.out.println("Enter your choice");
            int choice = sr.nextInt();
            sr.nextLine();

            if (choice == 1) {
                System.out.println("\n***Rent a car***\n");
                System.out.println("Enter your name");
                String customerName = sr.nextLine();
                System.out.println("Enter your Phone number");
                double phoneNumber = sr.nextDouble();

                System.out.println("List of Cars is Available");
                for (Car c : cars) {
                    if (c.isAvaiable()) {
                        System.out.println(c.getcarID() + " - " + c.getBrand() + " - " + c.getmodel());
                    }
                }
                System.out.println("Enter the car Id you want to rent: ");
                String carId = sr.nextLine();
                sr.nextLine();

                System.out.println("Enter the number of days for rentals");
                int rentalDays = sr.nextInt();

                Customer newCustomer = new Customer("CUS" + (customers.size() + 1), customerName, phoneNumber);
                addCustomer(newCustomer);
                sr.nextLine();

                Car selectedCar = null;
                for (Car c : cars) {
                    if (c.getcarID().equals(carId) && c.isAvaiable()) {
                        selectedCar = c;
                        break;
                    }
                }
                if (selectedCar != null) {
                    double totalPrice = selectedCar.calculatePrice(rentalDays);
                    System.out.println("*****Rental Information *****\n");
                    System.out.println("Customer Id: " + newCustomer.getCustomerId());
                    System.out.println("Customer Name: " + newCustomer.getName());
                    System.out.println("Customer Name: " + newCustomer.getPhoneNumber());
                    System.out.println("Cars: " + toString());
                    System.out.println("Rental Days: " + rentalDays);
                    System.out.println("Total Price: $%.2f%n" + totalPrice);

                    System.out.println("\n Confirm rental (Y/N) : ");
                    String confirm = sr.nextLine();

                    if (confirm.equalsIgnoreCase("Y")) {
                        rentCar(rentalDays, selectedCar, newCustomer);
                        System.out.println("Car rented successfully! Enjoy your journey Be safe ...");
                    } else {
                        System.out.println("Rental canceled ! Welcome you next time " + customerName);
                    }

                } else {
                    System.out.println("Invalid Car selection or car not available for rent...");
                }

            } else if (choice == 2) {
                System.out.println("***Return a car *** ");
                System.out.println("Enter your car Id you want to return");
                String carId = sr.nextLine();

                Car carToreturn = null;

                for (Car c : cars) {
                    if (c.getcarID().equals(carId) && !c.isAvaiable()) {
                        carToreturn = c;
                        break;
                    }
                }
                if (carToreturn != null) {
                    Customer customer = null;
                    for (Rental r : rentals) {
                        if (r.getCar() == carToreturn) {
                            customer = r.getCustomer();
                            break;
                        }
                    }
                    if (customer != null) {
                        returnCar(carToreturn);
                        System.out.println("Car returned sucessfully by " + customer.getName());
                        System.out.println("Welcome to next time! ");
                    } else {
                        System.out.println("Car was not rented or rental infomation is missing.");
                    }
                } else {
                    System.out.println("Invalid car Id and car is not rented");
                    System.out.println("Sorry for inconvenience please enter valid car Id...");
                }

            } else if (choice == 0) {
                break;
            } else {
                System.out.println("Invalid choice please enter a valid choice");
            }
        }
        System.out.println("Thank for using the Car Rental System .... ");
        System.out.println("See you next time");
    }
}
