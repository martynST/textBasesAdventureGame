public class FightRoom extends Room{
    private boolean isAlive;
    private Enemy enemy;

    public FightRoom()
    {
        super(false ,false, false, true, "You are in a room, you can only go west.");
        this.isAlive = true;
        int[] enemyStats = {10,10,10,10,10};
        this.enemy = new Enemy("Seymour", enemyStats, "Stop fool! Tis I, Seymour");
    }
    public boolean getIsAlive()
    {
        return isAlive;
    }
    public String getEnemyEncounterText()
    {
        return enemy.getEncounterText();
    }
    public Enemy getEnemy()
    {
        return enemy;
    }
}
