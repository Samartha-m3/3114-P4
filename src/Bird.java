

public class Bird extends AirObject {
    private String type;
    private int number;

    public Bird(String name, int x, int y, int z, int xwid, int ywid, int zwid,
                String t, int num) {
        super(name, x, y, z, xwid, ywid, zwid);
        if (t == null || num <= 0) {
            this.setInvalid(); 
        }
        this.type = t;
        this.number = num;
    }
    
    public String getType() {
        return type; 
    }
    
    public int getNumber() {
        return number; 
    }
    
    @Override
    public String toString() {
        return String.format("Bird %s %d %d %d %d %d %d %s %d",
            getName(), getXorig(), getYorig(), getZorig(),
            getXwidth(), getYwidth(), getZwidth(),
            type, number);
    }
}