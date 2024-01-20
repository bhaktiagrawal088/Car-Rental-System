public class Car {
    private String carId;
    private String brand;
    private String model;
    private double basePricePerDay;
    private boolean isAvaiable;

    // Custructor
    public Car(String carId, String brand, String model, double basePricePerDay) {
        this.carId = carId;
        this.brand = brand;
        this.model = model;
        this.basePricePerDay = basePricePerDay;
        this.isAvaiable = true;
    }

    public String getcarID() {
        return carId;
    }

    public String getBrand() {
        return brand;
    }

    public String getmodel() {
        return model;
    }

    public double getBasePricePerDay() {
        return basePricePerDay;
    }

    public double calculatePrice(int rentalDays) {
        return basePricePerDay * rentalDays;
    }

    public boolean isAvaiable() {
        return isAvaiable;
    }

    public void rent() {
        isAvaiable = false;
    }

    public void returnCar() {
        isAvaiable = true;
    }

    public String toString(Car c) {
        return "Car ID: " + c.getcarID() + "\n" + "Car Brand: " + c.getBrand() +
                "\n" + "Car Model: " + c.getmodel() + "\n";
    }
}