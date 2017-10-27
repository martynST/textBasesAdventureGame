import java.util.Scanner;

import static java.lang.System.exit;

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
        System.out.println(enemy.getEncounterText());
        try {
            Thread.sleep(1000);
        } catch (Exception e) {

        }
        System.out.println("\n--BATTLE!--\n");
        this.hero = hero;
        this.enemy = enemy;

        rollInitiative();
        System.out.println("Your Initiative: " + heroInitiative);
        System.out.println("Enemy Initiative: " + enemyInitiative);
        try {
            Thread.sleep(1000);
        } catch (Exception e) {

        }
        while(hero.getIsAlive() && enemy.getIsAlive())
        {
            if (heroInitiative > enemyInitiative)
            {
                heroTurn();
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {

                }
                if (enemy.getIsAlive())
                {
                    enemyTurn();
                }
            } else {
                enemyTurn();
                if (hero.getIsAlive())
                {
                    heroTurn();
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {

                    }
                }
            }
        }
        if (enemy.getIsAlive())
        {
            System.out.println("You Died!");
            return false;
        } else {
            System.out.println("You beat " + enemy.getName() + "!");
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
        System.out.println("\n--Enemy Turn--\n");
        rollHit(enemy,hero);
    }
    private void heroTurn()
    {
        System.out.println("\n--Player Turn--\n");
        System.out.println("You have " + hero.getHitPoints() + " hit points left.");
        System.out.print("What would you like to do? ");
        boolean isValid = false;
        while (!isValid)
        {
            String action = nextLine();
            switch (action)
            {
                case "ATTACK":
                case "A":
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
        int roll = (int) Math.floor(modifier+1+Math.random()*20);
        return (roll >= 1) ?  roll : 1;
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
        return (roll + modifier >= 1) ? roll + modifier : 1;
    }
    private String nextLine()
    {
        Scanner input = new Scanner(System.in);
        String theirInput =  input.nextLine().toUpperCase();
        if (theirInput.equals("EXIT") || theirInput.equals("QUIT"))
            exit(0);
        return theirInput;
    }

}
