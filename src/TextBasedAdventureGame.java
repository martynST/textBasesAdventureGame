import java.util.Random;
import java.util.Scanner;

public class TextBasedAdventureGame {
    private Scanner input = new Scanner(System.in);
    private Map map;
    private boolean keepGoing = true;
    private Hero hero;
    private Battle battle = new Battle();

    public static void main(String[] args)
    {
        TextBasedAdventureGame game = new TextBasedAdventureGame();

        game.greeting();
        while (game.keepGoing)
        {
            System.out.println(game.map.getCurrentRoomDiscription());
            if (game.map.getCurrentRoom() instanceof FightRoom && ((FightRoom) game.map.getCurrentRoom()).getIsAlive())
            {
                if (game.battle.fightStart(game.hero, ((FightRoom) game.map.getCurrentRoom()).getEnemy()))
                {
                    System.out.println("You beat " + ((FightRoom) game.map.getCurrentRoom()).getEnemy().getName() + "!");
                } else {
                    System.out.println("You Died\nGame Over");
                    game.keepGoing = false;
                    continue;
                }
            }

            System.out.print(":>");
            game.listener();
        }
    }

    private void greeting()
    {
        System.out.println("Hello, ");
        System.out.println("--------------");
        System.out.println("---New Game---");
        System.out.println("---xxxxxxxx---");
        System.out.println("-----Help-----");
        System.out.println("--------------");
        String startMenu;
        boolean startGame = false;
        while (!startGame)
        {
            startMenu = nextLine();
            switch (startMenu)
            {
                case "NEW GAME":
                    newGame();
                    map = new Map();
                    startGame = true;
                    break;
                case "HELP":
                    getHelp();
                    break;
                default:
                    System.out.print("Invalid input\n:> ");
            }
        }
    }
    private void newGame()
    {
        System.out.println("Hello and welcome to blah, you must now make your character");
        hero = characterCreation();
        System.out.println("\n" + hero.getStats() + "\n");
    }
    private void getHelp()
    {
        System.out.println("Type 'N' or 'North' to go North");
        System.out.println("Type 'E' or 'East' to go East");
        System.out.println("Type 'S' or 'South' to go South");
        System.out.println("Type 'W' or 'West' to go West");
    }
    private boolean getYesNo()
    {
        String yesNo;
        while (true)
        {
            yesNo = nextLine();

            if (yesNo.equals("YES") || yesNo.equals("Y"))
                return true;
            else if (yesNo.equals("NO") || yesNo.equals("N"))
                return false;
            else
                System.out.print("Invalid input, please enter yes or no: ");
        }
    }
    private Hero characterCreation()
    {
        int points = 30;
        System.out.print("Please enter the name of your character: ");
        String name = input.nextLine();
        System.out.println("Hello, " + name + ". Next you must set your attribute points. You may either roll for your stat or take the average roll value of 10");
        int[] stats = new int[5];
        String[] statsName = {"Intelligence", "Dexterity", "Constitution", "Perception", "Strength"};
        for (int i = 0; i < 5; i++)
        {
            System.out.println(statsName[i] + ": ");
            stats[i] = getAttributeAllocation(points);
            System.out.println("Your " + statsName[i] + " is " + stats[i]);
            points -= stats[i];
        }
        Hero hero = new Hero(name, stats, 13);
        return hero;
    }
    private int getAttributeAllocation(int points)
    {
       System.out.print("Would you like to roll for this stat? (y/n): ");
       boolean yesNo = getYesNo();
       if (yesNo)
       {
           return (int) Math.floor(1+Math.random()*20);
       } else {
           return 10;
       }
    }
    private void listener()
    {
        String theirInput = nextLine();
        switch (theirInput)
        {
            case "NORTH":

            case "N":
                if (map.getCurrentRoom().getCanGoNorth())
                {
                    System.out.println("You headed North.");
                    map.moveRoom("NORTH");
                } else {
                    System.out.println("You cannot go North from here");
                }
                break;
            case "EAST":
            case "E":
                if (map.getCurrentRoom().getCanGoEast()) {
                    System.out.println("You headed East.");
                    map.moveRoom("EAST");
            } else {
                    System.out.println("You cannot go East from here");
                }
                break;
            case "SOUTH":
            case "S":
                if (map.getCurrentRoom().getCanGoSouth()) {
                    System.out.println("You headed South.");
                    map.moveRoom("SOUTH");
                } else {
                    System.out.println("You cannot go South from here");
                }
                break;
            case "WEST":
            case "W":
                if (map.getCurrentRoom().getCanGoWest()) {
                    System.out.println("You headed West.");
                    map.moveRoom("WEST");
                } else {
                    System.out.println("You cannot go West from here");
                }
                break;
            default:
                System.out.println("Invalid input.");
        }
    }
    private String nextLine()
    {
        return input.nextLine().toUpperCase();
    }


}


