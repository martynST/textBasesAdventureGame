public abstract class Character {
    private String name;
    private int inteligence;
    private int dexterity;
    private int constitution;
    private int perception;
    private int strength;
    public Character(String name, int[] stats)
    {
        this.name = name;
        this.inteligence = stats[0];
        this.dexterity = stats[1];
        this.constitution = stats[2];
        this.perception = stats[3];
        this.strength = stats[4];
    }

    public String getStats() {
        return "Name: " + name + "\nInteligence: " + inteligence + "\nDexterity: " + dexterity + "\nConstitution: " + constitution + "\nPerception: " + perception + "\nStrength: " + strength;
    }
}
