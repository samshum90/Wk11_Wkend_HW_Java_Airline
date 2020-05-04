import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.time.LocalTime;

import static org.junit.Assert.*;

public class FlightTest {

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
    }

    @Test
    public void canGetPlane(){
        assertEquals(plane, flight.getPlane());
    }

        @Test
    public void bookedStartsEmpty(){
        assertEquals( 0, flight.bookedCount());
    }

    @Test
    public void canAddPassenger(){
        flight.addPassenger(passenger1);
            assertEquals( 1, flight.bookedCount());
    }

    @Test
    public void canGetPlaneType(){
        assertEquals( PlaneType.AIRBUSA300, flight.getPlaneType());
    }

    @Test
    public void hasFlightNumber(){
        assertEquals( "ED3434", flight.getFlightNumber());
    }

    @Test
    public void hasDestination(){
        assertEquals( "LON", flight.getDestination());
    }

    @Test
    public void getDepartureAirport(){
        assertEquals( "EDI", flight.getDepartureAirport());
    }

    @Test
    public void getTime(){
        assertEquals( LocalTime.parse("19:10"), flight.getTime());
    }

    @Test
    public void canGetPlaneCapacity(){
        assertEquals(50, flight.getCapacity());
    }
    @Test
    public void canGetPlaneTotalWeight(){
        assertEquals(400.00, flight.getTotalWeight(), 0.01);
    }

    @Test
    public void returnAvailableSeats(){
        flight.addPassenger(passenger1);
        flight.addPassenger(passenger2);
        assertEquals( 48, flight.availibleSeats());
    }
    @Test
    public void returnAvailableSeatsCheck(){
        flight.addPassenger(passenger1);
        flight.addPassenger(passenger2);
        assertTrue( flight.availableSeatsCheck());
    }
    @Test
    public void returnUnavailableSeatsCheck(){
        smallFlight.addPassenger(passenger2);
        smallFlight.addPassenger(passenger2);
        smallFlight.addPassenger(passenger2);
        smallFlight.addPassenger(passenger2);
        smallFlight.addPassenger(passenger2);
        smallFlight.addPassenger(passenger2);
        smallFlight.addPassenger(passenger2);
        smallFlight.addPassenger(passenger2);
        assertFalse( smallFlight.availableSeatsCheck());
    }

    @Test
    public void canBookPassenger(){
        flight.bookPassenger(passenger1);
        assertEquals( 1, flight.bookedCount());
        assertEquals( flight, passenger1.getFlight() );
    }
    @Test
    public void flightFullBookPassenger(){
        smallFlight.bookPassenger(passenger2);
        smallFlight.bookPassenger(passenger2);
        smallFlight.bookPassenger(passenger2);
        assertEquals( 3, smallFlight.bookedCount());
    }

}
