import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class Passenger {

    private String name;
    private int bags;
    private Flight flight;
    private int seat;

    public Passenger(String name, int bags){
        this.name = name;
        this.bags = bags;
        this.flight = flight;
        this.seat = seat;
    }

    public String getName(){
        return this.name;
    }

    public int getBags(){
        return this.bags;
    }

    public Flight getFlight() {
        return this.flight;
    }

    public void assignFlight(Flight flight) {
        this.flight = flight;
    }

    public int getSeat() {
        return this.seat;
    }

}
