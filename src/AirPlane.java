

public class AirPlane extends AirObject {
    private String carrier;
    private int flightNumber;
    private int numEngines;

    public AirPlane(String name, int x, int y, int z, int xwid, int ywid, int zwid,
                    String carrier, int num, int engines) {
        super(name, x, y, z, xwid, ywid, zwid);
        if (carrier == null || num <= 0 || engines <= 0) {
            setInvalid();
        }
        this.carrier = carrier;
        this.flightNumber = num;
        this.numEngines = engines;
    }
    
    public String getCarrier(){
        return carrier; 
    }
    
    public int getFlightNumber(){
        return flightNumber; 
    }
    
    public int getNumEngines(){
        return numEngines; 
    }
    
    @Override
    public String toString() {
        return String.format("Airplane %s %d %d %d %d %d %d %s %d %d",
            getName(), getXorig(), getYorig(), getZorig(),
            getXwidth(), getYwidth(), getZwidth(),
            carrier, flightNumber, numEngines);
    }

}