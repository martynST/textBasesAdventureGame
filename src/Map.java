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
        myRooms[0][1] = new TempRoom1();
        this.x = 0;
        this.y = 0;
        this.currentRoom = myRooms[x][y];
    }

    public char[][] getMyMap() {
        return myMap;
    }

    public int[] getCurrentLcation() {
        int[] currentLcation = {x,y};
        return currentLcation;
    }

    public Room[][] getMyRooms() {
        return myRooms;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }
}
