public class App {
    public static void main(String[] args) throws Exception {
        Vehicle car1 = new Vehicle("W205", "C 63", 40000.00);
        double rentCostCar = car1.calcRentalCost(3);
        System.out.println("Rent cost for first car: Rs" + rentCostCar);
        System.out.println(car1.getDetails());

        Truck truck1 = new Truck("G3024", "Unimog", 70000.00, 15);
        double rentCostTruck = truck1.calcRentalCost(10);
        System.out.println("Rent cost for first truck: Rs" + rentCostTruck);
        System.out.println(truck1.getDetails());
    }
}
