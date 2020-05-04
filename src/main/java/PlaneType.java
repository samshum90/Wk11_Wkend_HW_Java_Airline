public enum PlaneType {

    CESSNA(6, 400.00),
    BOEING747(100, 500.50),
    AIRBUSA300(50, 400.00),
    DOUGLASMD80(2, 10.00),
    DOUGLASDC8(3, 3000.53);

    private final int capacity;
    private final double totalWeight;

    PlaneType(int capacity, double totalWeight){
        this.capacity = capacity;
        this.totalWeight = totalWeight;
    }

    public int getCapacity(){
        return this.capacity;
    }

    public double getTotalWeight(){
        return this.totalWeight;
    }
}
