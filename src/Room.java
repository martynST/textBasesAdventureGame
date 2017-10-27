public class Room {
    private boolean canGoNorth;
    private boolean canGoEast;
    private boolean canGoSouth;
    private boolean canGoWest;

    public Room(boolean canGoNorth, boolean canGoEast, boolean canGoSouth, boolean canGoWest)
    {
        this.canGoNorth = canGoNorth;
        this.canGoEast = canGoEast;
        this.canGoSouth = canGoSouth;
        this.canGoWest = canGoWest;
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


}
