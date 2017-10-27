public abstract class Character {
    private String name;
    private int intelligence;
    private int dexterity;
    private int constitution;
    private int perception;
    private int strength;
    private int hitPoints;
    public Character(String name, int[] stats)
    {
        this.name = name;
        this.intelligence = stats[0];
        this.dexterity = stats[1];
        this.constitution = stats[2];
        this.perception = stats[3];
        this.strength = stats[4];
        this.hitPoints = 5*constitution;
    }

    public String getStats() {
        return "Name: " + name + "\nIntelligence: " + intelligence + "\nDexterity: " + dexterity + "\nConstitution: " + constitution + "\nPerception: " + perception + "\nStrength: " + strength;
    }
}
