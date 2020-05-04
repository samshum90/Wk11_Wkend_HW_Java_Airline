import java.time.LocalTime;
import java.util.ArrayList;

public class Flight {

    private ArrayList<Passenger> booked;
    private Plane plane;
    private String flightNumber;
    private String destination;
    private String departureAirport;
    private LocalTime time;

    public Flight(Plane plane, String flightNumber, String destination, String departureAirport, LocalTime time){
        this.booked = new ArrayList<Passenger>();
        this.plane = plane;
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.departureAirport = departureAirport;
        this.time = time;
    }

    public int bookedCount() {
        return this.booked.size();
    }

    public Plane getPlane(){
        return this.plane;
    }

    public String getFlightNumber() {
        return this.flightNumber;
    }

    public String getDestination() {
        return this.destination;
    }

    public String getDepartureAirport() {
        return this.departureAirport;
    }

    public LocalTime getTime() {
        return this.time;
    }

    public PlaneType getPlaneType(){
        return this.plane.getPlaneType();
    }

    public void addPassenger(Passenger passenger) {
        this.booked.add(passenger);
    }

    public int getCapacity() {
        return this.plane.getCapacity();
    }

    public int availibleSeats() {
        return getCapacity() - bookedCount();
    }
    public Boolean availableSeatsCheck() {
        Boolean seatsAvailable = true;
         if( bookedCount() > getCapacity()){
             seatsAvailable = false;
         }
         return seatsAvailable;
    }

    public void bookPassenger(Passenger passenger) {
        if(availableSeatsCheck()){
            addPassenger(passenger);
        }
    }

    public double getTotalWeight() {
        return this.plane.getTotalWeight();
    }

}
