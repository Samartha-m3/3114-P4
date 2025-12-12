

public class AirObject implements Comparable<AirObject> {
    private String name;
    private int xorig;
    private int yorig;
    private int zorig;
    private int xwidth;
    private int ywidth;
    private int zwidth;
    private boolean invalid;

    public AirObject(String name, int x, int y, int z, int xwid, int ywid, int zwid) {
        this.name = name;
        this.xorig = x;
        this.yorig = y;
        this.zorig = z;
        this.xwidth = xwid;
        this.ywidth = ywid;
        this.zwidth = zwid;
        this.invalid = false; 
    }

    public int getXorig() {
        return xorig;
    }

    public int getYorig() {
        return yorig;
    }

    public int getZorig() {
        return zorig;
    }

    public int getXwidth() {
        return xwidth;
    }

    public int getYwidth() {
        return ywidth;
    }

    public int getZwidth() {
        return zwidth;
    }

    public String getName() {
        return name;
    }

    protected void setInvalid() {
        this.invalid = true;
    }

    public boolean isInvalid() {
        return invalid;
    }

    @Override
    public int compareTo(AirObject other) {
        return this.name.compareTo(other.name);
    }

}