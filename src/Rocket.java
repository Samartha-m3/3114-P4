

public class Rocket extends AirObject {
    private int ascent_rate; 
    private double trajectory; 

    public Rocket(String name, int x, int y, int z, int xwid, int ywid, int zwid,
                    int rate, double traj) {
        super(name, x, y, z, xwid, ywid, zwid);
        if (rate <= 0 || traj <= 0) {
            this.setInvalid();
        }
        ascent_rate = rate; 
        trajectory = traj; 
    }
    
    public int getAscentRate(){
        return ascent_rate; 
    }
    
    public double getTrajectory(){
        return trajectory; 
    }
    
    @Override
    public String toString() {
        return String.format("Rocket %s %d %d %d %d %d %d %d %.2f",
            getName(), getXorig(), getYorig(), getZorig(),
            getXwidth(), getYwidth(), getZwidth(),
            ascent_rate, trajectory);
    }
    
}