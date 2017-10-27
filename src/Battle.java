public class Battle {//battleSystem
    Hero hero;
    Enemy enemy;
    public Battle(Hero hero, Enemy enemy)
    {
        this.hero = hero;
        this.enemy = enemy;
        fightStart();
    }
    private void fightStart()
    {

    }
    private int d20(int modifier)
    {
        return (int) Math.floor(modifier+1+Math.random()*20);
    }
    private int d6(int modifier)
    {
        return (int) Math.floor(modifier+1+Math.random()*6);
    }
}
