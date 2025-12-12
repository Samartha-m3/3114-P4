

public class Balloon extends AirObject {
    private String type;
    private int ascent_rate; 

    public Balloon(String name, int x, int y, int z, int xwid, int ywid, int zwid,
                    String t, int rate) {
        super(name, x, y, z, xwid, ywid, zwid);
        if (t == null || rate <= 0) {
            this.setInvalid(); 
        }
        type = t;
        ascent_rate = rate; 
    }
    
    public String getType(){
        return type; 
    }
    
    public int getAscentRate(){
        return ascent_rate; 
    }
    
    @Override
    public String toString() {
        return String.format("Balloon %s %d %d %d %d %d %d %s %d",
            getName(), getXorig(), getYorig(), getZorig(),
            getXwidth(), getYwidth(), getZwidth(),
            type, ascent_rate);
    }
    
}