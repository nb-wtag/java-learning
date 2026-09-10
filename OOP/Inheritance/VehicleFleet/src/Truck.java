public class Truck extends Vehicle {
    private double cargoCapacityTons;

    public Truck(String vehicleId, String model, double baseDailyRate, double cargoCapacityTons){
        super(vehicleId, model, baseDailyRate);
        this.cargoCapacityTons = cargoCapacityTons;
    }

    @Override 
    public double calcRentalCost(int days){
        if(days < 0) return 0;

        double rent = super.calcRentalCost(days);

        if(cargoCapacityTons > 5){
            rent += days*50;
        } 

        return rent;
    }

    @Override 
    public String getDetails(){
        String details = super.getDetails() + " | Cargo: " + cargoCapacityTons + " tons";
        return details;
    }
    
}
