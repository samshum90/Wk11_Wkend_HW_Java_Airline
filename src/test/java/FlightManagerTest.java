import org.junit.Before;
import org.junit.Test;

import java.time.LocalTime;

import static org.junit.Assert.assertEquals;

public class FlightManagerTest {

    private FlightManager flightManager1;
    private FlightManager flightManager2;
    private Flight flight;
    private Flight smallFlight;
    private Plane plane;
    private Plane plane2;
    private Passenger passenger1;
    private Passenger passenger2;
    private Passenger passenger3;


    @Before
    public void before(){
        plane = new Plane(PlaneType.AIRBUSA300);
        plane2 = new Plane(PlaneType.DOUGLASDC8);
        flight = new Flight(plane, "ED3434", "LON", "EDI", LocalTime.parse("19:10"));
        smallFlight = new Flight(plane2, "RO054", "ABD", "EDI", LocalTime.parse("17:35"));
        passenger1 = new Passenger("Sam", 2);
        passenger2 = new Passenger("Tony", 1);
        passenger3 = new Passenger("Sid", 3);
        flightManager1 = new FlightManager(flight);
        flightManager2 = new FlightManager(smallFlight);
    }

    //    calculate how much baggage weight should be reserved for each passenger for a flight

    @Test
    public void assignBagWeight() {
        assertEquals(200, flightManager1.reservedBagWeight(), 0.1);
    }

    @Test
    public void getBagWeightPerAPerson(){
        assertEquals( 4, flightManager1.bagWeightPerAPerson(), 0.01);
    }
// calculate how much baggage weight is booked by passengers of a flight
    @Test
    public void totalBagWeight() {
        flight.addPassenger(passenger1);
        flight.addPassenger(passenger2);
        flight.addPassenger(passenger3);
        assertEquals( 12.00, flightManager1.totalBagWeight(), 0.01);
    }
    // calculate how much overall weight reserved for baggage remains for a flight
    @Test
    public void remainingBagWeight(){
        flight.addPassenger(passenger1);
        flight.addPassenger(passenger2);
        flight.addPassenger(passenger3);
        assertEquals(188.00, flightManager1.remaingingBagWeight(), 0.01);
    }

    @Test
    public void bookFlight(){
        flightManager1.bookPassenger(passenger1, flight);
        assertEquals( flight, passenger1.getFlight());
        assertEquals( 1, flight.bookedCount());
    }


}
