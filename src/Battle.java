import java.util.Scanner;

public class Battle {//battleSystem
    private Hero hero;
    private Enemy enemy;
    private int heroInitiative;
    private int enemyInitiative;

    public Battle()
    {

    }
    public boolean fightStart(Hero hero, Enemy enemy)
    {
        System.out.println("--BATTLE!--");
        this.hero = hero;
        this.enemy = enemy;

        rollInitiative();
        System.out.println("Your Initiative: " + heroInitiative);
        System.out.println("Enemy Initiative: " + enemyInitiative);

        while(hero.getIsAlive() && enemy.getIsAlive())
        {
            if (heroInitiative > enemyInitiative)
            {
                heroTurn();
                if (enemy.getIsAlive())
                {
                    enemyTurn();
                }
            } else {
                enemyTurn();
                if (hero.getIsAlive())
                {
                    heroTurn();
                }
            }
        }
        if (enemy.getIsAlive())
        {
            return false;
        } else {
            return true;
        }
    }
    private void rollInitiative()
    {
        this.heroInitiative = d20(hero.getDexModifier());
        this.enemyInitiative = d20(enemy.getDexModifier());
    }
    private void enemyTurn()
    {
        System.out.println("Enemy has " + enemy.getHitPoints() + " hit points left.");
        System.out.println("--Enemy Turn--");
        rollHit(enemy,hero);
    }
    private void heroTurn()
    {
        System.out.println("You have " + hero.getHitPoints() + " hit points left.");
        System.out.print("What would you like to do? ");
        boolean isValid = false;
        while (!isValid)
        {
            String action = nextLine();
            switch (action)
            {
                case "ATTACK":
                    isValid = true;
                    rollHit(hero,enemy);
                    break;
                case "RUN":
                    isValid = true;
                    System.out.println("YOU CANNOT FLEE COWARD!!!");
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }


    }
    private void rollHit(Character c1, Character c2)
    {
        int roll = d20(c1.getStrModifier());
        System.out.println(c1.getName() + " rolled " + roll);
        if (roll  >= c2.getAc())
        {
            int hit = d6(2,c1.getStrModifier());
            System.out.println("The attack hit for " + hit + " points of damage");
            c2.getHit(hit);
        } else {
            System.out.println("The attack missed.");
        }
    }
    private int d20(int modifier)
    {
        return (int) Math.floor(modifier+1+Math.random()*20);
    }
    private int d20(int num, int modifier)
    {
        int roll = 0;
        for (int i = 0; i < num; i++)
        {
            roll += (int) Math.floor(1+Math.random()*20);
        }
        return roll + modifier;
    }
    private int d6(int modifier)
    {
        return (int) Math.floor(modifier+1+Math.random()*6);
    }
    private int d6(int num, int modifier)
    {
        int roll = 0;
        for (int i = 0; i < num; i++)
        {
            roll += (int) Math.floor(1+Math.random()*6);
        }
        return roll + modifier;
    }
    private String nextLine()
    {
        Scanner input = new Scanner(System.in);
        return input.nextLine().toUpperCase();
    }

}
