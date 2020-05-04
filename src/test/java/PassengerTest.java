import org.junit.Before;
import org.junit.Test;

import java.time.LocalTime;

import static org.junit.Assert.assertEquals;

public class PassengerTest {

    private Plane plane;
    private Flight flight;
    private Passenger passenger;

    @Before
    public void before(){
        plane = new Plane(PlaneType.AIRBUSA300);
        flight = new Flight(plane, "ED3434", "LON", "EDI", LocalTime.parse("19:10"));
        passenger = new Passenger( "Sam", 1 );

    }

    @Test
    public void hasName(){
        assertEquals( "Sam", passenger.getName() );
    }

    @Test
    public void hasBags(){
        assertEquals( 1, passenger.getBags() );
    }

    @Test
    public void getFlight(){
        assertEquals(null, passenger.getFlight());
    }
    @Test
    public void canAssignFlight(){
        passenger.assignFlight( flight );
        assertEquals( flight, passenger.getFlight() );
    }

    @Test
    public void getSeat(){
        assertEquals(0, passenger.getSeat());
    }
}
