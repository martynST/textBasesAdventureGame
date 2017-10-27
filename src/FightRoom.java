public class FightRoom extends Room{
    private boolean enemyAlive;
    private Enemy enemy;
    public FightRoom()
    {
        super(false ,false, false, true, "You are in a room, you can only go west.");
        this.enemyAlive = true;
        int[] enemyStats = {10,10,10,10,10};
        this.enemy = new Enemy("Seymour", enemyStats);
    }
}
