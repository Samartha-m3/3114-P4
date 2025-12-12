

public class Drone extends AirObject {
    private String brand;
    private int numEngines;

    public Drone(String name, int x, int y, int z, int xwid, int ywid, int zwid,
                 String b, int engines) {
        super(name, x, y, z, xwid, ywid, zwid);
        if (b == null || engines <= 0) {
            this.setInvalid(); 
        }
        this.brand = b;
        this.numEngines = engines;
    }
    
    public String getBrand() {
        return brand;
    }
    
    public int getNumEngines() {
        return numEngines; 
    }
    
    @Override
    public String toString() {
        return String.format("Drone %s %d %d %d %d %d %d %s %d",
            getName(), getXorig(), getYorig(), getZorig(),
            getXwidth(), getYwidth(), getZwidth(),
            brand, numEngines);
    }
}