public class Map {
    //hard coded map
    private char[][] myMap = new char[1][2];
    private Room[][] myRooms = new Room[1][2];
    private int x;
    private int y;
    private Room currentRoom;

    public Map()
    {
        myMap[0][0] = 'S';
        myMap[0][1] = 'R';
        myRooms[0][0] = new TempStartingRoom();
        myRooms[0][1] = new FightRoom();
        this.x = 0;
        this.y = 0;
        this.currentRoom = myRooms[x][y];
    }

    public String getCurrentRoomDiscription ()
    {
        return currentRoom.getDiscription();
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }
    public void moveRoom(String direction)
    {
        switch (direction)
        {
            case "NORTH":
                x--;
                break;
            case "EAST":
                y++;
                break;
            case "SOUTH":
                x++;
                break;
            case "WEST":
                y--;
                break;
        }
        updateRoom();
    }
    private void updateRoom()
    {
        currentRoom = myRooms[x][y];
    }
}
