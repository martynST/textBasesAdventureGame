import java.util.Scanner;

import static java.lang.System.exit;

public class TrapRoom extends Room{
    private boolean isActive;
    private Hero hero;
    private int perceptionNeeded;
    private int difficultyDisarm;
    private int difficultyAvoid;
    private String discription2;

    public TrapRoom(boolean north, boolean east, boolean south, boolean west, String discription, int perceptionNeeded, int difficultyDisarm,  int difficultyAvoid, String discription2)
    {
        super(north ,east, south, west, discription);
        this.isActive = true;
        this.perceptionNeeded = perceptionNeeded;
        this.difficultyDisarm = difficultyDisarm;
        this.difficultyAvoid = difficultyAvoid;
        this.discription2 = discription2;
    }
    public void encounter(Hero hero)
    {
        this.hero = hero;
        System.out.println("Rolling perception... ");
        int roll = d20(hero.getPerModifier());
        System.out.print(roll+"\n");
        if (roll >= this.perceptionNeeded)
        {
            System.out.println("You notice a trap in the middle of the room.\nWould you like to try to DISARM the trap, attempt to AVOID it, or just WALK straight through it?\n:> ");
            boolean isValid = false;
            String theirChoice;
            while (!isValid)
            {
                theirChoice = nextLine();
                switch (theirChoice)
                {
                    case "DISARM":
                    case "D":
                        isValid = true;
                        disarmTrap();
                        break;
                    case "AVOID":
                    case "A":
                        isValid = true;
                        avoidTrap();
                        break;
                    case "WALK":
                    case "W":
                        isValid = true;
                        walkThroughTrap();
                        break;
                    default:
                        System.out.println("Invalid Input. :> ");
                }
            }
        } else {
            walkThroughTrap();
        }
    }
    public void updateDiscription()
    {
        super.updateDiscription(this.discription2);
    }
    public boolean getIsActive()
    {
        return isActive;
    }
    private void disarmTrap()
    {
        System.out.println("You attempt to disarm the trap...");
        System.out.print("Rolling intelligence...");
        try {
            Thread.sleep(500);
        } catch (Exception e) {

        }
        int roll = d20(hero.getIntModifier());
        System.out.print(roll+"\n");
        if (roll >= difficultyDisarm)
        {
            System.out.println("You disarmed the trap.");
        } else {
            System.out.println("You failed to disarm the trap and it went off.");
            System.out.print("Rolling damage... ");
            int hit = d6(2,2);
            System.out.print(hit+"\n");
            hero.getHit(hit);
            System.out.println("You have " + hero.getHitPoints() + " hit points remaining");
            this.isActive = false;
        }
    }
    private void avoidTrap()
    {
        System.out.println("You attempt to avoiding the trap...");
        System.out.print("Rolling dexterity...");
        try {
            Thread.sleep(500);
        } catch (Exception e) {

        }
        int roll = d20(hero.getDexModifier());
        System.out.print(roll+"\n");
        if (roll >= difficultyAvoid)
        {
            System.out.println("You avoided the trap, this time.");
        } else {
            System.out.println("You failed to avoid the trap and it went off.");
            System.out.print("Rolling damage... ");
            int hit = d6(2,2);
            System.out.print(hit+"\n");
            hero.getHit(hit);
            System.out.println("You have " + hero.getHitPoints() + " hit points remaining");
            this.isActive = false;
        }
    }
    private void walkThroughTrap()
    {
        System.out.println("You walked through a trap.");
        System.out.print("Rolling damage... ");
        int hit = d6(2,2);
        System.out.print(hit+"\n");
        hero.getHit(hit);
        System.out.println("You have " + hero.getHitPoints() + " hit points remaining");
        this.isActive = false;
    }
    private String nextLine()
    {
        Scanner input = new Scanner(System.in);
        String theirInput =  input.nextLine().toUpperCase();
        if (theirInput.equals("EXIT") || theirInput.equals("QUIT"))
                exit(0);
        return theirInput;
    }
    private int d20(int modifier)
    {
        int roll = (int) Math.floor(modifier+1+Math.random()*20);
        return (roll >= 1) ?  roll : 1;
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
}
