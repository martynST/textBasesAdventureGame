public class Map {
    //hard coded map
    private Room[][] myRooms = new Room[3][3];
    private int x;
    private int y;
    private Room currentRoom;

    public Map()
    {

        myRooms[0][0] = new TempStartingRoom(false, true, false, false,"You Find yourself in a cave with a path leading east.");
        myRooms[0][1] = new FightRoom(false, false, true, true, "You continue along the cave...");
        myRooms[1][2] = new TrapRoom(true, true, true, true, "You exit the cave.");

        this.x = 0;
        this.y = 0;
        this.currentRoom = myRooms[x][y];
    }

    public String getCurrentRoomDiscription ()
    {
        String output =  currentRoom.getDiscription();
        if (currentRoom instanceof FightRoom && ((FightRoom) currentRoom).getIsAlive())
        {
            output += "\n" + ((FightRoom) currentRoom).getEnemyEncounterText();
        }
        return output;
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
