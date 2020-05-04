public class FlightManager {

    private Flight flight;

    public FlightManager(Flight flight){
        this.flight = flight;
    }

    public double reservedBagWeight() {
       return this.flight.getPlane().getTotalWeight() / 2;
    }

    public double bagWeightPerAPerson() {
        return reservedBagWeight() / this.flight.getPlane().getCapacity();
    }

    public double totalBagWeight() {
        return this.flight.bookedCount() * bagWeightPerAPerson();
    }

    public double remaingingBagWeight() {
        return reservedBagWeight() - totalBagWeight();
    }

    public void bookPassenger(Passenger passenger, Flight flight) {
        if(flight.availableSeatsCheck()){
            flight.addPassenger(passenger);
            passenger.assignFlight( flight);
        }
    }
}
