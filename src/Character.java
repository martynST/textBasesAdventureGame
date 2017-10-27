public abstract class Character {
    private String name;
    private int[] stats = new int[5];
    private int[] statModifiers = new int[5];
    private int hitPoints;
    private boolean isAlive = true;
    private int ac;


    public Character(String name, int[] stats, int ac)
    {
        this.name = name;
        this.stats = stats;
        this.ac = ac;
        this.hitPoints = 3*stats[2];
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

    public boolean getIsAlive()
    {
        return isAlive;
    }

    public int getHitPoints() {
        return hitPoints;
    }
    public int getIntModifier() { return statModifiers[0]; }
    public int getDexModifier() { return statModifiers[1]; }
    public int getConModifier() { return statModifiers[2]; }
    public int getPerModifier() { return statModifiers[3]; }
    public int getStrModifier() { return statModifiers[4]; }
    public int[] getStatModifiers() {
        return statModifiers;
    }

    public int getAc() {
        return ac;
    }
    public void getHit(int hit)
    {
        this.hitPoints -= hit;
        updateIsAlive();
    }
    private void updateIsAlive()
    {
        if (hitPoints <= 0)
            isAlive = false;
    }
    public String getName() {
        return name;
    }

    public String getStats() {
        return "Name: " + name + "\nIntelligence: " + stats[0] + " (" + statModifiers[0] + ")\nDexterity: " + stats[1] + " (" + statModifiers[1] + ")\nConstitution: " + stats[2] + " (" + statModifiers[2] + ")\nPerception: " + stats[3] + " (" + statModifiers[3] + ")\nStrength: " + stats[4] + " (" + statModifiers[4] + ")";
    }
}
