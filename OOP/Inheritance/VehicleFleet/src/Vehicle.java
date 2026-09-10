public class Vehicle {
    private String vehicleId;
    private String model;
    private double baseDailyRate;

    public Vehicle(String vehicleId, String model, double baseDailyRate){
        this.vehicleId = vehicleId;
        this.model = model;
        this.baseDailyRate = baseDailyRate;
    }

    public double calcRentalCost(int days){
        if(days < 0){
            return 0;
        } else {
            return days*baseDailyRate;
        }
    }

    public String getDetails(){
        String details = "ID: " + vehicleId + " | Model: " + model + " | Base Rate: Rs" + baseDailyRate + "/day";
        return details;
    }

    public String getVehicleId(){ return vehicleId; }
    public String getModel(){ return model; }
    public double getBaseDailyRate(){ return baseDailyRate; }
}
