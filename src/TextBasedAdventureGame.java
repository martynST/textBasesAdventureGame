import java.util.Scanner;

public class TextBasedAdventureGame {
    private static Scanner input = new Scanner(System.in);
    private static Map map = new Map();
    private static boolean keepGoing = true;
    public static void main(String[] args)
    {
        TextBasedAdventureGame game = new TextBasedAdventureGame();

        game.greating();
        while (keepGoing)
        {
            System.out.print(":>");
            game.listener();
        }
    }
    private void greating()
    {
        System.out.println("Hello, ");
        System.out.println("---New Game----");
        System.out.println("---load game---");
        System.out.println("-----Help------");
        String startMenu;
        while (true)
        {
            startMenu = nextLine();
            switch (startMenu)
            {
                case "NEW GAME":
                    newGame();
                    break;
            }
        }
    }
    private void newGame()
    {
        System.out.println("Hello and welcome to blah, you must now make your character");
        while (true)
        {
            Hero hero = characterCreation();
            System.out.println("\n" + hero.getStats() + "\n");
            System.out.print("Please confirm you would like to play as this character (y/n): ");
            if (getYesNo())
            {
                break;
            } else {
                System.out.println("Please re-enter you character details");
            }

        }
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
        System.out.println("Hello, " + name + ". Next you must allocate your attribute points. You can have a max of 10 and a minimum of 1 in each attribute, and have 30 attribute points to spend.");
        int[] stats = new int[5];
        String[] statsName = {"Intelligence", "Dexterity", "Constitution", "Perception", "Strength"};
        for (int i = 0; i < 5; i++)
        {
            System.out.println("Points remaining: " + points);
            System.out.print(statsName[i] + ": ");
            stats[i] = getAttributeAllocation(points);
            points -= stats[i];
        }
        Hero hero = new Hero(name, stats);
        return hero;
    }
    private int getAttributeAllocation(int points)
    {
        int attributeInput;
        while (true){
            try {
                attributeInput = input.nextInt();
                if (attributeInput < 1 || attributeInput > 10)
                    System.out.print("Please enter a number between 1 and 10 inclusive: \n");
                else if (points - attributeInput < 0)
                    System.out.println("You do not have enough attribute points remaining, you have " + points + "points left: ");
                else
                    return  attributeInput;
            } catch (Exception e) {
                System.out.print("Invalid input, please enter a number: ");
            }
        }
    }
    private void listener()
    {
        String thierInput = nextLine();
        switch (thierInput)
        {
            case "NORTH":

            case "N":
                if (map.getCurrentRoom().getCanGoNorth())
                    System.out.println("You headed North.");
                else
                    System.out.println("You cannot go North from here");
                break;
            case "EAST":
            case "E":
                if (map.getCurrentRoom().getCanGoEast())
                    System.out.println("You headed East.");
                else
                    System.out.println("You cannot go East from here");
                break;
            case "SOUTH":
            case "S":
                if (map.getCurrentRoom().getCanGoSouth())
                    System.out.println("You headed South.");
                else
                    System.out.println("You cannot go South from here");
                break;
            case "WEST":
            case "W":
                if (map.getCurrentRoom().getCanGoWest())
                    System.out.println("You headed West.");
                else
                    System.out.println("You cannot go West from here");
                break;
            default:
                System.out.println("Invlid input.");
        }
    }
    private void saveGame()
    {

    }
    private void loadGame()
    {

    }

    private String nextLine()
    {
        return input.nextLine().toUpperCase();
    }


}


