public class Map {
    //hard coded map
    private Room[][] myRooms = new Room[3][3];
    private int x;
    private int y;
    private Room currentRoom;

    public Map()
    {

        myRooms[0][0] = new EmptyRoom(false, true, false, false,"You Find yourself in a cave with a path leading east.");
        int[] enemyStats = {10,10,10,10,10};
        myRooms[0][1] = new FightRoom(false, false, true, true, "You continue along the cave...",new Enemy("Seymour", enemyStats, 15,"Stop fool! Tis I, Seymour"), "You have a path to the west and a path leading south.",false);
        myRooms[1][1] = new TrapRoom(true, true, true, true, "As you walk through the cave you see some light in the distance.", 10,13,10, "You have exited the cave, there are paths leading in all direction.");
        myRooms[1][0] = new EmptyRoom(false, true,false,false,"Not much here, just the path you came down");
        myRooms[1][2] = new EmptyRoom(true,true,false,false,"You see a path to the North and East");
        myRooms[2][1] = new EmptyRoom(false,false,true,true,"You see a path to the South and West");
        int[] enemyStats2 = {18,16,18,12,29};
        myRooms[2][2] = new FightRoom(true, false, false, true, "You see some guy", new Enemy("Seymour the Scientist", enemyStats2, 17, "TIS I, THE ONE TRUE SEYMOUR THE SCIENTIST!!!"),"You won the game",true);
        this.x = 0;
        this.y = 0;
        this.currentRoom = myRooms[x][y];
    }

    public String getCurrentRoomDiscription ()
    {
        String output = currentRoom.getDiscription();
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
        this.currentRoom = this.myRooms[this.x][this.y];
    }
}
