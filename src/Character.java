public abstract class Character {
    private String name;
    private int[] stats = new int[5];
    private int[] statModifiers = new int[5];
    private int hitPoints;


    public Character(String name, int[] stats)
    {
        this.name = name;
        this.stats = stats;
        this.hitPoints = 5*stats[2];
        setModifiers();
    }
    private void setModifiers()
    {
        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 11; j++)
            {
                if (stats[i] >= 20-j*2)
                {
                    this.statModifiers[i] = 5 - j;
                    break;
                }
            }
        }

    }

    public String getStats() {
        return "Name: " + name + "\nIntelligence: " + stats[0] + " (" + statModifiers[0] + ")\nDexterity: " + stats[1] + " (" + statModifiers[1] + ")\nConstitution: " + stats[2] + " (" + statModifiers[2] + ")\nPerception: " + stats[3] + " (" + statModifiers[3] + ")\nStrength: " + stats[4] + " (" + statModifiers[4] + ")";
    }
}
