public class Room {
    private boolean canGoNorth;
    private boolean canGoEast;
    private boolean canGoSouth;
    private boolean canGoWest;
    private String discription;
    private int AC;

    public Room(boolean canGoNorth, boolean canGoEast, boolean canGoSouth, boolean canGoWest, String discription)
    {
        this.canGoNorth = canGoNorth;
        this.canGoEast = canGoEast;
        this.canGoSouth = canGoSouth;
        this.canGoWest = canGoWest;
        this.discription = discription;
        this.AC = 15;
    }

    public boolean getCanGoNorth()
    {
        return canGoNorth;
    }
    public boolean getCanGoEast()
    {
        return canGoEast;
    }
    public boolean getCanGoSouth()
    {
        return canGoSouth;
    }
    public boolean getCanGoWest()
    {
        return canGoWest;
    }

    public String getDiscription() {
        return discription;
    }
}
