public class FightRoom extends Room{
    private Enemy enemy;

    public FightRoom(boolean north, boolean east, boolean south, boolean west, String discription)
    {
        super(north ,east, south, west, discription);
        int[] enemyStats = {20,20,20,20,20};
        this.enemy = new Enemy("Seymour", enemyStats, 15,"Stop fool! Tis I, Seymour");
    }
    public boolean getIsAlive()
    {
        return enemy.getIsAlive();
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
