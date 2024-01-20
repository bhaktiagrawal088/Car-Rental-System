class Main {
    public static void main(String[] args) {
        CarRentalSystem rentalsystem = new CarRentalSystem();

        Car car1 = new Car("C001", "Toyota", "Camry", 60.0);
        Car car2 = new Car("C002", "Honda", "Accord", 70.0);
        Car car3 = new Car("C003", "Mahindra", "Thar", 150.0);
        Car car4 = new Car("C004", "Mustang", "Dark Horse", 200.0);
        rentalsystem.addCar(car1);
        rentalsystem.addCar(car2);
        rentalsystem.addCar(car3);
        rentalsystem.addCar(car4);

        rentalsystem.menu();
    }
}