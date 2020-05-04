public class Plane {

    private PlaneType plane;

    public Plane(PlaneType plane){

        this.plane = plane;
    }

    public PlaneType getPlaneType(){

        return this.plane;
    }

    public int getCapacity(){

        return this.plane.getCapacity();
    }
    public double getTotalWeight(){
        return this.plane.getTotalWeight();
    }

}
