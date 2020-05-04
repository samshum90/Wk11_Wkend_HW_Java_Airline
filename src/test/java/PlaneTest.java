import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlaneTest {

    private Plane plane;

    @Before
    public void before(){
        plane = new Plane( PlaneType.BOEING747 );
    }

    @Test
    public void canGetPlaneType(){
        assertEquals( PlaneType.BOEING747, plane.getPlaneType());
    }

    @Test
    public void canReturnCapacity(){
        assertEquals( 100, plane.getCapacity());
    }

    @Test
    public void canReturnTotalWeight(){
        assertEquals( 500.50, plane.getTotalWeight(), 0.01);
    }
}
