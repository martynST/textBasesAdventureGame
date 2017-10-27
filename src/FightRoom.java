public class FightRoom extends Room{
    private Enemy enemy;
    private String discription2;
    private boolean isBoss;

    public FightRoom(boolean north, boolean east, boolean south, boolean west, String discription, Enemy enemy, String discription2, boolean isBoss)
    {
        super(north ,east, south, west, discription);
        this.enemy = enemy;
        this.isBoss = isBoss;
        this.discription2 = discription2;
    }
    public boolean getIsAlive()
    {
        return enemy.getIsAlive();
    }
    public void discription2() {
        super.updateDiscription(discription2);
    }
    public String getEnemyEncounterText()
    {
        return enemy.getEncounterText();
    }
    public Enemy getEnemy()
    {
        return enemy;
    }
    public boolean getIsBoss()
    {
        return this.isBoss;
    }
}
