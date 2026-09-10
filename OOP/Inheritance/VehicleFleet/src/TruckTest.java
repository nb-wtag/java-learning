
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TruckTest {

    @Test
    void calcRentalCost_should_return_zero() {
        //GIVEN
        Truck truck = new Truck("T1", "M1", 50, 10);

        //WHEN
        double rent = truck.calcRentalCost(-10);

        //THEN
        assertEquals(0, rent);
    }

    @Test
    void calcRentalCost_when_no_roadTax(){
        //GIVEN
        //If cargo <= 5, no road tax
        Truck truck = new Truck("T1", "M1", 50, 5);

        //WHEN
        double rent = truck.calcRentalCost(1);

        //THEN
        assertEquals(50, rent);
    }

    @Test
    void calcRentalCost_when_roadTax_present(){
        //GIVEN
        //If cargo > 5, additional rs50/day 
        Truck truck = new Truck("T1", "M1", 50, 10);

        //WHEN
        double rent = truck.calcRentalCost(1);

        //THEN
        assertEquals(100, rent);
    }

    @Test
    void getDetails_success(){
        //GIVEN
        Truck truck1 = new Truck("G3024", "Unimog", 70000.00, 15);
        String expected = "ID: G3024 | Model: Unimog | Base Rate: Rs70000.0/day | Cargo: 15.0 tons";

        //WHEN
        String actual = truck1.getDetails();

        //THEN
        assertEquals(expected, actual);
    }
}
